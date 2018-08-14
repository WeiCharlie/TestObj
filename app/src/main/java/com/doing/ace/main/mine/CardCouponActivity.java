package com.doing.ace.main.mine;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.doing.ace.R;
import com.doing.ace.Util.DensityUtil;
import com.doing.ace.base.BaseActivity;
import com.doing.ace.main.mine.wigets.CardItem;
import com.doing.ace.main.mine.wigets.CardPagerAdapter;
import com.doing.ace.main.mine.wigets.ShadowTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡券包
 */
public class CardCouponActivity extends BaseActivity {

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    private ListView myCardCouponLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_coupon);

        initView();
    }

    private void initView() {

        mViewPager = findViewById(R.id.coupon_viewPager);
        myCardCouponLv = findViewById(R.id.card_coupon_lv);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(DensityUtil.dip2px(this, 15));

        myCardCouponLv.setAdapter(new CardCouponActivity.CardCouponAdapter(this, null));
    }

    public void backCoupon(View view) {
        finish();
    }

    class Item {
        private String imgUrl;
        private String name;
        private String info;
        private String trait;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getTrait() {
            return trait;
        }

        public void setTrait(String trait) {
            this.trait = trait;
        }
    }

    class CardCouponAdapter implements ListAdapter {
        private List<MyCardActivity.Item> list = new ArrayList<>();
        private Context context;

        public CardCouponAdapter(Context context, List list) {
            this.list = list;
            this.context = context;

        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = View.inflate(context, R.layout.card_coupon_lv_item, null);
            return item;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }
    }
}

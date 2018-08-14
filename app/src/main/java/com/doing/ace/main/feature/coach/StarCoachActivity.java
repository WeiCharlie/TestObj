package com.doing.ace.main.feature.coach;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.doing.ace.R;
import com.doing.ace.Util.DensityUtil;
import com.doing.ace.base.BaseActivity;
import com.doing.ace.main.feature.BannerPagerAdapter;
import com.doing.ace.main.mine.wigets.CardItem;
import com.doing.ace.main.mine.wigets.CardPagerAdapter;
import com.doing.ace.main.mine.wigets.ShadowTransformer;
import com.doing.ace.share.ShareActivity;

import java.util.ArrayList;
import java.util.List;

public class StarCoachActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ListView listView;
    private ViewPager viewPager;
    private BannerPagerAdapter adapter;
    private ShadowTransformer mCardShadowTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_coach);

        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.star_coach_vp);
        tabLayout = findViewById(R.id.star_coach_tl);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                } else if (position == 1) {

                } else if (position == 2) {
                } else if (position == 3) {
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        reflex2(tabLayout, 30);// 修改tablayout下划线宽度

        listView = findViewById(R.id.star_coach_lv);
        List<StarCoachItemBean> list = new ArrayList<>();
        list.add(new StarCoachItemBean());
        list.add(new StarCoachItemBean());
        list.add(new StarCoachItemBean());
        list.add(new StarCoachItemBean());
        list.add(new StarCoachItemBean());
        StarCoachListAdapter starCoachListAdapter = new StarCoachListAdapter(this,
                list);
        listView.setAdapter(starCoachListAdapter);


        adapter = new BannerPagerAdapter();
        adapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
        adapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
        adapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
        adapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));

        mCardShadowTransformer = new ShadowTransformer(viewPager, adapter);

        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(false, mCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(DensityUtil.dip2px(this, 15));

    }

    public void backStarCoach(View view) {
        finish();
    }
}

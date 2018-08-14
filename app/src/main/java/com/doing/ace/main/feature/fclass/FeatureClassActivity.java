package com.doing.ace.main.feature.fclass;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.doing.ace.R;
import com.doing.ace.Util.DensityUtil;
import com.doing.ace.base.BaseActivity;
import com.doing.ace.main.feature.BannerPagerAdapter;
import com.doing.ace.main.feature.gymcoach.GymCoachGVAdapter;
import com.doing.ace.main.feature.gymcoach.GymCoachGVItemBean;
import com.doing.ace.main.mine.wigets.CardItem;
import com.doing.ace.main.mine.wigets.ShadowTransformer;
import com.doing.ace.widget.CustomScrollGridview;
import com.lzt.flowviews.view.FlowView;

import java.util.ArrayList;
import java.util.List;

public class FeatureClassActivity extends BaseActivity {

    private static String[] citys = new String[]{"条件1", "条件2", "条件3", "条件4", "条件5"
            , "全选"};

    private TabLayout tabLayout;
    private CustomScrollGridview listView;
    private ViewPager viewPager;
    private BannerPagerAdapter adapter;
    private ShadowTransformer mCardShadowTransformer;
    private LinearLayout filter;
    private FlowView mStyle1FV;
    private FlowView mStyle2FV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_class);
        initViews();
    }
    private void initViews() {
        viewPager = findViewById(R.id.feature_class_vp);
        tabLayout = findViewById(R.id.feature_class_tl);
        filter = findViewById(R.id.common_filter_llt);
        mStyle1FV = findViewById(R.id.common_filter_fv_1);
        mStyle2FV = findViewById(R.id.common_filter_fv_2);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    if (filter.getVisibility() == View.VISIBLE) {
                        filter.setVisibility(View.GONE);
                    }
                    if (listView.getVisibility() != View.VISIBLE) {
                        listView.setVisibility(View.VISIBLE);
                    }
                } else if (position == 1) {
                    if (filter.getVisibility() == View.VISIBLE) {
                        filter.setVisibility(View.GONE);
                    }
                    if (listView.getVisibility() != View.VISIBLE) {
                        listView.setVisibility(View.VISIBLE);
                    }
                } else if (position == 2) {
                    if (filter.getVisibility() == View.VISIBLE) {
                        filter.setVisibility(View.GONE);
                    }
                    if (listView.getVisibility() != View.VISIBLE) {
                        listView.setVisibility(View.VISIBLE);
                    }
                } else if (position == 3) {
                    List list = new ArrayList();
                    mStyle1FV.setAttr(R.color.color4dBlack, R.drawable.shape_rectangle_corner4_gray_solid)
                            .setSelectedAttr(R.color.colorWhite, R.drawable.shape_rectangle_corner4_green_solid)
                            .addViewMutile(citys, R.layout.textview_flow, list, 1, false)
                            .setUseGrid(true)
                            .setOneLineCount(3)
                            .setUseSelected(true);

                    mStyle2FV.setAttr(R.color.color4dBlack, R.drawable.shape_rectangle_corner4_gray_solid)
                            .setSelectedAttr(R.color.colorWhite, R.drawable.shape_rectangle_corner4_green_solid)
                            .addViewMutile(citys, R.layout.textview_flow, list, 1, false)
                            .setUseGrid(true)
                            .setOneLineCount(3)
                            .setUseSelected(true);
                    if (filter.getVisibility() != View.VISIBLE) {
                        filter.setVisibility(View.VISIBLE);
                    }
                    if (listView.getVisibility() != View.GONE) {
                        listView.setVisibility(View.GONE);
                    }
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

        listView = findViewById(R.id.feature_class_gv);
        List<GymCoachGVItemBean> list = new ArrayList<>();
        list.add(new GymCoachGVItemBean());
        list.add(new GymCoachGVItemBean());
        list.add(new GymCoachGVItemBean());
        list.add(new GymCoachGVItemBean());
        list.add(new GymCoachGVItemBean());
        GymCoachGVAdapter gymCoachGVAdapter = new GymCoachGVAdapter(this,
                list);
        listView.setAdapter(gymCoachGVAdapter);


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

        listView.setFocusable(false);
    }
    public void backFeatureClass(View view) {
        finish();
    }
}

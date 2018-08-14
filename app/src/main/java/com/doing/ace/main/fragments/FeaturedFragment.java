package com.doing.ace.main.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.doing.ace.R;
import com.doing.ace.Util.DensityUtil;
import com.doing.ace.base.BaseFragment;
import com.doing.ace.main.feature.FeatureEvaluationAdapter;
import com.doing.ace.main.feature.banner.CycleViewPager;
import com.doing.ace.main.feature.banner.Info;
import com.doing.ace.main.feature.beans.Evaluation;
import com.doing.ace.main.feature.coach.BottomCoachRVAdapter;
import com.doing.ace.main.feature.coach.StarCoachActivity;
import com.doing.ace.main.feature.custom.SpacesItemDecoration;
import com.doing.ace.main.feature.fclass.FeatureBottomClassAdapter;
import com.doing.ace.main.feature.fclass.FeatureClassActivity;
import com.doing.ace.main.feature.fvenue.FeatureContentVenueActivity;
import com.doing.ace.main.feature.gymcoach.GYMCoachActivity;
import com.doing.ace.main.feature.gymcoach.GymCoachGVAdapter;
import com.doing.ace.main.feature.gymcoach.GymCoachGVItemBean;
import com.doing.ace.main.feature.hotclass.FeatureHotClassActivity;
import com.doing.ace.main.feature.venue.FeatureVenueActivity;
import com.doing.ace.main.feature.venue.GVAdapter;
import com.doing.ace.main.feature.venue.VenueBean;
import com.doing.ace.widget.CustomScrollGridview;

import java.util.ArrayList;
import java.util.List;

/**
 * 精选页面
 */
public class FeaturedFragment extends BaseFragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private ImageView starCoachIv, coachIv, classIv, venueIv, featureVenueIv, featureHotClassIv;
    private RecyclerView evaluationRv, bottomCoachRv;
    private CustomScrollGridview venueGv;
    private ListView bottomLv;

    /**
     * 模拟请求后得到的数据
     */
    List<Info> mList = new ArrayList<>();

    /**
     * 轮播图
     */
    CycleViewPager mCycleViewPager;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FeaturedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeaturedFragment.
     */
    public static FeaturedFragment newInstance(String param1, String param2) {
        FeaturedFragment fragment = new FeaturedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_featured, container, false);
        initData();
        initView(inflate);
        return inflate;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.feature_star_coach_iv:
                Intent intent = new Intent(getActivity(), StarCoachActivity.class);
                startActivity(intent);
                break;
            case R.id.feature_content_coach:
                Intent intentCoach = new Intent(getActivity(), GYMCoachActivity.class);
                startActivity(intentCoach);
                break;
            case R.id.feature_content_class:
                Intent intentClass = new Intent(getActivity(), FeatureClassActivity.class);
                startActivity(intentClass);
                break;
            case R.id.feature_content_venue:
                Intent intentV = new Intent(getActivity(), FeatureVenueActivity.class);
                startActivity(intentV);
                break;
            case R.id.feature_content_fvenue_iv:
                Intent intentFV = new Intent(getActivity(), FeatureContentVenueActivity.class);
                startActivity(intentFV);
                break;
            case R.id.feature_hot_class_more:
                Intent intentHC = new Intent(getActivity(), FeatureHotClassActivity.class);
                startActivity(intentHC);
                break;
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mList.add(new Info("标题1", "http://img2.3lian.com/2014/c7/25/d/40.jpg"));
        mList.add(new Info("标题2", "http://img2.3lian.com/2014/c7/25/d/41.jpg"));
        mList.add(new Info("标题3", "http://imgsrc.baidu.com/forum/pic/item/b64543a98226cffc8872e00cb9014a90f603ea30.jpg"));
        mList.add(new Info("标题4", "http://imgsrc.baidu.com/forum/pic/item/261bee0a19d8bc3e6db92913828ba61eaad345d4.jpg"));

    }

    /**
     * 初始化View
     */
    private void initView(View view) {
        mCycleViewPager = (CycleViewPager) view.findViewById(R.id.featured_cvp);
        starCoachIv = view.findViewById(R.id.feature_star_coach_iv);
        coachIv = view.findViewById(R.id.feature_content_coach);
        classIv = view.findViewById(R.id.feature_content_class);
        venueIv = view.findViewById(R.id.feature_content_venue);
        evaluationRv = view.findViewById(R.id.feature_content_evaluation_rv);
        venueGv = view.findViewById(R.id.feature_content_feature_venue_gv);//精选场馆
        bottomCoachRv = view.findViewById(R.id.feature_bottom_rv);//精选场馆
        bottomLv = view.findViewById(R.id.featured_lv);//精选场馆
        featureVenueIv = view.findViewById(R.id.feature_content_fvenue_iv);//精选场馆
        featureHotClassIv = view.findViewById(R.id.feature_hot_class_more);//精选场馆

        starCoachIv.setOnClickListener(this);
        coachIv.setOnClickListener(this);
        classIv.setOnClickListener(this);
        featureVenueIv.setOnClickListener(this);
        venueIv.setOnClickListener(this);
        featureHotClassIv.setOnClickListener(this);

        //设置选中和未选中时的图片
        assert mCycleViewPager != null;
        mCycleViewPager.setIndicators(R.drawable.ad_select, R.drawable.ad_unselect);
        //设置轮播间隔时间，默认为4000
        mCycleViewPager.setDelay(2000);
        mCycleViewPager.setData(mList, mAdCycleViewListener);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        evaluationRv.setLayoutManager(layoutManager);
        initFruits();
        FeatureEvaluationAdapter adapter = new FeatureEvaluationAdapter(list);
        evaluationRv.setAdapter(adapter);
        evaluationRv.addItemDecoration(new SpacesItemDecoration(DensityUtil.dip2px(getActivity(), 10)));

        List<VenueBean> list1 = new ArrayList<>();
        list1.add(new VenueBean());
        list1.add(new VenueBean());
        list1.add(new VenueBean());
        list1.add(new VenueBean());
        GVAdapter gymCoachGVAdapter = new GVAdapter(getActivity(),
                list1);
        venueGv.setAdapter(gymCoachGVAdapter);


        // 必须单独声明，否则报错
        StaggeredGridLayoutManager layoutManagerC = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        bottomCoachRv.setLayoutManager(layoutManagerC);
        BottomCoachRVAdapter adapterC = new BottomCoachRVAdapter(list, getActivity());
        bottomCoachRv.setAdapter(adapterC);
        bottomCoachRv.addItemDecoration(new SpacesItemDecoration(DensityUtil.dip2px(getActivity(), 10)));

        bottomLv.setAdapter(new FeatureBottomClassAdapter(getActivity(), null));
    }

    private List<Evaluation> list = new ArrayList<>();

    private void initFruits() {
        Evaluation apple = new Evaluation();
        list.add(apple);
        list.add(apple);
        list.add(apple);
        list.add(apple);
        list.add(apple);

    }

    /**
     * 轮播图点击监听
     */
    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(Info info, int position, View imageView) {

            if (mCycleViewPager.isCycle()) {
                position = position - 1;
            }
            Toast.makeText(getActivity(), info.getTitle() + "选择了--" + position, Toast.LENGTH_LONG).show();
        }
    };


}

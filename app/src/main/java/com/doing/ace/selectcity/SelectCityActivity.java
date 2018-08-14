package com.doing.ace.selectcity;

import android.os.Bundle;

import com.amap.api.location.AMapLocation;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mcxtzhang.indexlib.IndexBar.bean.BaseIndexPinyinBean;
import com.mcxtzhang.indexlib.IndexBar.widget.IndexBar;
import com.mcxtzhang.indexlib.suspension.SuspensionDecoration;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SelectCityActivity extends BaseActivity implements AMapLocationListener {

    private static final String TAG = "zxt";
    private Context mContext;
    private RecyclerView mRv;
    private MeituanAdapter mAdapter;
    private HeaderRecyclerAndFooterWrapperAdapter mHeaderAdapter;
    private LinearLayoutManager mManager;

    //设置给InexBar、ItemDecoration的完整数据集
    private List<BaseIndexPinyinBean> mSourceDatas;
    //头部数据源
    private List<MeituanHeaderBean> mHeaderDatas;
    //主体部分数据源（城市数据）
    private List<MeiTuanBean> mBodyDatas;

    private SuspensionDecoration mDecoration;

    /**
     * 右侧边栏导航区域
     */
    private IndexBar mIndexBar;

    /**
     * 显示指示器DialogText
     */
    private TextView mTvSideBarHint;

    //声明mlocationClient对象
    public AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        mContext = this;

        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(mManager = new LinearLayoutManager(this));

        mSourceDatas = new ArrayList<>();
        mHeaderDatas = new ArrayList<>();
        List<String> locationCity = new ArrayList<>();
        locationCity.add("定位中");
        mHeaderDatas.add(new MeituanHeaderBean(locationCity, "当前定位城市", "定"));
        List<String> recentCitys = new ArrayList<>();
        mHeaderDatas.add(new MeituanHeaderBean(recentCitys, "线下服务已开通城市", "线"));
        List<String> hotCitys = new ArrayList<>();
        mHeaderDatas.add(new MeituanHeaderBean(hotCitys, "预热城市·定义你的城市", "预"));
        mSourceDatas.addAll(mHeaderDatas);

        mAdapter = new MeituanAdapter(this, R.layout.meituan_item_select_city, mBodyDatas) {
            @Override
            public void convert(ViewHolder holder, final MeiTuanBean cityBean) {
                super.convert(holder, cityBean);
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, cityBean.getCity(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        mHeaderAdapter = new HeaderRecyclerAndFooterWrapperAdapter(mAdapter) {
            @Override
            protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {
                switch (layoutId) {
                    case R.layout.meituan_item_header:
                        final MeituanHeaderBean meituanHeaderBean = (MeituanHeaderBean) o;
                        //网格
                        RecyclerView recyclerView = holder.getView(R.id.rvCity);
                        recyclerView.setAdapter(
                                new CommonAdapter<String>(mContext, R.layout.meituan_item_header_item, meituanHeaderBean.getCityList()) {
                                    @Override
                                    public void convert(ViewHolder holder, final String cityName) {
                                        holder.setText(R.id.tvName, cityName);
                                        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Toast.makeText(mContext, "cityName:" + cityName, Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                        break;
                    case R.layout.meituan_item_header_top:
                        MeituanTopHeaderBean meituanTopHeaderBean = (MeituanTopHeaderBean) o;
                        holder.setText(R.id.tvCurrent, meituanTopHeaderBean.getTxt());
                        break;

                    default:
                        break;
                }
            }
        };
//        mHeaderAdapter.setHeaderView(0, R.layout.meituan_item_header_top, new MeituanTopHeaderBean("当前：上海徐汇"));
        mHeaderAdapter.setHeaderView(0, R.layout.meituan_item_header, mHeaderDatas.get(0));
        mHeaderAdapter.setHeaderView(1, R.layout.meituan_item_header, mHeaderDatas.get(1));
        mHeaderAdapter.setHeaderView(2, R.layout.meituan_item_header, mHeaderDatas.get(2));


        mRv.setAdapter(mHeaderAdapter);
        mRv.addItemDecoration(mDecoration = new SuspensionDecoration(this, mSourceDatas)
                .setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, getResources().getDisplayMetrics()))
                .setColorTitleBg(0xffefefef)
                .setTitleFontSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()))
                .setColorTitleFont(mContext.getResources().getColor(android.R.color.black))
                .setHeaderViewCount(mHeaderAdapter.getHeaderViewCount() - mHeaderDatas.size()));
        mRv.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        //使用indexBar
        mTvSideBarHint = (TextView) findViewById(R.id.tvSideBarHint);//HintTextView
        mIndexBar = (IndexBar) findViewById(R.id.indexBar);//IndexBar

        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mManager)//设置RecyclerView的LayoutManager
                .setHeaderViewCount(mHeaderAdapter.getHeaderViewCount() - mHeaderDatas.size());

        initDatas(getResources().getStringArray(R.array.provinces));


        initAMap();
    }

    private void initAMap() {
        mlocationClient = new AMapLocationClient(this);
//初始化定位参数
        mLocationOption = new AMapLocationClientOption();
//设置定位监听
        mlocationClient.setLocationListener(this);
//设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
//设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
// 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
// 在定位结束后，在合适的生命周期调用onDestroy()方法
// 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
//启动定位
        mlocationClient.startLocation();

    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
//
//    @Override
//    public void onLocationChanged(AMapLocation amapLocation) {
//        if (amapLocation != null) {
//            if (amapLocation.getErrorCode() == 0) {
//                //定位成功回调信息，设置相关消息
//                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                amapLocation.getLatitude();//获取纬度
//                amapLocation.getLongitude();//获取经度
//                amapLocation.getAccuracy();//获取精度信息
//                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date date = new Date(amapLocation.getTime());
//                df.format(date);//定位时间
//
//                Log.e("Amap", amapLocation.toStr());
//            } else {
//                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
//                Log.e("AmapError", "location Error, ErrCode:"
//                        + amapLocation.getErrorCode() + ", errInfo:"
//                        + amapLocation.getErrorInfo());
//            }
//        }
//    }

    /**
     * 组织数据源
     *
     * @param data
     * @return
     */
    private void initDatas(final String[] data) {
        //延迟两秒 模拟加载数据中....
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBodyDatas = new ArrayList<>();
                for (int i = 0; i < data.length; i++) {
                    MeiTuanBean cityBean = new MeiTuanBean();
                    cityBean.setCity(data[i]);//设置城市名称
                    mBodyDatas.add(cityBean);
                }
                //先排序
                mIndexBar.getDataHelper().sortSourceDatas(mBodyDatas);

                mAdapter.setDatas(mBodyDatas);
                mHeaderAdapter.notifyDataSetChanged();
                mSourceDatas.addAll(mBodyDatas);

                mIndexBar.setmSourceDatas(mSourceDatas)//设置数据
                        .invalidate();
                mDecoration.setmDatas(mSourceDatas);
            }
        }, 1000);

        //延迟两秒加载头部
//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                MeituanHeaderBean header1 = mHeaderDatas.get(0);
//                header1.getCityList().clear();
//                header1.getCityList().add("上海");
//
//                MeituanHeaderBean header2 = mHeaderDatas.get(1);
//                List<String> recentCitys = new ArrayList<>();
//                recentCitys.add("日本");
//                recentCitys.add("北京");
//                header2.setCityList(recentCitys);
//
//                MeituanHeaderBean header3 = mHeaderDatas.get(2);
//                List<String> hotCitys = new ArrayList<>();
//                hotCitys.add("上海");
//                hotCitys.add("北京");
//                hotCitys.add("杭州");
//                hotCitys.add("广州");
//                header3.setCityList(hotCitys);
//
//                mHeaderAdapter.notifyItemRangeChanged(1, 3);
//
//            }
//        }, 2000);

    }

    /**
     * 更新数据源
     *
     * @param view
     */
    public void updateDatas(View view) {
        for (int i = 0; i < 5; i++) {
            mBodyDatas.add(new MeiTuanBean("东京"));
            mBodyDatas.add(new MeiTuanBean("大阪"));
        }
        //先排序
        mIndexBar.getDataHelper().sortSourceDatas(mBodyDatas);
        mSourceDatas.clear();
        mSourceDatas.addAll(mHeaderDatas);
        mSourceDatas.addAll(mBodyDatas);

        mHeaderAdapter.notifyDataSetChanged();
        mIndexBar.invalidate();
    }

    public void backSelectActivity(View view) {
        finish();
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                aMapLocation.getLatitude();//获取纬度
                aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间

                Log.e("Amap", aMapLocation.toStr());

                setLocation(aMapLocation.toStr());
                Toast.makeText(mContext, aMapLocation.toStr(), Toast.LENGTH_SHORT).show();

                mlocationClient.stopLocation();// 获取到定位信息后即停止
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    private void setLocation(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);

            String city = jsonObject.getString("city");

            MeituanHeaderBean header1 = mHeaderDatas.get(0);
            header1.getCityList().clear();
            header1.getCityList().add(city);

            MeituanHeaderBean header2 = mHeaderDatas.get(1);
            List<String> recentCitys = new ArrayList<>();
            recentCitys.add("日本");
            recentCitys.add("北京");
            header2.setCityList(recentCitys);

            MeituanHeaderBean header3 = mHeaderDatas.get(2);
            List<String> hotCitys = new ArrayList<>();
            hotCitys.add("上海");
            hotCitys.add("北京");
            hotCitys.add("杭州");
            hotCitys.add("广州");
            header3.setCityList(hotCitys);

            mHeaderAdapter.notifyItemRangeChanged(0, 3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 销毁定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void destroyLocation() {
        if (null != mlocationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            mlocationClient.onDestroy();
            mlocationClient = null;
            mLocationOption = null;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyLocation();
    }
}

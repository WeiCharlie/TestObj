package com.doing.ace;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.doing.ace.base.BaseActivity;
import com.doing.ace.base.BaseFragment;
import com.doing.ace.main.fragments.CircleFragment;
import com.doing.ace.main.fragments.FeaturedFragment;
import com.doing.ace.main.fragments.FindFragment;
import com.doing.ace.main.fragments.MineFragment;
import com.doing.ace.search.SearchActivity;
import com.doing.ace.selectcity.SelectCityActivity;
import com.doing.bottombar.BottomBar;
import com.doing.bottombar.OnTabSelectListener;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private FragmentManager mFM = null;
    private LinearLayout selectCityLlt;
    private ImageView mainSearchIv;
    private long mExitTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        initViews();

        // We're doing nothing with this listener here this time. Check example usage
        // from ThreeTabsActivity on how to use it.
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_featured:
                        changeFeatured();
                        Toast.makeText(MainActivity.this, "点击了精选", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_find:
                        changeFind();
                        Toast.makeText(MainActivity.this, "点击了发现", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_circle:
                        changeCircle();
                        Toast.makeText(MainActivity.this, "点击了圈子", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab_mine:
                        changeMine();
                        Toast.makeText(MainActivity.this, "点击了我的", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        checkPermissions();
    }

    private void initViews() {
        selectCityLlt = findViewById(R.id.select_city_llt);
        mainSearchIv = findViewById(R.id.main_search_iv);

        selectCityLlt.setOnClickListener(this);
        mainSearchIv.setOnClickListener(this);
    }

    /**
     * �л�fragement
     */
    private void changeFeatured() {
        BaseFragment f = new FeaturedFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * �л�fragement
     */
    public void changeFind() {
        BaseFragment f = new FindFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * �л�fragement
     */
    public void changeCircle() {
        BaseFragment f = new CircleFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    /**
     * �л�fragement
     */
    public void changeMine() {
        BaseFragment f = new MineFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.select_city_llt:
                Intent intent = new Intent(this, SelectCityActivity.class);
                startActivity(intent);
                break;
            case R.id.main_search_iv:
                Intent intentSearch = new Intent(this, SearchActivity.class);
                startActivity(intentSearch);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {//
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();// 更新mExitTime
            } else {
                finish();
                System.exit(0);// 否则退出程序
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}

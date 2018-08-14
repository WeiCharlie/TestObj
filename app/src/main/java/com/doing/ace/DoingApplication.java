package com.doing.ace;

import android.app.Application;

import org.xutils.x;

/**
 * Created by : Charlie Wei
 * Created date : 2018/7/28
 * Description : 全局通用application
 */
public class DoingApplication extends Application {
    public static DoingApplication mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);//  初始化xtuils
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能

        mContext = this;
    }
}

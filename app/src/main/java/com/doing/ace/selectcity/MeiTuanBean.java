package com.doing.ace.selectcity;

import com.mcxtzhang.indexlib.IndexBar.bean.BaseIndexPinyinBean;

/**
 * 介绍：美团里的城市bean
 *
 */

public class MeiTuanBean extends BaseIndexPinyinBean {
    private String city;//城市名字
    private double longtitude;//经度
    private double latitude;// 纬度

    public MeiTuanBean() {
    }

    public MeiTuanBean(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public MeiTuanBean setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public String getTarget() {
        return city;
    }
}

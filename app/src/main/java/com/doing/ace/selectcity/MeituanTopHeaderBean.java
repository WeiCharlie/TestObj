package com.doing.ace.selectcity;

/**
 * 介绍：美团最顶部Header
 *
 */

public class MeituanTopHeaderBean {
    private String txt;

    public MeituanTopHeaderBean(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public MeituanTopHeaderBean setTxt(String txt) {
        this.txt = txt;
        return this;
    }

}

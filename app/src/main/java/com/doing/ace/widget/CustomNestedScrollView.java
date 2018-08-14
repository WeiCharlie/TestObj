package com.doing.ace.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;

/**
 * Created by : Charlie Wei
 * Created date : 2018/8/4
 * Description : ....
 */
public class CustomNestedScrollView extends NestedScrollView {
    public CustomNestedScrollView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

package com.doing.ace.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by : Charlie Wei
 * Created date : 2018/8/11
 * Description : ....
 */
public class CustomScrollGridview extends GridView {
    public CustomScrollGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollGridview(Context context) {
        super(context);
    }

    public CustomScrollGridview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

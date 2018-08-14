package com.doing.ace.base;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by : Charlie Wei
 * Created date : 2018/8/10
 * Description : 通用ViewHolder
 */
public class BaseViewHolder {
    private BaseViewHolder() {}

    @SuppressWarnings("unchecked")
    public static <T extends View>T getChildView(View convertView, int id) {

        SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();

        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            convertView.setTag(viewHolder);
        }

        View childView = viewHolder.get(id);

        if (childView == null) {
            childView = convertView.findViewById(id);
            viewHolder.put(id, childView);
        }

        return (T) childView;
    }
}

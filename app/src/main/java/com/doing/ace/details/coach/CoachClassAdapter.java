package com.doing.ace.details.coach;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.doing.ace.R;

import java.util.List;

/**
 * Created by : Charlie Wei
 * Created date : 2018/8/13
 * Description : ....
 */
public class CoachClassAdapter implements ListAdapter {
    private Activity activity;
    private List<CoachClassLvBean> list;

    public CoachClassAdapter(Activity activity, List list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        if (list == null || list.size() == 0)
            return 2;
        else
            return list.size();
    }

    @Override
    public Object getItem(int position) {
        if (list == null || list.size() == 0)
            return null;
        else
            return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(activity)
                    .inflate(R.layout.coach_detail_class_lv_item, parent, false);
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}

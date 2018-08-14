package com.doing.ace.selectcity;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.doing.ace.R;

import java.util.List;

/**
 *
 */

public class MeituanAdapter extends CommonAdapter<MeiTuanBean> {
    public MeituanAdapter(Context context, int layoutId, List<MeiTuanBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, final MeiTuanBean cityBean) {
        holder.setText(R.id.tvCity, cityBean.getCity());

    }
}
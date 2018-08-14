package com.doing.ace.main.find;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DebugUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.doing.ace.R;
import com.doing.ace.Util.DensityUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by WuXiaolong on 2015/9/14.
 */
public class StaggeredRecycleViewAdapter extends RecyclerView.Adapter<StaggeredRecycleViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Map<String, String>> dataList;

    public static final int MAX_SIZE_HEIGHT = 300;
    public static final int MIN_SIZE_HEIGHT = 270;

    public List<Map<String, String>> getDataList() {
        return dataList;
    }

    public StaggeredRecycleViewAdapter(Context context, List<Map<String, String>> dataList) {
        this.dataList = dataList;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public CardView cardView;
        public RelativeLayout itemRlt;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.stagger_item_iv);
            itemRlt = itemView.findViewById(R.id.stagger_item_rlt);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_recycler_view_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(dataList.get(position).get("text"));
        Log.i("viewdd", dataList.get(position).get("text") + "----" + dataList.size());
        if (position == 1) {
            holder.imageView.setMaxHeight(DensityUtil.dip2px(mContext, 150));

        }else {
            holder.imageView.setMinimumHeight(DensityUtil.dip2px(mContext, 170));

        }


//        if (position == 0) {
//            holder.itemRlt.setMinimumHeight(DensityUtil.dip2px(mContext, MAX_SIZE_HEIGHT));//高度随机，下拉刷新高度会变
//
//        } else if (position == 1) {
//            holder.itemRlt.setMinimumHeight(DensityUtil.dip2px(mContext, MIN_SIZE_HEIGHT));//高度随机，下拉刷新高度会变
//
//        } else if ((position - 3) % 4 == 0) {
//            holder.itemRlt.setMinimumHeight(DensityUtil.dip2px(mContext, MAX_SIZE_HEIGHT));//高度随机，下拉刷新高度会变
//
//        } else {
//            holder.itemRlt.setMinimumHeight(DensityUtil.dip2px(mContext, MIN_SIZE_HEIGHT));//高度随机，下拉刷新高度会变
//
//        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了" + dataList.get(position).get("text"), Toast.LENGTH_SHORT).show();
            }
        });
//        holder.title.setHeight(Integer.parseInt(dataList.get(position).get("height")));//高度随机，下拉刷新高度会变
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

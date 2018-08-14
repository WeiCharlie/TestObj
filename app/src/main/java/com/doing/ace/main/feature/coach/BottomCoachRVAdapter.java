package com.doing.ace.main.feature.coach;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.doing.ace.R;
import com.doing.ace.details.coach.CoachDetailActivity;
import com.doing.ace.main.feature.beans.Evaluation;

import java.util.List;

/**
 * Created by : Charlie Wei
 * Created date : 2018/8/11
 * Description : ....
 */
public class BottomCoachRVAdapter extends RecyclerView.Adapter<BottomCoachRVAdapter.ViewHolder> {
    private List<Evaluation> mFruitList;
    private Activity activity;

    public BottomCoachRVAdapter(List<Evaluation> fruitList, Activity activity) {
        mFruitList = fruitList;
        this.activity = activity;
    }


    @Override
    public BottomCoachRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_bottom_rv_item, parent, false);
        final BottomCoachRVAdapter.ViewHolder holder = new BottomCoachRVAdapter.ViewHolder(view);
        holder.Fruitview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Evaluation fruit = mFruitList.get(position);
                Intent intent = new Intent(activity, CoachDetailActivity.class);
                activity.startActivity(intent);
                Toast.makeText(view.getContext(), "you click View " + position, Toast.LENGTH_SHORT).show();
            }
        });
//        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int id = holder.getAdapterPosition();
//                Evaluation fruit = mFruitList.get(id);
////                Toast.makeText(view.getContext(), "you click Image " + fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(BottomCoachRVAdapter.ViewHolder holder, int position) {
        Evaluation fruit = mFruitList.get(position);
//        holder.fruitImage.setImageResource(fruit.getImageId());
//        holder.fruitName.setText(fruit.getName());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View Fruitview;
//        ImageView fruitImage;
//        TextView fruitName;


        public ViewHolder(View itemView) {
            super(itemView);
            Fruitview = itemView;
//            fruitImage = itemView.findViewById(R.id.fruitImage);
//            fruitName = itemView.findViewById(R.id.fruitName);

        }
    }
}
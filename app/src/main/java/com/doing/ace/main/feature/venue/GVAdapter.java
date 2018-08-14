package com.doing.ace.main.feature.venue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doing.ace.R;
import com.doing.ace.main.feature.gymcoach.GymCoachGVAdapter;
import com.doing.ace.main.feature.gymcoach.GymCoachGVItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : Charlie Wei
 * Created date : 2018/8/11
 * Description : ....
 */
public class GVAdapter extends BaseAdapter {
    private Context context;

    private List<VenueBean> pictures = new ArrayList<>();

    public GVAdapter(Context context, List list) {
        super();
        this.context = context;
        pictures = list;

//
//        for (int i = 0; i < images.length; i++) {
//            GymCoachGVItemBean picture = new GymCoachGVItemBean(titles[i], images[i]);
//            pictures.add(picture);
//        }

    }

    @Override
    public int getCount() {

        if (null != pictures) {
            return pictures.size();
        } else {
            return 4;
        }
    }

    @Override
    public Object getItem(int position) {

        return pictures.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        GVAdapter.ViewHolder viewHolder = null;

        if (convertView == null) {

            viewHolder = new GVAdapter.ViewHolder();
            // 获得容器
            convertView = LayoutInflater.from(this.context).inflate(R.layout.main_feature_venue_gv_item, null);

            // 初始化组件
//            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
//            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            // 给converHolder附加一个对象
            convertView.setTag(viewHolder);
        } else {
            // 取得converHolder附加的对象
            viewHolder = (GVAdapter.ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了第" + position, Toast.LENGTH_SHORT).show();
            }
        });
        // 给组件设置资源
//        Picture picture = pictures.get(position);
//        viewHolder.image.setImageResource(picture.getImageId());
//        viewHolder.title.setText(picture.getTitle());

        return convertView;
    }

    class ViewHolder {
        public TextView title;
        public ImageView image;
    }
}
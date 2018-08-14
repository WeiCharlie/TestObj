package com.doing.ace.main.mine;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MyClassActivity extends BaseActivity implements View.OnClickListener {

    private ListView myClassLv;
    private TextView useTv, noUseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_class);

        myClassLv = findViewById(R.id.my_class_lv);
        useTv = findViewById(R.id.my_class_use);
        noUseTv = findViewById(R.id.my_class_nouse);

        useTv.setOnClickListener(this);
        noUseTv.setOnClickListener(this);

        myClassLv.setAdapter(new ClassAdapter(this, null));
    }

    public void backClass(View view) {
        finish();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.my_class_use:
                useTv.setTextColor(getResources().getColor(R.color.use_color));
                noUseTv.setTextColor(getResources().getColor(R.color.no_use_color));
                break;
            case R.id.my_class_nouse:
                useTv.setTextColor(getResources().getColor(R.color.no_use_color));
                noUseTv.setTextColor(getResources().getColor(R.color.use_color));
                break;
        }
    }

    class Item {
        private String imgUrl;
        private String name;
        private String info;
        private String trait;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getTrait() {
            return trait;
        }

        public void setTrait(String trait) {
            this.trait = trait;
        }
    }

    class ClassAdapter implements ListAdapter {
        private List<MyCardActivity.Item> list = new ArrayList<>();
        private Context context;

        public ClassAdapter(Context context, List list) {
            this.list = list;
            this.context = context;

        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
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
            View item = View.inflate(context, R.layout.mine_card_list_item, null);
            return item;
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
}

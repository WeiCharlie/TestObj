package com.doing.ace.main.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;

// TODO: 2018/8/7 订单页面缺少订单列表，待完成
public class MyOrderActivity extends BaseActivity implements View.OnClickListener {

    private TextView noTv, useTv, allTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        noTv = findViewById(R.id.my_order_nouse);
        useTv = findViewById(R.id.my_order_use);
        allTv = findViewById(R.id.my_order_all);

        noTv.setOnClickListener(this);
        useTv.setOnClickListener(this);
        allTv.setOnClickListener(this);
    }

    public void backOrder(View view) {
        finish();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.my_order_nouse:
                noTv.setTextColor(getResources().getColor(R.color.use_color));
                useTv.setTextColor(getResources().getColor(R.color.no_use_color));
                allTv.setTextColor(getResources().getColor(R.color.no_use_color));
                break;
            case R.id.my_order_use:
                noTv.setTextColor(getResources().getColor(R.color.no_use_color));
                useTv.setTextColor(getResources().getColor(R.color.use_color));
                allTv.setTextColor(getResources().getColor(R.color.no_use_color));
                break;
            case R.id.my_order_all:
                noTv.setTextColor(getResources().getColor(R.color.no_use_color));
                useTv.setTextColor(getResources().getColor(R.color.no_use_color));
                allTv.setTextColor(getResources().getColor(R.color.use_color));
                break;
        }
    }
}

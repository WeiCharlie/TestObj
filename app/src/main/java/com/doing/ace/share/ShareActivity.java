package com.doing.ace.share;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;

public class ShareActivity extends BaseActivity implements View.OnClickListener {

    private TextView wechatTv, wechatCircleTv, qZoneTv, qqTv, sinaTv, copyTv, collectTv, reportTv, cancelTv;
    private LinearLayout cancelLlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        initViews();
    }

    private void initViews() {
        wechatTv = findViewById(R.id.share_wechat);
        wechatCircleTv = findViewById(R.id.share_wechat_circle);
        qZoneTv = findViewById(R.id.share_qzone);
        qqTv = findViewById(R.id.share_qq);
        sinaTv = findViewById(R.id.share_sina);
        copyTv = findViewById(R.id.share_copy);
        collectTv = findViewById(R.id.share_collect);
        reportTv = findViewById(R.id.share_report);
        cancelTv = findViewById(R.id.share_cancel);
        cancelLlt = findViewById(R.id.share_cancel_llt);


        wechatTv.setOnClickListener(this);
        wechatCircleTv.setOnClickListener(this);
        qZoneTv.setOnClickListener(this);
        qqTv.setOnClickListener(this);
        sinaTv.setOnClickListener(this);
        copyTv.setOnClickListener(this);
        collectTv.setOnClickListener(this);
        reportTv.setOnClickListener(this);
        cancelLlt.setOnClickListener(this);
        cancelTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.share_cancel:
                finish();
                break;
            case R.id.share_collect:
                Toast.makeText(this, "点击了收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_copy:
                Toast.makeText(this, "点击了复制", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_qq:
                Toast.makeText(this, "点击了QQ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_qzone:
                Toast.makeText(this, "点击了qZone", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_report:
                Toast.makeText(this, "点击了举报", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_sina:
                Toast.makeText(this, "点击了微博", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_wechat:
                Toast.makeText(this, "点击了微信", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_wechat_circle:
                Toast.makeText(this, "点击了朋友圈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_cancel_llt:
                finish();
                break;
        }

    }
}

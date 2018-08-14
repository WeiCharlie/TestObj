package com.doing.ace.main.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;

public class PublishCircleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_circle);
    }

    public void backPublish(View view) {
        finish();
    }
}

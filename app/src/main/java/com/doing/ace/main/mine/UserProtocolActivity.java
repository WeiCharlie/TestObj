package com.doing.ace.main.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;

public class UserProtocolActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_protocol);
    }

    public void backUserPro(View view) {
        finish();
    }
}

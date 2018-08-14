package com.doing.ace.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doing.ace.ConstantUrl;
import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;
import com.doing.ace.register.RegisterActivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText nameEt, pwdEt;
    private ImageView loginBtn, registerBtn;
    private TextView forgetPwdTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        nameEt = findViewById(R.id.name_et);
        pwdEt = findViewById(R.id.pwd_et);

        forgetPwdTv = findViewById(R.id.forgetpwd_tv);

        loginBtn = findViewById(R.id.login_iv);
        registerBtn = findViewById(R.id.register_iv);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        forgetPwdTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.login_iv:
                String name = nameEt.getText().toString();
                String pwd = pwdEt.getText().toString();

                RequestParams params = new RequestParams(ConstantUrl.LOGIN_IN);
                params.addQueryStringParameter("name", name);
                params.addQueryStringParameter("password", pwd);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        //解析result
                        Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    //请求异常后的回调方法
                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(LoginActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    //主动调用取消请求的回调方法
                    @Override
                    public void onCancelled(Callback.CancelledException cex) {
                    }

                    @Override
                    public void onFinished() {
//                Toast.makeText(MainActivity.this, "直接结束", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.register_iv:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.forgetpwd_tv:
                Intent intentForget = new Intent(this, RegisterActivity.class);
                startActivity(intentForget);
                break;
        }
    }
}

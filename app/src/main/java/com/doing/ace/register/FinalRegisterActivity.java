package com.doing.ace.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.doing.ace.ConstantUrl;
import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;
import com.doing.ace.login.LoginActivity;
import com.tuo.customview.VerificationCodeView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class FinalRegisterActivity extends BaseActivity implements View.OnClickListener {

    private VerificationCodeView vcv;
    private ImageView nextIv, getVCVIv;
    private EditText setPwdEt;

    private String phoneNum, sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_register);
        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");
        phoneNum = intent.getStringExtra("phoneNumber");
        initViews();

    }

    private void initViews() {
        vcv = findViewById(R.id.vcv);
        nextIv = findViewById(R.id.next_iv);
        getVCVIv = findViewById(R.id.getVCV);
        setPwdEt = findViewById(R.id.set_pwd_et);

        nextIv.setOnClickListener(this);
        getVCVIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.next_iv:

                String pwd = setPwdEt.getText().toString();
                if ("".equals(pwd) || pwd == null || "设置密码".equals(pwd)) {
                    Toast.makeText(this, "请设置密码！", Toast.LENGTH_SHORT).show();
                    return;
                }


                RequestParams params = new RequestParams(ConstantUrl.REGISTER_SERVLET);
                params.addQueryStringParameter("phoneNumber", phoneNum);
                params.addQueryStringParameter("password", pwd);
                params.addQueryStringParameter("sessionid", sessionId);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.i("resultRegister",result);
                        //解析result
                        Toast.makeText(FinalRegisterActivity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    //请求异常后的回调方法
                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(FinalRegisterActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();

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
            case R.id.getVCV:
                break;
        }
    }
}

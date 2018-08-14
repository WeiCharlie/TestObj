package com.doing.ace.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.doing.ace.ConstantUrl;
import com.doing.ace.R;
import com.doing.ace.base.BaseActivity;
import com.doing.ace.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText registerEt;
    private ImageView registerIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
    }

    private void initViews() {
        registerEt = findViewById(R.id.registerview_et);
        registerIv = findViewById(R.id.registerview_iv);

        registerIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.registerview_iv:
                final String phone = registerEt.getText().toString();

                RequestParams params = new RequestParams(ConstantUrl.GET_AUTH_CODE);
                params.addQueryStringParameter("phoneNumber", phone);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        String status = "";
                        String sessionId = "";
                        try {
                            JSONObject jsonObject = new JSONObject(result);
                            status = jsonObject.getString("status");
                            sessionId = jsonObject.getString("sessionid");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(RegisterActivity.this, FinalRegisterActivity.class);
                        intent.putExtra("sessionId", sessionId);
                        intent.putExtra("phoneNumber", phone);

                        startActivity(intent);
                        //解析result
                        Toast.makeText(RegisterActivity.this, status, Toast.LENGTH_SHORT).show();
                    }

                    //请求异常后的回调方法
                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(RegisterActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();

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
        }
    }
}

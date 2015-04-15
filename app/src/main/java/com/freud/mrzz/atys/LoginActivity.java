package com.freud.mrzz.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.freud.mrzz.R;
import com.freud.mrzz.net.NetCore;
import com.freud.mrzz.utils.T;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rival on 2015/4/6.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private TextView tv_login,tv_register;
    private EditText et_username,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        tv_login = (TextView) findViewById(R.id.tv_login_loginaty);
        tv_register = (TextView) findViewById(R.id.tv_register_loginaty);
        et_username = (EditText) findViewById(R.id.id_et_user_loginaty);
        et_password = (EditText) findViewById(R.id.id_et_password_loginaty);
        tv_register.setOnClickListener(this);
        tv_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_register_loginaty:
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.tv_login_loginaty:
                //上传数据
                int status = 0;
                NetCore netCore =new NetCore();
                String result=netCore.Login(et_username.getText().toString(),et_password.getText().toString());
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    status = (int) jsonObject.get("status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                switch (status){
                    case 1:
                        //成功
                        T.showShort(this,"登陆成功");
                        Intent i2 = new Intent(this,MainActivity.class);
                        startActivity(i2);
                        break;
                    case 0:
                        //失败
                        T.showShort(this,"登录失败");
                        break;
                }
                break;
        }
    }

}

package com.freud.mrzz.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.freud.mrzz.R;
import com.freud.mrzz.net.NetCore;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by rival on 2015/4/6.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private TextView tv_login,tv_register;
    private EditText et_username,et_password;
    private Handler handler;
    private String url = "http://121.250.219.6/Login_Register/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        try {
                            String res = msg.getData().getString("res");
                            res = JSONTokener(res);
                            JSONObject result = new JSONObject(res);
                            int success = Integer.parseInt(result.getString("success"));
                            Toast.makeText(LoginActivity.this, res + ":\n" + result.toString(), Toast.LENGTH_LONG).show();
                            // TODO Auto-generated catch block
                            if(success == 0){
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this, "输入的用户名或密码有错", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;

                    default:
                        break;
                }
            }
        };
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
                new Thread(){
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        super.run();
                        try {
                            JSONObject json = new JSONObject();
                            json.put("UserName", et_username.getText().toString().trim());
                            json.put("PassWord", et_password.getText().toString().trim());
                            //						httpPostMethod(json);
                            NetCore.httpPostMethod(url, json, handler);

                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            Log.d("json", "解析JSON出错");
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (ClientProtocolException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }.start();
               /* int status = 0;
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
                }*/
                break;
        }
    }
    public static String JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.startsWith("\ufeff")) {
            in = in.substring(1);
        }
        return in;
    }

}

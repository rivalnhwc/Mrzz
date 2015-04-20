package com.freud.mrzz.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
public class RegisterActivity extends Activity implements View.OnClickListener {
    private EditText et_user,et_password,et_ic;
    private TextView tv_register;
    private JSONObject json = new JSONObject();
    private Handler handler;
    private String url = "http://121.250.219.6/Login_Register/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                            int r_respons = Integer.parseInt(result.getString("r_respons"));
                            Toast.makeText(RegisterActivity.this, res, Toast.LENGTH_LONG).show();
                            if(r_respons == 0){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("empNo", json.getString("empNo"));
                                bundle.putString("pass", json.getString("pass"));
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "输入的用户名或密码有错", Toast.LENGTH_SHORT).show();//
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            Toast.makeText(RegisterActivity.this, "catch发生错误", Toast.LENGTH_SHORT).show();
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
    private void initView(){
        et_user = (EditText) findViewById(R.id.id_et_user_registeraty);
        et_password = (EditText) findViewById(R.id.id_et_password_registeraty);
        et_ic = (EditText) findViewById(R.id.id_et_yanzhengma_registeraty);
        tv_register = (TextView) findViewById(R.id.tv_register_registeraty);

        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_register_registeraty:
                //上传数据
                getDate(json);
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            NetCore.httpPostMethod(url, json, handler);
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
                    };
                }.start();
                break;
        }
    }
    private void getDate(JSONObject json){
        try {
            json.put("empNo", et_user.getText().toString());
            json.put("pass", et_password.getText().toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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

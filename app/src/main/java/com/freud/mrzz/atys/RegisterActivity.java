package com.freud.mrzz.atys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.freud.mrzz.R;

/**
 * Created by rival on 2015/4/6.
 */
public class RegisterActivity extends Activity implements View.OnClickListener {
    private EditText et_user,et_password,et_ic;
    private TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                break;
        }
    }
}

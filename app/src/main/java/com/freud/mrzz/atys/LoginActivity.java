package com.freud.mrzz.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.freud.mrzz.R;

/**
 * Created by rival on 2015/4/6.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private Button tv_login,tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        tv_login = (Button) findViewById(R.id.tv_login_loginaty);
        tv_register = (Button) findViewById(R.id.tv_register_loginaty);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_register_loginaty:
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
        }
    }
}

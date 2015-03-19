package com.freud.mrzz.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.freud.mrzz.R;

/**
 * Created by rival on 2015/3/16.
 */
public class TopicActivity extends Activity {
    private TextView tv_title_topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String str = b.getString("name");
        tv_title_topbar = (TextView) findViewById(R.id.id_tv_title_topbar_topicaty);
        tv_title_topbar.setText(str);


    }
}

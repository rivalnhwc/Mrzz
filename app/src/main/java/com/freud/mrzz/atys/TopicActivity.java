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
    private TextView tvTopic ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String str = b.getString("name");
        tvTopic = (TextView) findViewById(R.id.tv_Topic_topicaty);
        tvTopic.setText(str);



    }
}

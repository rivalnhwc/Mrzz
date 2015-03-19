package com.freud.mrzz.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.freud.mrzz.R;
import com.freud.mrzz.adapter.CommentAdapter;
import com.freud.mrzz.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rival on 2015/3/16.
 */
public class TopicActivity extends Activity {
    private TextView tv_title_topbar;
    private ListView lv_topicaty;
    private List<Comment> commentList = new ArrayList<>();
    private CommentAdapter commentAdapter;
    private LinearLayout ll_topicaty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        initData();
        initView();

    }
    private void initData(){

        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();
        Comment comment4 = new Comment();
        Comment comment5 = new Comment();
        Comment comment6 = new Comment();

        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        commentList.add(comment4);
        commentList.add(comment5);
        commentList.add(comment6);
    }
    private void initView(){
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String str = b.getString("name");
        tv_title_topbar = (TextView) findViewById(R.id.id_tv_title_topbar_topicaty);
        tv_title_topbar.setText(str);

        ll_topicaty = (LinearLayout) findViewById(R.id.id_ll_topicaty);

        lv_topicaty = (ListView) findViewById(R.id.id_lv_topicaty);
        lv_topicaty.addHeaderView(LayoutInflater.from(this).inflate(R.layout.head_topic_item_topicaty,null));
        commentAdapter = new CommentAdapter(this,R.layout.comment_item_noimage,commentList);
        lv_topicaty.setAdapter(commentAdapter);
    }
}

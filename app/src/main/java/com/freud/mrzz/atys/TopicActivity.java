package com.freud.mrzz.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.freud.mrzz.R;
import com.freud.mrzz.adapter.CommentAdapter;
import com.freud.mrzz.entity.Comment;
import com.freud.mrzz.utils.T;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rival on 2015/3/16.
 */
public class TopicActivity extends Activity implements View.OnClickListener {
    private TextView tv_title_topbar;
    private ListView lv_topicaty;
    private List<Comment> commentList = new ArrayList<>();
    private CommentAdapter commentAdapter;
    private LinearLayout ll_topicaty;
    private View view_head;
    private TextView tv_head_username;
    private ImageButton ib_getback, ib_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        initData();
        initView();

    }

    private void initData() {

        Comment comment0 = new Comment("张远航", R.drawable.sheep_pulltorefresh, "沙发", "1970.1.1");
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();
        Comment comment4 = new Comment();
        Comment comment5 = new Comment();
        Comment comment6 = new Comment();
        commentList.add(comment0);
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        commentList.add(comment4);
        commentList.add(comment5);
        commentList.add(comment6);
    }

    private void initView() {
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String name = b.getString("name");
        String user_name = b.getString("user_name", "张远航");

        view_head = LayoutInflater.from(this).inflate(R.layout.head_topic_item_topicaty, null);
        tv_title_topbar = (TextView) findViewById(R.id.id_tv_title_topbar_topicaty);
        lv_topicaty = (ListView) findViewById(R.id.id_lv_topicaty);

        ib_getback = (ImageButton) findViewById(R.id.id_ib_getback_topicaty);
        ib_share = (ImageButton) findViewById(R.id.id_ib_share_topicaty);
        tv_head_username = (TextView) view_head.findViewById(R.id.id_tv_username_topicaty);
        tv_head_username.setText(user_name);
        ib_getback.setOnClickListener(this);
        ib_share.setOnClickListener(this);


//设置顶端文字
        tv_title_topbar.setText(name);
        lv_topicaty.addHeaderView(view_head);
        commentAdapter = new CommentAdapter(this, R.layout.comment_item_noimage, commentList);
        lv_topicaty.setAdapter(commentAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_ib_getback_topicaty:
                finish();
                break;
            case R.id.id_ib_share_topicaty:
                T.showShort(getApplicationContext(), "share");
        }
    }
}

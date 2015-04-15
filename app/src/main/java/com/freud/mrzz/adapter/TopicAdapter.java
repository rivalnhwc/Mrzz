package com.freud.mrzz.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.freud.mrzz.R;
import com.freud.mrzz.entity.Topic;
import com.freud.mrzz.utils.T;
import com.freud.mrzz.views.CircleImageView;

import java.util.List;

/**
 * Created by rival on 2015/3/12.
 */
public class TopicAdapter extends ArrayAdapter<Topic> {
    private int resource;

    private String urlHead = "http://211.87.226.138:8088/floyid/forum/";
    private String url_head_Head = "http://211.87.226.138:8088/floyid/login/";

    private final static int IMAGE_FAIL=0;

    private RequestQueue mQuene;

    public TopicAdapter(Context context, int resource, List<Topic> objects) {
        super(context, resource, objects);
        mQuene = Volley.newRequestQueue(context);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Topic topic = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resource, null);
            viewHolder = new ViewHolder();
            viewHolder.im_userhead = (CircleImageView) view.findViewById(R.id.id_im_userhead_topicitem_communityfrag_image);
            viewHolder.im_content_first = (ImageView) view.findViewById(R.id.id_im_contentimage_first_communityfrag_image);
            viewHolder.im_content_second = (ImageView) view.findViewById(R.id.id_im_contentimage_second_communityfrag_image);
            viewHolder.im_content_third = (ImageView) view.findViewById(R.id.id_im_contentimage_third_communityfrag_image);

            viewHolder.tv_username = (TextView) view.findViewById(R.id.id_tv_username_topicitme_communityfrag_image);
            viewHolder.tv_topicname = (TextView) view.findViewById(R.id.id_tv_topicname_topicitme_communityfrag_image);
            viewHolder.tv_timepulish = (TextView) view.findViewById(R.id.id_tv_timepublish_topicitem_communityfrag_image);
            viewHolder.tv_topic_content = (TextView) view.findViewById(R.id.id_tv_topiccontent_topicitem_communityfrag_image);
            viewHolder.tv_reply = (TextView) view.findViewById(R.id.id_tv_replynum_topicitem_communityfrag_image);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_username.setText(topic.getUser_name());
        viewHolder.tv_topicname.setText(topic.getTopic_name());
        viewHolder.tv_timepulish.setText(topic.getTime_publish());
        viewHolder.tv_reply.setText(topic.getReply_number() + "");
        viewHolder.tv_topic_content.setText(topic.getContent());

        ThreadImage mthreadImage = new ThreadImage(topic.getImageID_userhead(),topic.getImageID_content(),viewHolder);
        mthreadImage.run();

           /* viewHolder.im_userhead.setImageResource(topic.getImageID_userhead());
            viewHolder.im_content_first.setImageResource(topic.getImageID_content());*/


        return view;
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case IMAGE_FAIL:
                    T.showShort(getContext(),"下载失败");
                    break;
            }
        }
    };

    class ThreadImage extends Thread{
        String url_head;
        String url_content;
        ViewHolder viewHolder;
        public ThreadImage(String url_head,String url_content,ViewHolder viewHolder){
            this.url_head = url_head;
            this.url_content = url_content;
            this.viewHolder = viewHolder;
        }
        @Override
        public void run() {
            super.run();
            ImageRequest imageHeadRequest = new ImageRequest(
                    url_head_Head+url_head,
                    new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap response) {
                   //         mHandler.obtainMessage(IMAGE_HEAD_SUCCESS,response).sendToTarget();
                            viewHolder.im_userhead.setImageBitmap(response);
                        }
                    }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mHandler.obtainMessage(IMAGE_FAIL).sendToTarget();
                }
            });
            ImageRequest imageContentRequest = new ImageRequest(
                    urlHead+url_content,
                    new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap response) {
                    //        mHandler.obtainMessage(IMAGE_CONTENT_SUCCESS,response).sendToTarget();
                            viewHolder.im_content_first.setImageBitmap(response);
                        }
                    }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mHandler.obtainMessage(IMAGE_FAIL).sendToTarget();
                }
            });
            mQuene.add(imageHeadRequest);
            mQuene.add(imageContentRequest);

        }
    }

    class ViewHolder {

        CircleImageView im_userhead;
        ImageView im_content_first;
        ImageView im_content_second;
        ImageView im_content_third;
        TextView tv_username;
        TextView tv_topicname;
        TextView tv_timepulish;
        TextView tv_topic_content;
        TextView tv_reply;
    }

}

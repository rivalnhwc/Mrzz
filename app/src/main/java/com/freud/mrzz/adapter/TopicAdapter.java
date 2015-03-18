package com.freud.mrzz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.freud.mrzz.R;
import com.freud.mrzz.entity.Topic;
import com.freud.mrzz.views.CircleImageView;

import java.util.List;

/**
 * Created by rival on 2015/3/12.
 */
public class TopicAdapter extends ArrayAdapter<Topic> {
    private int resource;

    public TopicAdapter(Context context, int resource, List<Topic> objects) {
        super(context, resource, objects);
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

        if (topic.getModel()==1){
            viewHolder.tv_username.setText(topic.getUser_name());
            viewHolder.tv_topicname.setText(topic.getTopic_name());
            viewHolder.tv_timepulish.setText(topic.getTime_publish());
            viewHolder.tv_reply.setText(topic.getReply_number()+"");
            viewHolder.tv_topic_content.setText(topic.getContent());

            viewHolder.im_userhead.setImageResource(topic.getImageID_userhead());
            viewHolder.im_content_first.setImageResource(topic.getImageID_content());
        }





        return view;
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

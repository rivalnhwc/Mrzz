package com.freud.mrzz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.freud.mrzz.R;
import com.freud.mrzz.entity.Comment;
import com.freud.mrzz.views.CircleImageView;

import java.util.List;

/**
 * Created by rival on 2015/3/19.
 */
public class CommentAdapter extends ArrayAdapter<Comment> {
    private int resource;

    public CommentAdapter(Context context, int resource, List<Comment> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resource, null);
            viewHolder = new ViewHolder();

            viewHolder.tv_username = (TextView) view.findViewById(R.id.id_tv_username_comment_itme);
            viewHolder.tv_content = (TextView) view.findViewById(R.id.id_tv_commentcontent_comment_itme);
            viewHolder.tv_timepulish = (TextView) view.findViewById(R.id.id_tv_timepublish_comment_itme);
            viewHolder.tv_floor_num = (TextView) view.findViewById(R.id.id_tv_floornum_comment_itme);
            viewHolder.im_userhead = (CircleImageView) view.findViewById(R.id.id_im_userhead_comment_itme);

            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (comment.getModel()==1) {
            viewHolder.im_userhead.setImageResource(comment.getImageID_userhead());
            viewHolder.tv_username.setText(comment.getUser_name());
            viewHolder.tv_content.setText(comment.getContent());
            viewHolder.tv_floor_num.setText(comment.getFloor_num());
            viewHolder.tv_timepulish.setText(comment.getTime_publish());
        }

        return view;
    }

    class ViewHolder {

        CircleImageView im_userhead;
        TextView tv_username;

        TextView tv_timepulish;
        TextView tv_content;
        TextView tv_floor_num;
    }
}

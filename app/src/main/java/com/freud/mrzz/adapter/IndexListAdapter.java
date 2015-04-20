package com.freud.mrzz.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.freud.mrzz.R;
import com.freud.mrzz.utils.ImageLoader;

import java.util.List;

/***
 * ADAPTER
 */

public class IndexListAdapter extends ArrayAdapter<String> {


    static class ViewHolder {
        RelativeLayout rl_index_recommend,rl_index_course;
    }

    private final LayoutInflater mLayoutInflater;

    private List<String> urls;
    private Context context;

    public IndexListAdapter(final Context context, final int ResourceId, List<String> urls) {
        super(context, ResourceId);
        mLayoutInflater = LayoutInflater.from(context);
        this.urls=urls;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.view_index_item, parent, false);
            vh = new ViewHolder();
            vh.rl_index_course=(RelativeLayout) convertView.findViewById(R.id.rl_index_course);
            vh.rl_index_recommend=(RelativeLayout) convertView.findViewById(R.id.rl_index_recommend);
            convertView.setTag(vh);
        }
        else {
            vh = (ViewHolder) convertView.getTag();
        }
        if(position%2==0)
        {
            vh.rl_index_recommend.setVisibility(View.VISIBLE);
            vh.rl_index_course.setVisibility(View.GONE);
        }else
        {
            vh.rl_index_course.setVisibility(View.VISIBLE);
            vh.rl_index_recommend.setVisibility(View.GONE);
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

}
package com.freud.mrzz.views;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.freud.mrzz.R;
import com.freud.mrzz.utils.ImageLoader;

import java.util.List;


/**
 * TODO: document your custom view class.
 */
public class IndexBtnsView extends RelativeLayout {

    LinearLayout ll_container;
    Context context;

    public IndexBtnsView(Context context) {
        super(context);
        init(context,null, 0);
    }

    public IndexBtnsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0);
    }

    public IndexBtnsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle);
    }

    @Override
    public void setVisibility(int visibility)
    {
        ll_container.setVisibility(visibility);
    }

    private void init(Context context,AttributeSet attrs, int defStyle) {
        LayoutInflater.from(context).inflate(R.layout.view_btns_index, this);
        ll_container=(LinearLayout) findViewById(R.id.ll_btns_container);
        this.context=context;
    }


}

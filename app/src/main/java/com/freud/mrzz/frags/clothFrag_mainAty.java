package com.freud.mrzz.frags;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freud.mrzz.R;
import com.freud.mrzz.adapter.MyPagerAdapter;
import com.freud.mrzz.views.MyViewPager;
import com.freud.mrzz.views.PagerSlidingTabStrip;

/**
 * Created by rival on 2015/3/8.
 * writed by wy on 2015/4/6.
 */
public class clothFrag_mainAty extends Fragment{

    View rootview;
    PagerSlidingTabStrip tabs;
    ViewPager pager;
    MyPagerAdapter adapter;

    Fragment[] fragments;
    Drawable[] drawables;
    String[] strings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_cloth_mainaty, container, false);
        tabs = (PagerSlidingTabStrip) rootview.findViewById(R.id.tabs_clothes_categories);
        pager = (ViewPager) rootview.findViewById(R.id.pager_colthes_categories);
        fragments=new Fragment[4];
        drawables=new Drawable[4];
        strings=new String[]{"上衣","裤子","裙子","鞋子"};
        drawables[0]=getResources().getDrawable(R.drawable.btn_jacket);
        drawables[1]=getResources().getDrawable(R.drawable.btn_pants);
        drawables[2]=getResources().getDrawable(R.drawable.btn_skirt);
        drawables[3]=getResources().getDrawable(R.drawable.btn_shoes);
        for(int x=0;x<4;x++) {
            fragments[x] = new colorTestFrag_testAty();
        }
        adapter = new MyPagerAdapter(getChildFragmentManager(),strings,drawables,fragments);
        pager.setOffscreenPageLimit(4);
        adapter.notifyDataSetChanged();
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        tabs.setIndicatorColor(getResources().getColor(R.color.white));
        return rootview;
    }
}

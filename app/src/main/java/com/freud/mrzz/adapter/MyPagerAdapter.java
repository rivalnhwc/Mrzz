package com.freud.mrzz.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.freud.mrzz.R;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private String[] TITLES;
    private String[] ICONS;
    public Fragment[] FRAGMENTS;

    public MyPagerAdapter(FragmentManager fm, String[] titles, String[] icons, Fragment[] fragments) {
        super(fm);
        this.FRAGMENTS = fragments;
        this.ICONS = icons;
        this.TITLES = titles;

    }

    public String getPageIcon(int position) {
        return ICONS[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return FRAGMENTS.length;
    }

    @Override
    public Fragment getItem(int position) {
        return FRAGMENTS[position];
    }
}
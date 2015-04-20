package com.freud.mrzz.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class MyViewPager extends ViewPager {
    private boolean willIntercept= true;
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
// TODO Auto-generated constructor stub
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if(willIntercept){
            return super.onInterceptTouchEvent(arg0);
        }else{
            return false;
        }
    }
    public void setTouchIntercept(boolean value){
        willIntercept = value;
    }
}
package com.freud.mrzz.views;

import android.content.Context;
import android.os.Handler;
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * TODO: document your custom view class.
 */
public class AdsView extends RelativeLayout {

    RelativeLayout rl_container;
    ViewPager pager_ads;
    LinearLayout ll_indicater;
    Context context;
    adsAdapter adpter;
    int refreshCycle=4;

    private ScheduledExecutorService scheduledExecutorService;

    public AdsView(Context context) {
        super(context);
        init(context,null, 0);
    }

    public AdsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0);
    }

    public AdsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle);
    }

    @Override
    public void setVisibility(int visibility)
    {
        rl_container.setVisibility(visibility);
    }

    private void init(Context context,AttributeSet attrs, int defStyle) {
        LayoutInflater.from(context).inflate(R.layout.view_ads, this);
        rl_container=(RelativeLayout) findViewById(R.id.rl_ads_container);
        pager_ads=(ViewPager) findViewById(R.id.pager_ads);
        ll_indicater=(LinearLayout) findViewById(R.id.ll_ads_indicater);
        this.context=context;
    }

    class adsAdapter extends PagerAdapter
    {
        List<String> ads_urls;
        List<ImageView> ads;
        Context context;

        public void change_urls(List<String> urls)
        {
            this.ads_urls=urls;
            ads.clear();
            for(int x=0;x<ads_urls.size();x++)
            {
                ImageView temp=new ImageView(context);
                temp.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageLoader.getInstance(context).DisplayImage(ads_urls.get(x),temp);
                ads.add(temp);
            }
            notifyDataSetChanged();
        }

        public void clear()
        {
            ads_urls.clear();
            ads.clear();
            notifyDataSetChanged();
        }

        public adsAdapter(Context context,List<String> urls)
        {
            this.ads_urls=urls;
            this.context=context;
            this.ads=new ArrayList<>();
            for(int x=0;x<ads_urls.size();x++)
            {
                ImageView temp=new ImageView(context);
                temp.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageLoader.getInstance(context).DisplayImage(ads_urls.get(x),temp);
                ads.add(temp);
            }
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(ads.get(position%ads.size()),0);


            return ads.get(position%ads.size());
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            Log.d("hahaha","destroy at "+position);
            view.removeView(ads.get(position % ads.size()));
        }
    }

    public void init(List<String> urls,int refreshCycle)
    {
        this.refreshCycle=refreshCycle;
        init(urls);
        startAutoScroll();
    }

    public void init(List<String> urls)
    {
        if(urls.size()<=0)
        {
            ll_indicater.removeAllViews();
            setVisibility(GONE);
        }else
        {
            setVisibility(VISIBLE);
            ll_indicater.removeAllViews();
            for(int x=0;x<urls.size();x++)
            {
                if(x!=0) {
                    ImageView unselected = new ImageView(context);
                    unselected.setImageResource(R.drawable.indicater_unselected);
                    unselected.setAdjustViewBounds(true);
                    unselected.setPadding(7, 0, 7, 0);
                    ll_indicater.addView(unselected);
                }
                else {
                    ImageView selected = new ImageView(context);
                    selected.setImageResource(R.drawable.indicater_selected);
                    selected.setAdjustViewBounds(true);
                    selected.setPadding(7, 0, 7, 0);
                    ll_indicater.addView(selected);
                }
            }
        }

        if(adpter==null)
        {
            Log.d("hahaha","setadsadpter");
            adpter=new adsAdapter(context,urls);
            pager_ads.setAdapter(adpter);
            pager_ads.setCurrentItem((urls.size()) * 100);
//            pager_ads.setOffscreenPageLimit(urls.size());
            pager_ads.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i2) {
                }
                @Override
                public void onPageSelected(int i) {
                    setPosition(i);
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                }
            });// 页面改变监听器
        }else
        {
            if(urls.size()==0)
            adpter.clear();
            else
            {
                adpter.change_urls(urls);
                pager_ads.setOffscreenPageLimit(urls.size());
                pager_ads.setCurrentItem(0);
            }
        }


    }

    private void setPosition(int position)
    {
        if(position>=0) {
            position = position % ll_indicater.getChildCount();
            for (int x = 0; x < ll_indicater.getChildCount(); x++) {
                if (x != position)
                    ((ImageView) ll_indicater.getChildAt(x)).setImageResource(R.drawable.indicater_unselected);
                else
                    ((ImageView) ll_indicater.getChildAt(x)).setImageResource(R.drawable.indicater_selected);
            }
        }
    }


    private class ScrollTask implements Runnable {
      public void run() {
                  synchronized (pager_ads) {
           handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
         }
      }
   }

    private Handler handler = new Handler() {
             public void handleMessage(android.os.Message msg) {

                    pager_ads.setCurrentItem(pager_ads.getCurrentItem()+1);
                  };
           };



    public void startAutoScroll()
    {
        if(scheduledExecutorService==null||scheduledExecutorService.isShutdown()) {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), refreshCycle+1, refreshCycle, TimeUnit.SECONDS);
        }
    }

    public void stopAutoScroll()
    {
        scheduledExecutorService.shutdown();
    }


}

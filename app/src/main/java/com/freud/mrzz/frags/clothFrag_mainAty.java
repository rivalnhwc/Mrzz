package com.freud.mrzz.frags;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
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
import com.freud.mrzz.entity.ClothCategoryOne;
import com.freud.mrzz.net.NetCore;
import com.freud.mrzz.views.MyViewPager;
import com.freud.mrzz.views.PagerSlidingTabStrip;
import com.google.gson.Gson;

/**
 * Created by rival on 2015/3/8.
 * writed by wy on 2015/4/6.
 */
public class clothFrag_mainAty extends Fragment{

    View rootview;
    PagerSlidingTabStrip tabs;
    ViewPager pager;
    MyPagerAdapter adapter;

    subClothFrag_mainAty[] fragments;
    String[] drawables;
    String[] strings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_cloth_mainaty, container, false);
        tabs = (PagerSlidingTabStrip) rootview.findViewById(R.id.tabs_clothes_categories);
        pager = (ViewPager) rootview.findViewById(R.id.pager_colthes_categories);
        new workingThread().start();
        return rootview;
    }

    void init(ClothCategoryOne categoryOne)
    {
        fragments=new subClothFrag_mainAty[categoryOne.category_one.size()];
        drawables=new String[categoryOne.category_one.size()];
        strings=new String[categoryOne.category_one.size()];//{"上衣","裤子","裙子","鞋子"};

        for(int x=0;x<categoryOne.category_one.size();x++) {
            fragments[x] = new subClothFrag_mainAty();
            strings[x]=categoryOne.category_one.get(x).cconame;
            drawables[x]=NetCore.ServerAddr+categoryOne.category_one.get(x).ccopic;
        }
        adapter = new MyPagerAdapter(getChildFragmentManager(),strings,drawables,fragments);
        pager.setOffscreenPageLimit(strings.length);
        adapter.notifyDataSetChanged();
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        tabs.setIndicatorColor(getResources().getColor(R.color.white));

    }


    class workingThread extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            get_cloth_category_1();
        }
    }

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            switch (msg.arg1)
            {
                case 1:
                    ClothCategoryOne category1=(ClothCategoryOne) msg.obj;
                    init(category1);
                    System.out.println("success");
                    break;
                case 0:
                    System.out.println("fault");
                    break;
            }
        }
    };

    private void get_cloth_category_1()
    {
        String jsonData = "{\"status\":1,\"category_one\":[{\"ccoid\":\"1\",\"cconame\":\"上衣\",\"ccopic\":\"clothes_category\\/jacket.png\"},{\"ccoid\":\"2\",\"cconame\":\"裤子\",\"ccopic\":\"clothes_category\\/trousers.png\"}]}";
//        String jsonData = new NetCore().get_cloth_category_1();
        if (jsonData != null)
        {
            ClothCategoryOne category1=null;
            try
            {
                Gson gson = new Gson();
                category1 = gson.fromJson(jsonData,ClothCategoryOne.class);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            Message msg = new Message();
            msg.obj=category1;
            msg.arg1 = category1.status;
            handler.sendMessage(msg);
        }else
        {
            Message msg = new Message();
            msg.arg1 = 0;
            handler.sendMessage(msg);
        }
    }
}

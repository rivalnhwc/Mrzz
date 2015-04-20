package com.freud.mrzz.atys;


import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;

import com.freud.mrzz.R;
import com.freud.mrzz.frags.bodyTestFrag_testAty;
import com.freud.mrzz.frags.colorTestFrag_testAty;
import com.freud.mrzz.frags.shapeTestFrag_testAty;
import com.freud.mrzz.frags.skinTestFrag_testAty;
import com.freud.mrzz.frags.styleTestFrag_testAty;
import com.freud.mrzz.views.MyViewPager;

/**
 * Created by wy on 2015/3/21.
 */

/**
 * 身高 体重
 * 体型
 * 肤色
 * 肤质
 * 年龄 age
 * 穿衣风格 style
 */

public class TestActivity extends ActionBarActivity {

    private MyViewPager pager;
    private TestAtyPagerAdapter adapter;
    ImageView[] indicater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        indicater=new ImageView[5];
        indicater[0]=(ImageView) findViewById(R.id.iv_indicater1);
        indicater[1]=(ImageView) findViewById(R.id.iv_indicater2);
        indicater[2]=(ImageView) findViewById(R.id.iv_indicater3);
        indicater[3]=(ImageView) findViewById(R.id.iv_indicater4);
        indicater[4]=(ImageView) findViewById(R.id.iv_indicater5);
        pager = (MyViewPager) findViewById(R.id.pager_testaty);
        adapter = new TestAtyPagerAdapter(getSupportFragmentManager());
        pager.setOffscreenPageLimit(5);
        adapter.notifyDataSetChanged();
        pager.setAdapter(adapter);
        ((bodyTestFrag_testAty)adapter.bodyFrag).setOnDragedListener(new bodyTestFrag_testAty.OnDragedListener() {
            @Override
            public void on_draged(boolean isdraging) {
                pager.setTouchIntercept(!isdraging);
            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                for(int x=0;x<indicater.length;x++)
                {
                    if(i==x)
                    indicater[x].setImageResource(R.drawable.test_indicater_selected);
                    else
                        indicater[x].setImageResource(R.drawable.test_indicater_unselected);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });// 页面改变监听器
    }

    public class TestAtyPagerAdapter extends FragmentPagerAdapter
    {
        public Fragment bodyFrag, styleFrag, skinFrag,shapeFrag,colorFrag;

        public TestAtyPagerAdapter(FragmentManager fm)
        {
            super(fm);
            bodyFrag=new bodyTestFrag_testAty();
            styleFrag=new styleTestFrag_testAty();
            skinFrag=new skinTestFrag_testAty();
            shapeFrag=new shapeTestFrag_testAty();
            colorFrag=new colorTestFrag_testAty();
        }

        @Override
        public int getCount()
        {
            return 5;
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0:
                    return bodyFrag;
                case 1:
                    return shapeFrag;
                case 2:
                    return colorFrag;
                case 4:
                    return styleFrag;
                case 3:
                    return skinFrag;
            }
            return null;
        }
    }
}

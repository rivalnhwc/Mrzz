package com.freud.mrzz.atys;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.freud.mrzz.R;
import com.freud.mrzz.frags.bodyTestFrag_testAty;

/**
 * Created by wy on 2015/3/21.
 */

/**
 * 身高 体重
 * 体型 body上下滑动调身高 左右滑动调体型
 * 肤色
 * 肤质
 * 年龄 age
 * 穿衣风格 style
 */

public class TestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_test_container, new bodyTestFrag_testAty()).commit();
    }

}

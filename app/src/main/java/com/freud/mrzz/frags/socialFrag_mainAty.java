package com.freud.mrzz.frags;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freud.mrzz.R;
import com.freud.mrzz.views.ColorTrackView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rival on 2015/3/8.
 */
public class socialFrag_mainAty extends Fragment implements View.OnClickListener {
    private String[] mTitles = new String[] { "晒服装", "晒美妆", "灌水区" };
    private ViewPager vpSocial_mainAty;
    private FragmentPagerAdapter mAdapter;
    private communityFrag_socialFrag[] mFragments = new communityFrag_socialFrag[mTitles.length];
    private List<ColorTrackView> mTabs = new ArrayList<ColorTrackView>();
    private ColorTrackView id_tab_first_socialfrag,id_tab_second_socialfrag,id_tab_third_socialfrag;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_social_mainaty, container, false);

        initViews(view);
        initDatas();
        initEvents();
        return view;
    }
    private void initEvents()
    {
        vpSocial_mainAty.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels)
            {
                if (positionOffset > 0)
                {
                    ColorTrackView left = mTabs.get(position);
                    ColorTrackView right = mTabs.get(position + 1);

                    left.setDirection(1);
                    right.setDirection(0);
                    com.freud.mrzz.utils.L.e("TAG", positionOffset+"");
                    left.setProgress( 1-positionOffset);
                    right.setProgress(positionOffset);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

    }
    private void initDatas() {

        for (int i = 0; i < mTitles.length; i++) {
            mFragments[i] = communityFrag_socialFrag.newInstance(mTitles[i]);
        }

        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

        };
        vpSocial_mainAty.setAdapter(mAdapter);
        vpSocial_mainAty.setCurrentItem(0);
    }
    private void initViews(View view){
        vpSocial_mainAty = (ViewPager) view.findViewById(R.id.vpSocial_mainAty);

        id_tab_first_socialfrag = (ColorTrackView) view.findViewById(R.id.id_tab_first_socialfrag);
        id_tab_second_socialfrag = (ColorTrackView) view.findViewById(R.id.id_tab_second_socialfrag);
        id_tab_third_socialfrag = (ColorTrackView) view.findViewById(R.id.id_tab_third_socialfrag);

        id_tab_first_socialfrag.setOnClickListener(this);
        id_tab_second_socialfrag.setOnClickListener(this);
        id_tab_third_socialfrag.setOnClickListener(this);

        mTabs.add((ColorTrackView) view.findViewById(R.id.id_tab_first_socialfrag));
        mTabs.add((ColorTrackView) view.findViewById(R.id.id_tab_second_socialfrag));
        mTabs.add((ColorTrackView) view.findViewById(R.id.id_tab_third_socialfrag));
    }

    @Override
    public void onClick(View v) {

        resetButtons();

        switch (v.getId()){
            case R.id.id_tab_first_socialfrag:
                mTabs.get(0).setProgress(1.0f);
                vpSocial_mainAty.setCurrentItem(0,false);
                break;
            case R.id.id_tab_second_socialfrag:
                mTabs.get(1).setProgress(1.0f);
                vpSocial_mainAty.setCurrentItem(1,false);
                break;
            case R.id.id_tab_third_socialfrag:
                mTabs.get(2).setProgress(1.0f);
                vpSocial_mainAty.setCurrentItem(2,false);
                break;
        }

    }
    private void resetButtons(){
        mTabs.get(0).setProgress(0);
        mTabs.get(1).setProgress(0);
        mTabs.get(2).setProgress(0);
    }
}

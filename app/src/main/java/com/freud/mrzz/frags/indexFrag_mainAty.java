package com.freud.mrzz.frags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.freud.mrzz.R;
import com.freud.mrzz.adapter.IndexListAdapter;
import com.freud.mrzz.atys.LoginActivity;
import com.freud.mrzz.views.AdsView;
import com.freud.mrzz.views.IndexBtnsView;
import com.freud.mrzz.views.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rival on 2015/3/8.
 */
public class indexFrag_mainAty extends Fragment{

    private ImageView iv_login_indexfrag,iv_shoppingcar;
    private PullToRefreshListView lv_index;
    AdsView ads;
    IndexBtnsView btns;
    IndexListAdapter adapter;
    LinearLayout ll_btn_index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index_mainaty, container, false);
        iv_login_indexfrag = (ImageView) view.findViewById(R.id.iv_login_indexfrag_mainaty);
        iv_shoppingcar=(ImageView) view.findViewById(R.id.iv_shopping_car);
        lv_index=(PullToRefreshListView) view.findViewById(R.id.lv_index);
        ads=new AdsView(getActivity());
        List<String> urls=new ArrayList<String>();
        urls.add("http://d06.res.meilishuo.net/pic/_o/fe/f0/7557d33197167944555000bde2e9_950_500.cf.jpg");
        urls.add("http://imgtest.meiliworks.com/pic/_o/81/90/67f2aa44e3db3e9ca3e09bd01960_950_500.ch.jpg");
        urls.add("http://d05.res.meilishuo.net/pic/_o/ae/7b/d2aee784a03f66033070a9b04419_950_500.ch.jpg");
        urls.add("http://d06.res.meilishuo.net/pic/_o/89/3d/787f9eb50ba1fe041efef9acf1ca_950_500.cf.jpg");
        urls.add("http://d06.res.meilishuo.net/img/_hd/a2/e2/ecc5b7fb0d1e50ec01f73b0c824d_2000_420.ch.jpg");


        iv_shoppingcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ads.setVisibility(View.GONE);
            }
        });

        lv_index.addHeaderView(ads);

        btns=new IndexBtnsView(getActivity());
        lv_index.addHeaderView(btns);


        adapter=new IndexListAdapter(getActivity(),R.layout.view_index_item,urls);
        lv_index.setAdapter(adapter);


        iv_login_indexfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getActivity(), LoginActivity.class);
                startActivity(i2);
            }
        });
        ads.init(urls,4);
        return view;
    }

    @Override
    public void onStart() {
        ads.startAutoScroll();
        super.onStart();
    }

    @Override
    public void onStop() {
        ads.stopAutoScroll();
        super.onStop();
    }
}

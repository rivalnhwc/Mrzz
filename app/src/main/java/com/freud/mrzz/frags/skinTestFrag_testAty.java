package com.freud.mrzz.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.freud.mrzz.R;

/**
 * Created by wy on 2015/3/21.
 */

public class skinTestFrag_testAty extends Fragment{

    LinearLayout[] ll_skin;
    ImageView[] iv_checked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_skin_testaty, container, false);
        ll_skin=new LinearLayout[5];
        iv_checked=new ImageView[5];
        ll_skin[0]=(LinearLayout) rootView.findViewById(R.id.ll_skin1);
        ll_skin[1]=(LinearLayout) rootView.findViewById(R.id.ll_skin2);
        ll_skin[2]=(LinearLayout) rootView.findViewById(R.id.ll_skin3);
        ll_skin[3]=(LinearLayout) rootView.findViewById(R.id.ll_skin4);
        ll_skin[4]=(LinearLayout) rootView.findViewById(R.id.ll_skin5);
        iv_checked[0]=(ImageView) rootView.findViewById(R.id.iv_checked_skin1);
        iv_checked[1]=(ImageView) rootView.findViewById(R.id.iv_checked_skin2);
        iv_checked[2]=(ImageView) rootView.findViewById(R.id.iv_checked_skin3);
        iv_checked[3]=(ImageView) rootView.findViewById(R.id.iv_checked_skin4);
        iv_checked[4]=(ImageView) rootView.findViewById(R.id.iv_checked_skin5);

        for(int x=0;x<5;x++)
            ll_skin[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int t=Integer.parseInt((String)v.getTag())-1;
                    for(int y=0;y<5;y++)
                    {
                        if(y==t)
                        {
                            iv_checked[y].setVisibility(View.VISIBLE);
                        }else
                        {
                            iv_checked[y].setVisibility(View.GONE);
                        }
                    }
                }
            });
        return rootView;
    }
}

package com.freud.mrzz.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.freud.mrzz.R;

/**
 * Created by wy on 2015/3/21.
 */

public class shapeTestFrag_testAty extends Fragment{

    ImageView[] shapes,checks;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_shape_testaty, container, false);
        shapes=new ImageView[5];
        shapes[0]=(ImageView) rootView.findViewById(R.id.iv_shape1);
        shapes[1]=(ImageView) rootView.findViewById(R.id.iv_shape2);
        shapes[2]=(ImageView) rootView.findViewById(R.id.iv_shape3);
        shapes[3]=(ImageView) rootView.findViewById(R.id.iv_shape4);
        shapes[4]=(ImageView) rootView.findViewById(R.id.iv_shape5);
        checks=new ImageView[5];
        checks[0]=(ImageView) rootView.findViewById(R.id.iv_shape_check1);
        checks[1]=(ImageView) rootView.findViewById(R.id.iv_shape_check2);
        checks[2]=(ImageView) rootView.findViewById(R.id.iv_shape_check3);
        checks[3]=(ImageView) rootView.findViewById(R.id.iv_shape_check4);
        checks[4]=(ImageView) rootView.findViewById(R.id.iv_shape_check5);
        for(int x=0;x<5;x++)
        shapes[x].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t=Integer.parseInt((String)v.getTag())-1;
                for(int y=0;y<5;y++)
                {
                    if(y==t)
                    {
                        checks[y].setVisibility(View.VISIBLE);
                    }else
                    {
                        checks[y].setVisibility(View.GONE);
                    }
                }
            }
        });
        return rootView;
    }
}

package com.freud.mrzz.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.Display;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.freud.mrzz.R;
import android.view.WindowManager.LayoutParams;

/**
 * Created by wy on 2015/3/21.
 */

public class bodyTestFrag_testAty extends Fragment{

    ImageView body;
    Button height,weight_l,weight_r;
    float pic_height,pic_width;
    float last_x,last_y;
    RelativeLayout rl_body;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_body_testaty, container, false);

        WindowManager m = getActivity().getWindowManager();
        Display d = m.getDefaultDisplay();

        pic_height = (int) (d.getHeight() * 0.75);
        pic_width = (int) (d.getWidth() * 0.75);

        rl_body=(RelativeLayout) rootView.findViewById(R.id.rl_body);
        rl_body.setLayoutParams(new RelativeLayout.LayoutParams((int)pic_width, (int)pic_height));
        body=(ImageView) rootView.findViewById(R.id.iv_body);
        height=(Button) rootView.findViewById(R.id.bt_height);
        weight_l=(Button) rootView.findViewById(R.id.bt_weight_left);
        weight_r=(Button) rootView.findViewById(R.id.bt_weight_right);

        height.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        last_y = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float y=event.getRawY();
                        float moveY = y - last_y;
                        last_y=y;
                        pic_height-=moveY;
                        rl_body.setLayoutParams(new RelativeLayout.LayoutParams((int)pic_width, (int)pic_height));
                        System.out.println(y);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }

                return false;
            }
        });

        return rootView;
    }

}

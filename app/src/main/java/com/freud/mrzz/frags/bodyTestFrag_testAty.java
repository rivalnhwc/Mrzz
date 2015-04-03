package com.freud.mrzz.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.freud.mrzz.R;
import com.freud.mrzz.utils.WidgetController;

/**
 * Created by wy on 2015/3/21.
 */

public class bodyTestFrag_testAty extends Fragment{

    ImageView body;
    Button height1,weight1,height2,weight2;
    float body_height,body_width,button_height,button_width;
    float last_y,last_x;
    float body_x,body_y,height_x=-1,height_y=-1,weight_x=-1,weight_y=-1;
    LinearLayout ll_height,ll_weight;
    int max_height=190,min_height=130,height;
    float max_weight=90,min_weight=35,weight;
    float max_x,max_y,min_x,min_y;
    boolean is_body_finished=false,is_height_finished=false,is_weight_finished=false;
    OnDragedListener OnDragedListener;

    public interface OnDragedListener
    {
        public void on_draged(boolean isdraging);
    }

    public void setOnDragedListener(OnDragedListener ondraged)
    {
        this.OnDragedListener=ondraged;
    }


    void setHeight(int h)
    {
        if(h>=min_height&&h<=max_height)
        {
            height=h;
            float moveY=max_y-(h-100)*(max_y-min_y)/(max_height-100)-height_y;
            height_y+=moveY;
            last_y=height_y;
            body_y+=moveY;
            body_height-=moveY;
            height1.setText("" + height);
            WidgetController.setLayout(ll_height, (int) height_x, (int) height_y);
            WidgetController.setLayout(body, (int) body_x, (int) body_y, (int) body_width, (int) body_height);
        }
    }

    void setWeight(float w)
    {
        weight=w;
        float moveX = (w-min_weight)*(max_x-min_x)/(max_weight-min_weight)+min_x-weight_x;
        weight_x+=moveX;
        last_x=weight_x;
        weight=(float)(Math.round(weight*2))/2;
        weight1.setText(""+weight);
        WidgetController.setLayout(ll_weight,(int)weight_x,(int)weight_y);
    }

    void init()
    {
        setHeight(165);
        setWeight(50);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_body_testaty, container, false);

        body=(ImageView) rootView.findViewById(R.id.iv_body);
        height1=(Button) rootView.findViewById(R.id.bt_height1);
        height2=(Button) rootView.findViewById(R.id.bt_height2);
        weight1=(Button) rootView.findViewById(R.id.bt_weight1);
        weight2=(Button) rootView.findViewById(R.id.bt_weight2);
        ll_height=(LinearLayout) rootView.findViewById(R.id.ll_height);
        ll_weight=(LinearLayout) rootView.findViewById(R.id.ll_weight);



        body.post(new Runnable() {
            @Override
            public void run() {
                body_x = body.getX();
                body_y = body.getY();
                is_body_finished=true;
                if(is_height_finished&&is_weight_finished)
                {
                    init();
                }
            }
        });

        ll_height.post(new Runnable() {
            @Override
            public void run() {
                height_x = ll_height.getX();
                height_y = ll_height.getY();
                max_x = height_x;
                min_y = height_y;
                if (weight_x >= 0 && weight_y >= 0) {
                    body_height = weight_y - height_y;
                    body_width = height_x - weight_x;
                    button_height = height1.getHeight();
                    button_width = height1.getWidth();
                }
                is_height_finished=true;
                if(is_weight_finished&&is_body_finished)
                {
                    init();
                }
            }
        });


        ll_weight.post(new Runnable() {
            @Override
            public void run() {
                weight_x=ll_weight.getX();
                weight_y=ll_weight.getY();
                min_x=weight_x;
                max_y=weight_y;
                if(height_x>=0&&height_y>=0)
                {
                    body_height=weight_y-height_y;
                    body_width=height_x-weight_x;
                    button_height=weight1.getHeight();
                    button_width=weight1.getWidth();
                }
                is_weight_finished=true;
                if(is_body_finished&&is_height_finished)
                {
                    init();
                }

            }
        });


        height1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OnDragedListener.on_draged(true);
                        last_y = event.getRawY();
                        height2.setVisibility(View.VISIBLE);
                        height_x-=button_width;
                        height1.setText(""+height);
                        height2.setText("");
                        WidgetController.setLayout(ll_height,(int)height_x,(int)height_y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float y=event.getRawY();
                        float moveY = y - last_y;
                        height_y+=moveY;
                        height=(int)((max_height-100)*(max_y-height_y)/(max_y-min_y))+100;
                        if(height<=max_height&&height>=min_height) {
                            last_y=y;
                            body_y+=moveY;
                            body_height-=moveY;
                            height1.setText("" + height);
                            height2.setText("");
                            WidgetController.setLayout(ll_height, (int) height_x, (int) height_y);
                            WidgetController.setLayout(body, (int) body_x, (int) body_y, (int) body_width, (int) body_height);
                        }else
                        {
                            height_y-=moveY;
                            height=(int)((max_height-100)*(max_y-height_y)/(max_y-min_y))+100;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        OnDragedListener.on_draged(false);
                        height2.setVisibility(View.GONE);
                        height_x+=button_width;
                        height1.setText(""+height);
                        WidgetController.setLayout(ll_height,(int)height_x,(int)height_y);
                        break;
                }

                return false;
            }
        });

        weight1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        OnDragedListener.on_draged(true);
                        last_x = event.getRawX();
                        weight2.setVisibility(View.VISIBLE);
                        weight_y-=button_height;
                        weight1.setText(""+weight);
                        weight2.setText("");
                        WidgetController.setLayout(ll_weight,(int)weight_x,(int)weight_y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float x=event.getRawX();
                        float moveX = x - last_x;
                        weight_x+=moveX;
                        if(weight_x>=min_x&&weight_x<=max_x)
                        {
                            last_x=x;
                            weight=(max_weight-min_weight)*(weight_x-min_x)/(max_x-min_x)+min_weight;
                            weight=(float)(Math.round(weight*2))/2;
                            weight1.setText(""+weight);
                            weight2.setText("");
                            WidgetController.setLayout(ll_weight,(int)weight_x,(int)weight_y);
                        }else
                        {
                            weight_x-=moveX;
                        }

                        break;
                    case MotionEvent.ACTION_UP:
                        OnDragedListener.on_draged(false);
                        weight2.setVisibility(View.GONE);
                        weight_y+=button_height;
                        weight1.setText(""+weight);
                        WidgetController.setLayout(ll_weight,(int)weight_x,(int)weight_y);
                        break;
                }

                return false;
            }
        });

        return rootView;
    }

}

package com.freud.mrzz.atys;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freud.mrzz.R;
import com.freud.mrzz.frags.clothFrag_mainAty;
import com.freud.mrzz.frags.indexFrag_mainAty;
import com.freud.mrzz.frags.makeupFrag_mainAty;
import com.freud.mrzz.frags.socialFrag_mainAty;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ImageView btn_bottom_tab_index_mainAty, btn_bottom_tab_cloth_mainAty,
            btn_bottom_tab_makeup_mainAty, btn_bottom_tab_social_mainAty;

    LinearLayout index,cloth,makeup,social;
    TextView tv_index,tv_cloth,tv_makeup,tv_social;

    private indexFrag_mainAty indexFrag;
    private clothFrag_mainAty clothFrag;
    private makeupFrag_mainAty makeupFrag;
    private socialFrag_mainAty socialFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        index=(LinearLayout) findViewById(R.id.ll_bottom_tab_index);
        cloth=(LinearLayout) findViewById(R.id.ll_bottom_tab_cloth);
        makeup=(LinearLayout) findViewById(R.id.ll_bottom_tab_makeup);
        social=(LinearLayout) findViewById(R.id.ll_bottom_tab_social);


        btn_bottom_tab_index_mainAty = (ImageView) findViewById(R.id.btn_bottom_tab_index_mainAty);
        btn_bottom_tab_cloth_mainAty = (ImageView) findViewById(R.id.btn_bottom_tab_cloth_mainAty);
        btn_bottom_tab_makeup_mainAty = (ImageView) findViewById(R.id.btn_bottom_tab_makeup_mainAty);
        btn_bottom_tab_social_mainAty = (ImageView) findViewById(R.id.btn_bottom_tab_social_mainAty);

        tv_index=(TextView) findViewById(R.id.tv_bottom_tab_index_mainAty);
        tv_cloth=(TextView) findViewById(R.id.tv_bottom_tab_cloth_mainAty);
        tv_makeup=(TextView) findViewById(R.id.tv_bottom_tab_makeup_mainAty);
        tv_social=(TextView) findViewById(R.id.tv_bottom_tab_social_mainAty);

        index.setOnClickListener(this);
        cloth.setOnClickListener(this);
        makeup.setOnClickListener(this);
        social.setOnClickListener(this);
//设置默认Fragment
        setDefaultFrag();


    }

    private void setDefaultFrag() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        indexFrag = new indexFrag_mainAty();
        clothFrag = new clothFrag_mainAty();
        makeupFrag = new makeupFrag_mainAty();
        socialFrag = new socialFrag_mainAty();
        transaction.replace(R.id.id_Content_mainAty, indexFrag);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        resetButton();

        switch (v.getId()) {
            case R.id.ll_bottom_tab_index:
                if (indexFrag.isVisible()) {

                } else {
                    tv_index.setTextColor(getResources().getColor(R.color.pink));
                    btn_bottom_tab_index_mainAty.setImageResource(R.drawable.tab_home_select);
                    hideVisualfrag(transaction);
                    if (indexFrag != null) {
                        if (indexFrag.isHidden()) {
                            transaction.show(indexFrag);
                        } else {
                            if (!indexFrag.isVisible()) {
                                transaction.add(R.id.id_Content_mainAty, indexFrag);
                            }
                        }
                    } else if (indexFrag == null) {
                        indexFrag = new indexFrag_mainAty();
                        transaction.add(R.id.id_Content_mainAty, indexFrag);
                    }
                }
                break;
            case R.id.ll_bottom_tab_cloth:
                if (clothFrag.isVisible()) {

                } else {
                    tv_cloth.setTextColor(getResources().getColor(R.color.pink));
                    btn_bottom_tab_cloth_mainAty.setImageResource(R.drawable.tab_cloth_select);
                    hideVisualfrag(transaction);
                    if (clothFrag != null) {
                        if (clothFrag.isHidden()) {
                            transaction.show(clothFrag);
                        } else {
                            if (!clothFrag.isVisible()) {
                                transaction.add(R.id.id_Content_mainAty, clothFrag);
                            }
                        }
                    } else if (clothFrag == null) {
                        clothFrag = new clothFrag_mainAty();
                        transaction.add(R.id.id_Content_mainAty, clothFrag);
                    }
                }
                break;
            case R.id.ll_bottom_tab_makeup:
                if (makeupFrag.isVisible()) {

                } else {
                    tv_makeup.setTextColor(getResources().getColor(R.color.pink));
                    btn_bottom_tab_makeup_mainAty.setImageResource(R.drawable.tab_makeup_select);
                    hideVisualfrag(transaction);
                    if (makeupFrag != null) {
                        if (makeupFrag.isHidden()) {
                            transaction.show(makeupFrag);
                        } else {
                            if (!makeupFrag.isVisible()) {
                                transaction.add(R.id.id_Content_mainAty, makeupFrag);
                            }
                        }
                    } else if (makeupFrag == null) {
                        makeupFrag = new makeupFrag_mainAty();
                        transaction.add(R.id.id_Content_mainAty, makeupFrag);
                    }
                }
                break;
            case R.id.ll_bottom_tab_social:

                if (socialFrag.isVisible()) {

                } else {
                    tv_social.setTextColor(getResources().getColor(R.color.pink));
                    btn_bottom_tab_social_mainAty.setImageResource(R.drawable.tab_social_select);
                    hideVisualfrag(transaction);
                    if (socialFrag != null) {
                        if (socialFrag.isHidden()) {
                            transaction.show(socialFrag);
                        } else {
                            if (!socialFrag.isVisible()) {
                                transaction.add(R.id.id_Content_mainAty, socialFrag);
                            }
                        }
                    } else if (socialFrag == null) {
                        socialFrag = new socialFrag_mainAty();
                        transaction.add(R.id.id_Content_mainAty, socialFrag);
                    }
                }
                break;

        }
        transaction.commit();
    }

    private void resetButton() {
        //button恢复未点击状态
        btn_bottom_tab_index_mainAty.setImageResource(R.drawable.tab_home_unselect);
        btn_bottom_tab_cloth_mainAty.setImageResource(R.drawable.tab_cloth_unselect);
        btn_bottom_tab_makeup_mainAty.setImageResource(R.drawable.tab_makeup_unselect);
        btn_bottom_tab_social_mainAty.setImageResource(R.drawable.tab_social_unselect);

        tv_index.setTextColor(getResources().getColor(R.color.black));
        tv_cloth.setTextColor(getResources().getColor(R.color.black));
        tv_makeup.setTextColor(getResources().getColor(R.color.black));
        tv_social.setTextColor(getResources().getColor(R.color.black));

    }

    private void hideVisualfrag(FragmentTransaction transaction) {
        //隐藏显示的Fragment 以保持刚才的状态
        if (indexFrag.isVisible()) {
            transaction.hide(indexFrag);
        } else if (clothFrag.isVisible()) {
            transaction.hide(clothFrag);
        } else if (makeupFrag.isVisible()) {
            transaction.hide(makeupFrag);
        } else if (socialFrag.isVisible()) {
            transaction.hide(socialFrag);
        }

    }
}

package com.freud.mrzz.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.freud.mrzz.R;
import com.freud.mrzz.adapter.ClothListAdapter;
import com.freud.mrzz.views.clothCategoriesView;
import com.staggeredgrid.library.ExtendableListView;
import com.staggeredgrid.library.StaggeredGridView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wy on 2015/4/11.
 */

public class subClothFrag_mainAty extends Fragment{


    private List<String> list=new ArrayList<String>();
    private String urls[] = {
            "http://d06.res.meilishuo.net/pic/_o/66/10/b0155d7d87280d96345302f4f3f9_640_900.cf.jpg_03dab2d7_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/41/b0/d4426d0e7c08666093a38cac0ff9_640_900.cf.jpg_945fb0ed_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/8c/e3/01f934b21ff47a9e4f86e36123b7_640_960.ch.jpg_ec9f9059_s1_q0_150_5_0_226_800.jpg",
            "http://d03.res.meilishuo.net/pic/_o/9c/d2/6fa905f93da76c0e4f2afb534407_640_832.cf.jpg_af4e831c_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/d0/8b/ba74262d520be7b8ba5211234b0a_640_840.cg.jpg_8f429c85_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/62/45/acb9a14fa2c562e2cd04ff1083e8_640_832.cg.jpg_8aa94f75_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/00/53/05be7e55806e4d50640c5b5d7c93_640_900.ch.jpg_6f9b6be9_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/a7/a9/b72abb0236a89159980ba0d2690d_750_1124.ch.jpg_6cf97af1_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/51/9d/4260be419d5d3cf4ab044a275416_640_832.cf.jpg_2198d26d_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/97/91/a587368555ae1cd9bf453a084bfe_640_900.cf.jpg_d3a87893_s1_q0_150_5_0_226_800.jpg",
            "http://imgtest-dl.meiliworks.com/pic/_o/f9/04/f950ce6468b6bdbf8d339380ab19_640_832.cg.jpg_bfc5f3e7_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/c1/28/9ea8d77348ac899d472decc67d75_640_960.cg.jpg_3d0ec999_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/7d/24/be455cb3ec74532e2f7d559d94f1_640_900.cf.jpg_b1f12f6f_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/08/4d/382bc10d4cd6a60bad0cca4efff4_640_832.cf.jpg_53c42888_s1_q0_150_5_0_226_800.jpg",
            "http://d02.res.meilishuo.net/pic/_o/7b/a9/7f2d31363d2b57fa4ab618e94659_640_900.ch.jpg_6c8381cb_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/2c/a9/d6ee8f40e11e7554c58d96ea5b14_640_900.cf.jpg_77edfc52_s1_q0_150_5_0_226_800.jpg",
            "http://d03.res.meilishuo.net/pic/_o/94/ae/3f664031e53f8b1945fac715226d_640_832.cg.jpg_aa1f92de_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/5d/c7/79de5b488704cd5cff01f19512cc_640_832.ch.jpg_dca4b266_s1_q0_150_5_0_226_800.jpg",
            "http://d01.res.meilishuo.net/pic/_o/c0/6e/83ff737eece84ed45adcf95a3ea8_640_919.ch.jpg_7c92ff4f_s1_q0_150_5_0_226_800.jpg",
            "http://d03.res.meilishuo.net/pic/_o/94/ae/3f664031e53f8b1945fac715226d_640_832.cg.jpg_aa1f92de_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/b2/56/ba024910976897f48a12a9acd3f6_640_900.ch.jpg_27d4bc52_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/b5/03/0d5d119e178a14591360ff0db7c0_640_900.cf.jpg_858fe085_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/66/c7/cec4259116f5a3e6220d39e82fbf_640_900.cf.jpg_500e852d_s1_q0_150_5_0_226_800.jpg",
            "http://d03.res.meilishuo.net/pic/_o/c1/ad/62df7c000b22dd0ff02fb54ac7ff_640_832.cf.jpg_e2855156_s1_q0_150_5_0_226_800.jpg",
            "http://imgtest.meiliworks.com/pic/_o/13/6f/2bc3f371414ab1c55ab1789641b4_640_900.ch.jpg_03e40d1d_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/15/dd/e92eb20825ee1814a1fdbe2f736b_640_832.cf.png_6cb36255_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/d9/85/c3782ff093eb40695ac5f348e835_640_832.ch.jpg_544b48c4_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/39/83/1953c5a4f7af959115aefbc02fe6_680_900.ch.png_787e405a_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/b2/c9/fddad12e9b00039990d9478f25fd_640_832.ch.jpg_b945125a_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/54/76/f97d34a62e62657894df599a92ce_640_900.cf.jpg_91b8a734_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/56/28/88b9de1a6fd9f5d1fa130df7ec4e_640_960.ch.jpg_329e39a5_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/6f/2a/c082925f22eeb6b16deb5a23f5ca_640_832.cg.jpg_139adba0_s1_q0_150_5_0_226_800.jpg",
            "http://d02.res.meilishuo.net/pic/_o/48/59/121a831a2aed6b58d2bdf6363473_900_1440.ch.jpg_3de7ed12_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/bd/ef/8aae9f8b42ccfc19f1ff20c8b339_640_900.cg.jpg_73eacbff_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/3c/b9/95f612c0058bdaea477f84d3216a_640_832.cg.jpg_01249fa1_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/7a/ac/6fef2837b59b85a959543a4e1d11_640_900.cf.png_9e61c894_s1_q0_150_5_0_226_800.jpg",
            "http://d02.res.meilishuo.net/pic/_o/51/e5/023952ae90dcdda7c634f0cac1de_640_842.cf.jpg_388934f8_s1_q0_150_5_0_226_800.jpg",
            "http://d03.res.meilishuo.net/pic/_o/31/f3/f1abbdbadb3af13a911ed907050c_640_832.cf.jpg_18bc9ce5_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/33/64/7d8cf41cd4e6846f921bf2ead133_640_832.cf.jpg_f7a8278c_s1_q0_150_5_0_226_800.jpg",
            "http://imgtest-dl.meiliworks.com/pic/_o/a5/4e/f568c07ebd40421a516853921f46_640_900.c6.jpg_fa5e2c27_s1_q0_150_5_0_226_800.jpg",
            "http://d02.res.meilishuo.net/pic/_o/88/55/11f523fc0e92685399c718b54e66_640_900.ch.jpg_8d79bd4e_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/42/7f/16021435a1a42c339fa1ec91525b_853_1200.ch.jpg_273fceb3_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/3d/f8/d734f47538e56a88a5b90dbb9b57_640_960.cf.jpg_0e22e057_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/f5/14/a64c63c8be193d74b01fe0b2856a_640_900.cg.jpg_b923790c_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/1c/94/87b6479028baaa264f3bec06a2be_640_900.cf.jpg_64867a9b_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/27/57/a0c7faa75ea7598633c900362826_640_941.cg.jpg_3317c7ae_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/cb/97/8255c8e1a9fad16cd08d123d39b6_640_832.cg.jpg_00f8a662_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/02/f5/a17607b5004771433a4ea6f68482_675_950.cg.jpg_d9376b42_s1_q0_150_5_0_226_800.jpg",
            "http://d06.res.meilishuo.net/pic/_o/7e/51/4f77ed6957e63593e94727c2e0a8_640_960.cg.jpg_9ee886ab_s1_q0_150_5_0_226_800.jpg",
            "http://d02.res.meilishuo.net/pic/_o/e8/87/a683ca07722e211bf6ceeff87c12_640_900.ch.jpg_0c9640e4_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/50/ab/b0519c249608fe775ced97959bbc_640_900.cf.jpg_937e96c0_s1_q0_150_5_0_226_800.jpg",
            "http://d03.res.meilishuo.net/pic/_o/bb/84/4a0731346e7cf4a88c50cc0218a7_640_900.cg.jpg_b958c866_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/fb/81/749b96d96bd2bdff5f7b7a8bc32f_640_900.cf.jpg_be103796_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/04/ab/d711dad269b1d59bf61162eeaf0d_640_900.ch.jpg_6317a037_s1_q0_150_5_0_226_800.jpg",
            "http://d04.res.meilishuo.net/pic/_o/6f/26/fb2fb56ae31614ad4e7e15e2e0e3_640_832.cg.png_ad8dd155_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/2a/2c/1d81f411586b31cf88d43e55f3b3_640_900.cg.jpg_d6ca6df0_s1_q0_150_5_0_226_800.jpg",
            "http://d05.res.meilishuo.net/pic/_o/37/2f/39ac74a3ac9380a509ce9ba2f047_640_900.cf.jpg_eb093809_s1_q0_150_5_0_226_800.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949614_8482.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949614_3743.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949614_4199.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949599_3416.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949599_5269.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949598_7858.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949598_9982.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949578_2770.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949578_8744.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949577_5210.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949577_1998.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949482_8813.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949481_6577.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949480_4490.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949455_6792.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949455_6345.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949442_4553.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949441_8987.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949441_5454.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949454_6367.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949442_4562.jpg"
    };

    View rootview;
int count=0;
    public StaggeredGridView gridView;
    public ImageButton gotoTop;
    View header1;
    ClothListAdapter adapter;

    private void add()
    {
        Log.i("wang", "add more" );
        for(int x=0;x<10;x++,count++)
            list.add(urls[count%urls.length]);
//        Log.d("abcdef","      a                 "+gridView.getIsLoadingMore());
        if(adapter!=null)
        adapter.notifyDataSetChanged();
//        Log.d("abcdef","      b                 "+gridView.getIsLoadingMore());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_cloth_sub, container, false);
        gridView = (StaggeredGridView) rootview.findViewById(R.id.gv_cloth_list);
        gotoTop=(ImageButton) rootview.findViewById(R.id.btn_goto_top);
        gotoTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.resetToTop();
            }
        });
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        header1 = new clothCategoriesView(getActivity());

        gridView.addHeaderView(header1);

        add();

        gridView.setOnLoadMoreListener(new ExtendableListView.OnLoadMoreListener() {
            @Override
            public void OnLoadMore() {
                add();
                gridView.onLoadMoreComplete(1);
            }
        });
        gridView.setOnTopShowingStateChangeListener(new ExtendableListView.OnTopShowingStateChangeListener() {
            @Override
            public void OnTopShowingStateChange(boolean isOnTop) {
                if(isOnTop)
                {
                    gotoTop.setVisibility(View.GONE);
                }else
                    gotoTop.setVisibility(View.VISIBLE);
            }
        });
        gridView.setonRefreshListener(new ExtendableListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                add();
                gridView.onRefreshComplete(1);
            }
        });

        adapter = new ClothListAdapter(getActivity(), R.id.iv_cloth, list);


        gridView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        return rootview;
    }

}

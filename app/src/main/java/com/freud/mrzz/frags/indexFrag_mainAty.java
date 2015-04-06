package com.freud.mrzz.frags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.freud.mrzz.R;
import com.freud.mrzz.atys.LoginActivity;
import com.freud.mrzz.atys.PersonalActivity;

/**
 * Created by rival on 2015/3/8.
 */
public class indexFrag_mainAty extends Fragment implements View.OnClickListener {

    private ImageView iv_personal,iv_login_register;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index_mainaty, container, false);

        iv_personal = (ImageView) view.findViewById(R.id.iv_topersonalaty_indexfrag_mainaty);
        iv_login_register = (ImageView) view.findViewById(R.id.iv_login_register_indexfrag);
        iv_personal.setOnClickListener(this);
        iv_login_register.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_topersonalaty_indexfrag_mainaty:
                Intent i = new Intent(getActivity(), PersonalActivity.class);
                startActivity(i);
                break;
            case R.id.iv_login_register_indexfrag:
                Intent i2 = new Intent(getActivity(), LoginActivity.class);
                startActivity(i2);
                break;
        }
    }
}

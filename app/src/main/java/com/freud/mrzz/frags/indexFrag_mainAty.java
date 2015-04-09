package com.freud.mrzz.frags;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.freud.mrzz.R;
import com.freud.mrzz.atys.LoginActivity;

/**
 * Created by rival on 2015/3/8.
 */
public class indexFrag_mainAty extends Fragment implements View.OnClickListener{

    private ImageView iv_login_indexfrag;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index_mainaty, container, false);
        iv_login_indexfrag = (ImageView) view.findViewById(R.id.iv_login_indexfrag_mainaty);
        iv_login_indexfrag.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_login_indexfrag_mainaty:
                Intent i2 = new Intent(getActivity(), LoginActivity.class);
                startActivity(i2);
                break;
        }
    }
}

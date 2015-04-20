package com.freud.mrzz.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.freud.mrzz.R;

/**
 * Created by rival on 2015/4/17.
 */
public class PubImageView extends FrameLayout {
    private ImageView iv_delete_image,iv_image;
    public PubImageView(Context context) {
        super(context);
        initView(context);

    }

    public PubImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PubImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pub_imageview, null);
        iv_delete_image = (ImageView) view.findViewById(R.id.iv_delete_image);
        iv_image= (ImageView)view.findViewById(R.id.iv_image_add);


    }

    public ImageView getIv_delete_image() {
        return iv_delete_image;
    }

    public ImageView getIv_image() {
        return iv_image;
    }
    public void setImageViewBitmap(Bitmap bitmap){
        if (iv_image !=null){
            iv_image.setImageBitmap(bitmap);
        }
    }
}

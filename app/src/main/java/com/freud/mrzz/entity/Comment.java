package com.freud.mrzz.entity;

/**
 * Created by rival on 2015/3/19.
 */
public class Comment {

    private String user_name;
    private int imageID_userhead;
    private String content;
    private String time_publish;
    private String floor_num;
    private int model=0;

    public Comment(){

        model=0;

    }

    public Comment(String user_name,int imageID_userhead,String content,String time_publish,String floor_num){
        this.user_name = user_name;
        this.imageID_userhead = imageID_userhead;
        this.content = content;
        this.time_publish = time_publish;
        this.floor_num = floor_num;

        model=1;


    }

    public String getUser_name() {
        return user_name;
    }

    public int getImageID_userhead() {
        return imageID_userhead;
    }

    public String getContent() {
        return content;
    }

    public String getTime_publish() {
        return time_publish;
    }

    public String getFloor_num() {
        return floor_num;
    }

    public int getModel() {
        return model;
    }
}

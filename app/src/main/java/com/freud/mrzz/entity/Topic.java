package com.freud.mrzz.entity;

/**
 * Created by rival on 2015/3/11.
 */
public class Topic {
    private String user_name;
    private String topic_name;
    private String content;
    private String time_publish;
    private int imageID_userhead;
    private int imageID_content;
    private int reply_number;
    private int imageNum;
    private int model;

    public Topic() {
        model = 0;
    }

    public Topic(String user_name, String topic_name, String content, String time_publish, int imageID_userhead, int imageID_content, int reply_number, int imageNum) {

        model = 1;
        this.user_name = user_name;
        this.topic_name = topic_name;
        this.content = content;
        this.time_publish = time_publish;
        this.imageID_userhead = imageID_userhead;
        this.imageID_content = imageID_content;
        this.reply_number = reply_number;
        this.imageNum = imageNum;
    }

    public int getImageID_userhead() {
        return imageID_userhead;
    }

    public int getImageID_content() {
        return imageID_content;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public String getContent() {
        return content;
    }

    public String getTime_publish() {
        return time_publish;
    }

    public int getReply_number() {
        return reply_number;
    }

    public int getImageNum() {
        return imageNum;
    }

    public int getModel() {
        return model;
    }
}

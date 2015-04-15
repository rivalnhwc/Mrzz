package com.freud.mrzz.entity;

/**
 * Created by rival on 2015/3/11.
 */
public class Topic {
    public String user_name;
    public String topic_name;
    public String content;
    public String time_publish;
    public String imageID_userhead;
    public String imageID_content;
    public int reply_number;
    public int imageNum;


    public Topic(String user_name, String topic_name, String content, String time_publish, String imageID_userhead, String imageID_content, int reply_number, int imageNum) {

        this.user_name = user_name;
        this.topic_name = topic_name;
        this.content = content;
        this.time_publish = time_publish;
        this.imageID_userhead = imageID_userhead;
        this.imageID_content = imageID_content;
        this.reply_number = reply_number;
        this.imageNum = imageNum;
    }

    public String getImageID_userhead() {
        return imageID_userhead;
    }

    public String getImageID_content() {
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


}

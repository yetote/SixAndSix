package com.example.tf.sixandsix.bean;

/**
*DiscussModel 评论bean
*@author Swg
*@time 2017/9/28 11:02
*/

public class DiscussModel {
    private String username;
    private String image;
    private String connect;
    private String time;
    private boolean isAgree;
    private int number;

    public DiscussModel(String username, String image, String connect, String time, boolean isAgree, int number) {
        this.username = username;
        this.image = image;
        this.connect = connect;
        this.time = time;
        this.isAgree = isAgree;
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean getIsAgree() {
        return isAgree;
    }

    public void setAgree(boolean agree) {
        isAgree = agree;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

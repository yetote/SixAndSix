package com.example.tf.sixandsix.bean;

/**
 * Created by admin on 2017/9/8.
 */

public class EatModel {
    private String image;
    private String name;
    private String content;
    private int agree;
    private int discuss;
    private String time;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public int getDiscuss() {
        return discuss;
    }

    public void setDiscuss(int discuss) {
        this.discuss = discuss;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public EatModel(String image, String name, String content, int agree, int discuss, String time) {
        this.image = image;
        this.name = name;
        this.content = content;
        this.agree = agree;
        this.discuss = discuss;
        this.time = time;
    }
}

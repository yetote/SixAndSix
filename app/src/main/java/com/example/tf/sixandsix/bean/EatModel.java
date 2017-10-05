package com.example.tf.sixandsix.bean;

/**
*EatModel 美食bean
*@author Swg
*@time 2017/9/28 11:02
*/

public class EatModel {
    private String image;
    private String name;
    private String content;
    private int agree;
    private int discuss;
    private String time;
    private String title;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public EatModel(int id, String image, String name, String content, int agree, int discuss, String time, String title) {
        this.image = image;
        this.name = name;
        this.content = content;
        this.agree = agree;
        this.discuss = discuss;
        this.time = time;
        this.title = title;
        this.id = id;
    }
}

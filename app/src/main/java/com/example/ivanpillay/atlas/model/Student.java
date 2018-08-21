package com.example.ivanpillay.atlas.model;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("title")
    private String name;

    @SerializedName("albumId")
    private String roll;

    @SerializedName("id")
    private long id;

    @SerializedName("thumbnailUrl")
    private String picUrl;

    public Student(long id,String name, String roll, String url){
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.picUrl = url;
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public long getId(){return id;}

    public String getPicUrl(){return picUrl;}

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}

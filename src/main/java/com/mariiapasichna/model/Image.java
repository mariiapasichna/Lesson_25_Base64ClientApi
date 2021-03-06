package com.mariiapasichna.model;

import com.google.gson.annotations.Expose;

public class Image {
    private int id;
    private String name;
    private String image;

    public Image() {
    }

    public Image(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
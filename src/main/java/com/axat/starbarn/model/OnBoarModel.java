package com.axat.starbarn.model;

public class OnBoarModel {


    String title;
    String subtitle;
    int imageResource;

    public OnBoarModel(String title, String subtitle, int imageResource) {
        this.title = title;
        this.subtitle = subtitle;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}

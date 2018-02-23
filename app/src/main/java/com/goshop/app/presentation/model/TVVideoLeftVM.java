package com.goshop.app.presentation.model;

public class TVVideoLeftVM {

    private String nowPrice;

    private String oldPrice;

    private String percent;

    private String time;

    private String title;

    private int videoDefault;

    private String videoUrl;

    public TVVideoLeftVM(String nowPrice, String oldPrice, String percent, String time,
        String title, int videoDefault, String videoUrl) {
        this.nowPrice = nowPrice;
        this.oldPrice = oldPrice;
        this.percent = percent;
        this.time = time;
        this.title = title;
        this.videoDefault = videoDefault;
        this.videoUrl = videoUrl;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVideoDefault() {
        return videoDefault;
    }

    public void setVideoDefault(int videoDefault) {
        this.videoDefault = videoDefault;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}

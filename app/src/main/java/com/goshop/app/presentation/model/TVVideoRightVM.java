package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/11.
 */

public class TVVideoRightVM {

    private boolean isOnAir = false;

    private String time;

    private int videoDefault;

    private String videoUrl;

    public TVVideoRightVM(String time, String videoUrl, int videoDefault, boolean isOnAir) {
        this.time = time;
        this.videoUrl = videoUrl;
        this.videoDefault = videoDefault;
        this.isOnAir = isOnAir;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isOnAir() {
        return isOnAir;
    }

    public void setOnAir(boolean onAir) {
        isOnAir = onAir;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getVideoDefault() {
        return videoDefault;
    }

    public void setVideoDefault(int videoDefault) {
        this.videoDefault = videoDefault;
    }
}

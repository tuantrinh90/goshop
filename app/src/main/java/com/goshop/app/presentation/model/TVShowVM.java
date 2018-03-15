package com.goshop.app.presentation.model;

public class TVShowVM {

    private String day;

    private String duration;

    private int imageDefault;

    private String imageUrl;

    private boolean isCurrent = false;

    private String mouth;

    private String percent;

    private String priceNow;

    private String priceOld;

    private String title;

    private String week;

    public TVShowVM(String mouth, String day, String week, String duration, String percent,
        String title, String priceOld, String priceNow, String imageUrl, int imageDefault) {
        this.mouth = mouth;
        this.day = day;
        this.week = week;
        this.duration = duration;
        this.percent = percent;
        this.title = title;
        this.priceOld = priceOld;
        this.priceNow = priceNow;
        this.imageUrl = imageUrl;
        this.imageDefault = imageDefault;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageDefault() {
        return imageDefault;
    }

    public void setImageDefault(int imageDefault) {
        this.imageDefault = imageDefault;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(String priceOld) {
        this.priceOld = priceOld;
    }

    public String getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(String priceNow) {
        this.priceNow = priceNow;
    }
}

package com.goshop.app.presentation.model;

public class GoLoyaltyDealsVM {

    private String detail;

    private String end;

    private int iconDefault;

    private String imageUrl;

    private String name;

    private String time;

    public GoLoyaltyDealsVM(String imageUrl, int iconDefault, String name, String detail,
        String time, String end) {
        this.imageUrl = imageUrl;
        this.iconDefault = iconDefault;
        this.name = name;
        this.detail = detail;
        this.time = time;
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getIconDefault() {
        return iconDefault;
    }

    public void setIconDefault(int iconDefault) {
        this.iconDefault = iconDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

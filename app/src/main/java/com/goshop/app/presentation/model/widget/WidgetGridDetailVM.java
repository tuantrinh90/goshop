package com.goshop.app.presentation.model.widget;

public class WidgetGridDetailVM {

    private int iconDefault;

    private String imageUrl;

    private String now;

    private String old;

    private String percent;

    private String title;

    public WidgetGridDetailVM(String imageUrl, int iconDefault, String percent, String title,
        String old, String now) {
        this.imageUrl = imageUrl;
        this.iconDefault = iconDefault;
        this.percent = percent;
        this.title = title;
        this.old = old;
        this.now = now;
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

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }
}

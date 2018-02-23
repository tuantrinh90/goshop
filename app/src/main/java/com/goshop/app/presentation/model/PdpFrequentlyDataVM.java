package com.goshop.app.presentation.model;

public class PdpFrequentlyDataVM {

    private int icon;

    private String nowPrice;

    private String oldPrice;

    private String percent;

    private String title;

    public PdpFrequentlyDataVM(String title, String oldPrice, String nowPrice, String percent,
        int icon) {
        this.title = title;
        this.oldPrice = oldPrice;
        this.nowPrice = nowPrice;
        this.percent = percent;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

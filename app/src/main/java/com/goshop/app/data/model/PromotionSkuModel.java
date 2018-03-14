package com.goshop.app.data.model;

public class PromotionSkuModel {

    public static final int TYPE_BANNER = 0x01;

    public static final int TYPE_FILTER_WITH_DATA = 0x02;

    private int viewType;

    public PromotionSkuModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

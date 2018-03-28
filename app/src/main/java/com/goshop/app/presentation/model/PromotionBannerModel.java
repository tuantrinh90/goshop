package com.goshop.app.presentation.model;

public class PromotionBannerModel {

    public static final int VIEW_CENTER_BANNER = 0x02;

    public static final int VIEW_SCROLLER = 0x03;

    public static final int VIEW_TOP_BANNER = 0x01;

    private int viewType;

    public PromotionBannerModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

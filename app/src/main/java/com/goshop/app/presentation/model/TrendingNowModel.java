package com.goshop.app.presentation.model;

public class TrendingNowModel {

    public static final int VIEW_TYPE_BANNER = 0x01;

    public static final int VIEW_TYPE_HORIZONTAL_PRODUCTS = 0x02;

    public static final int VIEW_TYPE_SINGLE_BANNER = 0x03;

    public static final int VIEW_TYPE_VIDEOPLAYER = 0x04;

    private int viewType;

    public TrendingNowModel(int viewType) {

        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

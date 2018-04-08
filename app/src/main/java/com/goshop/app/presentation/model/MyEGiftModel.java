package com.goshop.app.presentation.model;

public class MyEGiftModel {

    public static final int VIEW_TYPE_CENTER = 0x01;

    public static final int VIEW_TYPE_DETAIL = 0x02;

    public static final int VIEW_TYPE_TOP = 0x03;

    public static final int VIEW_TYPE_NO_DATA = 0x04;

    private int viewType;

    public MyEGiftModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

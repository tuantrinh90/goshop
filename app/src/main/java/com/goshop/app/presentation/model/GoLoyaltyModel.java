package com.goshop.app.presentation.model;

public class GoLoyaltyModel {

    public static final int VIEW_TYPE_DETAIL = 0x02;

    public static final int VIEW_TYPE_TOP = 0x01;

    private int viewType;

    public GoLoyaltyModel(int viewType) {

        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

package com.goshop.app.presentation.model;

public class BrandsDetailModel {

    public static final int VIEW_TYPE_DETAIL_FILGER_LIST = 0x01;

    public static final int VIEW_TYPE_DETAIL_TOP = 0x02;

    private int viewType;

    public BrandsDetailModel(int viewType) {

        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

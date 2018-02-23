package com.goshop.app.presentation.model;

public class PointsModel {

    public static final int VIEW_TYPE_TOTAL = 1;

    public static final int VIEW_TYPE_TRANSACTIONS_DETAIL = 2;

    public static final int VIEW_TYPE_TRANSACTIONS_NODATA = 3;

    public static final int VIEW_TYPE_TRANSACTIONS_TITLE = 4;

    private int viewType;

    public PointsModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

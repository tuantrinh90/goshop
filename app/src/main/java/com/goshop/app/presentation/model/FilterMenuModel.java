package com.goshop.app.presentation.model;

public class FilterMenuModel {

    public static final int FILTER_EXPAND = 1;

    public static final int FILTER_FLOWBUTTONS = 2;

    public static final int FILTER_PRICE = 3;

    private int viewType;

    public FilterMenuModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

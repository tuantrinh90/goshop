package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/22.
 */

public class FilterMenuModel {

    public static final int FILTER_BRANDS = 3;

    public static final int FILTER_CATEGORY = 2;

    public static final int FILTER_EXPAND = 1;

    public static final int FILTER_PRICE = 4;

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

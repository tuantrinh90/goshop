package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/8.
 */

public class SettingsModel {

    public static final int VIEW_TYPE_SINGLE_DETAIL = 3;

    public static final int VIEW_TYPE_SWICTH_DETAIL = 2;

    public static final int VIEW_TYPE_TITLE = 1;

    private int viewType;

    public SettingsModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

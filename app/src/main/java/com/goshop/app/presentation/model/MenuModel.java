package com.goshop.app.presentation.model;

public class MenuModel {

    public static final int MENU_HEADER = 0x01;

    public static final int MENU_ITEM = 0x02;

    public static final int MENU_DIVIDER = 0X03;

    private int viewType;

    public MenuModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

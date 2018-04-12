package com.goshop.app.presentation.model;

public class MenuModel {

    public static final int MENU_HEADER = 0x01;

    public static final int MENU_ITEM = 0x02;

    public static final int MENU_DIVIDER = 0X03;

    private int viewType;

    private String menuType;

    public MenuModel(int viewType) {
        this.viewType = viewType;
    }

    public MenuModel(int viewType, String menuType) {
        this.viewType = viewType;
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

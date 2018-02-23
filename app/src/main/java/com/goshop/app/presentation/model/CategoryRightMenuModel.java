package com.goshop.app.presentation.model;

public class CategoryRightMenuModel {

    public static final int VIEW_TYPE_CHILD = 2;

    public static final int VIEW_TYPE_PARENT = 1;

    private int viewType;

    public CategoryRightMenuModel(int viewType) {

        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

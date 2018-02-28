package com.goshop.app.presentation.model.widget;

//todo this class may use later ,please keep it
public class ProductListModel {

    public static final int TYPE_SHOPPING_CART = 0x01;

    public static final int TYPE_SHOPPING_CART_APPLY = 0x02;

    private int viewType;

    public ProductListModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

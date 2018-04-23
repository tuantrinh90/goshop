package com.goshop.app.presentation.model;

public class ShoppingCartModel {

    public static final int CART_APPLY = 1;

    public static final int CART_PRODUCT = 2;

    private int viewType;

    public ShoppingCartModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

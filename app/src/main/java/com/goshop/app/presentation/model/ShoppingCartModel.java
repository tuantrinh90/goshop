package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/24.
 */

public class ShoppingCartModel {

    public static final int CART_APPLY = 2;

    public static final int CART_CHECKOUT = 3;

    public static final int CART_PRODUCT = 1;

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

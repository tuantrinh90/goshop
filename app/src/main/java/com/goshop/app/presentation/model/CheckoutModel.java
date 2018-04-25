package com.goshop.app.presentation.model;

public class CheckoutModel {

    private int viewType;

    public CheckoutModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

package com.goshop.app.presentation.model;

public class PdpAttributeModel {

    private int viewType;

    public static final int TYPE_SIZE = 1;

    public static final int TYPE_COLOR = 2;

    public PdpAttributeModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

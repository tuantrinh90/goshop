package com.goshop.app.presentation.model;

/**
 * this is the widget model for dynimac
 * Created by helen on 2018/2/5.
 */
public class WidgetViewModel {

    public static final int VIEW_TYPE_BANNER = 0x01;

    //TODO(HELEN) these(from 1 to 8) are wait for api and then rename
    public static final int VIEW_TYPE_ON_AIR = 0x02;

    public static final int VIEW_TYPE_SINGLE_PICTURE = 0x03;

    public static final int VIEW_TYPE_HORIZONTAL = 0x04;

    public static final int VIEW_TYPE_4 = 0x05;

    public static final int VIEW_TYPE_5 = 0x06;

    public static final int VIEW_TYPE_6 = 0x07;

    public static final int VIEW_TYPE_7 = 0x08;

    public static final int VIEW_TYPE_8 = 0x09;

    int viewType;

    public WidgetViewModel(int viewType) {

        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

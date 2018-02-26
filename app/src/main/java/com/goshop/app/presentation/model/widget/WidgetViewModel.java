package com.goshop.app.presentation.model.widget;

public class WidgetViewModel {

    public static final int VIEW_TYPE_ADDITIONAL_INFORMATION = 0x01;

    public static final int VIEW_TYPE_BANNER = 0x02;

    public static final int VIEW_TYPE_DELIVERY_INFO = 0x03;

    public static final int VIEW_TYPE_EXPAND_TITLE = 0x04;

    public static final int VIEW_TYPE_VIDEOPLAYER = 0x05;

    public static final int VIEW_TYPE_PDP_QA = 0x06;

    public static final int VIEW_TYPE_PDP_REVIEWS = 0x07;

    public static final int VIEW_TYPE_PDP_TOP_DETAILS = 0x08;

    public static final int VIEW_TYPE_PRODUCT_SCROLLER = 0x09;

    public static final int VIEW_TYPE_SEARCH_RESULT = 0x10;

    public static final int VIEW_TYPE_SINGLE_PICTURE = 0x11;

    public static final int VIEW_TYPE_SINGLE_TEXT = 0x12;

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

package com.goshop.app.presentation.model;

public class ProductDetailModel {

    public static final int DETAIL_ADDITIONAL_INFORMATION = 11;

    public static final int DETAIL_DELIVERY_INFO = 5;

    public static final int DETAIL_DETAILS_CONTENT = 6;

    public static final int DETAIL_EXPAND_TITLE = 3;

    public static final int DETAIL_FREQUENTLY_BOUGHT_TOGETHER = 12;

    public static final int DETAIL_PRODUCT_SUMMARY_CONTENT = 4;

    public static final int DETAIL_QUESTION_ANSWER = 8;

    public static final int DETAIL_QA_CONTENT_TOP = 7;

    public static final int DETAIL_REVIEWS = 10;

    public static final int DETAIL_REVIEWS_CONTENT_TOP = 9;

    public static final int DETAIL_TOP_VIEW = 1;

    public static final int DETAIL_TOP_CONTENT = 2;

    public static final int DETAIL_SINGLE_TEXT = 14;

    private int viewType;

    public ProductDetailModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

package com.goshop.app.presentation.model;

public class SearchFilterModel {

    public static final int SEARCH_CATEGORY = 1;

    public static final int SEARCH_KEYWORDS = 2;

    public static final int SEARCH_NO_DATA = 6;

    public static final int SEARCH_POPULAR_DETAIL = 4;

    public static final int SEARCH_POPULAR_DIVIDING = 5;

    public static final int SEARCH_POPULAR_TITLE = 3;

    public static final int SEARCH_RESULT = 7;

    private int viewType;

    public SearchFilterModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

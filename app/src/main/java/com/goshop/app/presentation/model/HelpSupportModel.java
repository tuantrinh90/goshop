package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/29.
 */

public class HelpSupportModel {

    public static final int HELP_CONTENT = 2;

    public static final int HELP_TITLE = 1;

    int viewType;

    public HelpSupportModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

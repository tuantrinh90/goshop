package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/22.
 */

public class FilterMenuExpandVM extends FilterMenuModel {

    private boolean isExpand;

    private String title;

    public FilterMenuExpandVM(String title, boolean isExpand) {
        super(FilterMenuModel.FILTER_EXPAND);
        this.title = title;
        this.isExpand = isExpand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }
}
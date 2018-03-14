package com.goshop.app.presentation.model;

public class PdpExpandTitleVM extends ProductDetailModel {

    private boolean clickable = false;

    private boolean isExpand;

    private String title;

    public PdpExpandTitleVM(boolean clickable, boolean isExpand, String title) {
        super(ProductDetailModel.DETAIL_EXPAND_TITLE);
        this.clickable = clickable;
        this.isExpand = isExpand;
        this.title = title;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

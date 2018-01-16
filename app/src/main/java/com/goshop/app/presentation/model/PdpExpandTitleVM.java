package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/11.
 */

public class PdpExpandTitleVM extends ProductDetailModel {

    public static final int HAS_ICON = 0;

    public static final int NO_ICON = 1;

    private int icon;

    private boolean isExpand;

    private String title;

    public PdpExpandTitleVM() {
        super(ProductDetailModel.DETAIL_EXPAND_TITLE);
    }

    public PdpExpandTitleVM(int icon, String title) {
        super(ProductDetailModel.DETAIL_EXPAND_TITLE);
        this.icon = icon;
        this.title = title;
    }

    public PdpExpandTitleVM(int icon, String title, boolean isExpand) {
        super(ProductDetailModel.DETAIL_EXPAND_TITLE);
        this.icon = icon;
        this.title = title;
        this.isExpand = isExpand;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
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

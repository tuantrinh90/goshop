package com.goshop.app.presentation.model;

public class CategoryLeftMenuVM {

    private int defaultIcon;

    private String iconUrl;

    private boolean isSelect;

    private String title;

    public CategoryLeftMenuVM(int defaultIcon, String iconUrl, String title) {
        this.defaultIcon = defaultIcon;
        this.iconUrl = iconUrl;
        this.title = title;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getDefaultIcon() {
        return defaultIcon;
    }

    public void setDefaultIcon(int defaultIcon) {
        this.defaultIcon = defaultIcon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

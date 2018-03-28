package com.goshop.app.presentation.model;

public class MenuItemVM extends MenuModel{

    private int icon;

    private boolean isSelect = false;

    private String title;

    public MenuItemVM(int icon, String title) {
        super(MenuModel.MENU_ITEM);
        this.icon = icon;
        this.title = title;
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

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}

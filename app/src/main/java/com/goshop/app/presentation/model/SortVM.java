package com.goshop.app.presentation.model;

public class SortVM {

    private boolean isSelect = false;

    private String title;

    public SortVM(String title) {
        this.title = title;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

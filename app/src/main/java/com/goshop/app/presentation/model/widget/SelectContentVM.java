package com.goshop.app.presentation.model.widget;

public class SelectContentVM {

    private String content;

    private boolean isSelect = false;

    public SelectContentVM(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}

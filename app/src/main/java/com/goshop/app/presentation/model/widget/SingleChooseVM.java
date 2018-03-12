package com.goshop.app.presentation.model.widget;

public class SingleChooseVM {

    private String content;

    private boolean isChoose = false;

    public SingleChooseVM(String content) {

        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }
}

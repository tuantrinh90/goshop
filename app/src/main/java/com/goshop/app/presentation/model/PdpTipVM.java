package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/31.
 */

public class PdpTipVM {

    private int bgColor;

    private String content;

    private int textColor;

    public PdpTipVM(String content, int textColor, int bgColor) {
        this.content = content;
        this.textColor = textColor;
        this.bgColor = bgColor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }
}

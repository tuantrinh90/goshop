package com.goshop.app.presentation.model;

public class CardRedeemVM {

    private String detail;

    private String end;

    private String thumb;

    private int thumbDefault;

    private String time;

    private String title;

    public CardRedeemVM(String thumb, int thumbDefault, String title, String detail,
        String time, String end) {
        this.thumb = thumb;
        this.thumbDefault = thumbDefault;
        this.title = title;
        this.detail = detail;
        this.time = time;
        this.end = end;

    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getThumbDefault() {
        return thumbDefault;
    }

    public void setThumbDefault(int thumbDefault) {
        this.thumbDefault = thumbDefault;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

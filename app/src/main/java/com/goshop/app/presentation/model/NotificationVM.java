package com.goshop.app.presentation.model;

public class NotificationVM {

    private String date;

    private String title;

    private boolean visible = true;

    public NotificationVM(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

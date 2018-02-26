package com.goshop.app.data.model.response;

public class ProductScrollerPageResponse {

    private int current;

    private String next;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}

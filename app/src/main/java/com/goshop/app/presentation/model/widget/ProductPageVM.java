package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/12.
 */

public class ProductPageVM {

    /**
     * current : 1
     * next : /widgetId=1005&page=2
     */

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

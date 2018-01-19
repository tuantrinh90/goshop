package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/18.
 */

public class SearchPopularDetailVM extends SearchFilterModel {

    private int icon;

    private String now;

    private String old;

    private String title;

    public SearchPopularDetailVM(int icon, String title, String old, String now) {
        super(SearchFilterModel.SEARCH_POPULAR_DETAIL);
        this.icon = icon;
        this.title = title;
        this.old = old;
        this.now = now;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

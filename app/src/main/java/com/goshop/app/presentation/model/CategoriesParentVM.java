package com.goshop.app.presentation.model;

import java.util.List;

public class CategoriesParentVM {

    private String icon;

    private int id;

    private String link;

    private String name;

    private List<CategoriesChildFirstVM> child;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoriesChildFirstVM> getChild() {
        return child;
    }

    public void setChild(List<CategoriesChildFirstVM> child) {
        this.child = child;
    }
}

package com.goshop.app.data.model.response;

import java.util.List;

public class CategoriesChild {

    private String icon;

    private int id;

    private String link;

    private String name;

    private int parent;

    private List<CategoriesChild> child;

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

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public List<CategoriesChild> getChild() {
        return child;
    }

    public void setChild(List<CategoriesChild> child) {
        this.child = child;
    }

}

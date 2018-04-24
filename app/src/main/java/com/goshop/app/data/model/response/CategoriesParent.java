package com.goshop.app.data.model.response;

import java.util.List;

public class CategoriesParent {

    private String icon;

    private int id;

    private String link;

    private String name;

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

    public List<CategoriesChild> getChild() {
        return child;
    }

    public void setChild(List<CategoriesChild> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "CategoriesParent{" +
            "icon='" + icon + '\'' +
            ", id=" + id +
            ", link='" + link + '\'' +
            ", name='" + name + '\'' +
            ", child=" + child +
            '}';
    }
}

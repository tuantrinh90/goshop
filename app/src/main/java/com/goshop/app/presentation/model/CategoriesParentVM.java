package com.goshop.app.presentation.model;

import java.util.List;

public class CategoriesParentVM {

    private String icon;

    private int mockIcon;

    private int id;

    private String link;

    private String name;

    private List<CategoriesChildVM> child;

    private boolean isSelect;

    public int getMockIcon() {
        return mockIcon;
    }

    public void setMockIcon(int mockIcon) {
        this.mockIcon = mockIcon;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

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

    public List<CategoriesChildVM> getChild() {
        return child;
    }

    public void setChild(List<CategoriesChildVM> child) {
        this.child = child;
    }

}

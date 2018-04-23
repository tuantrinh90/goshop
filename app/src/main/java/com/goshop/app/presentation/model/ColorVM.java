package com.goshop.app.presentation.model;

public class ColorVM {

    private String colorId;

    private String colorName;

    private String parentId;

    private String parentName;

    private boolean isSelect = false;

    public ColorVM(String parentId, String parentName, String colorId, String colorName) {

        this.colorId = colorId;
        this.colorName = colorName;
        this.parentId = parentId;
        this.parentName = parentName;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}

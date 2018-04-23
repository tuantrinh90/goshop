package com.goshop.app.presentation.model;

public class SizeVM {

    private String sizeId;

    private String sizeName;

    private String parentId;

    private String parentName;

    private boolean isSelect = false;

    public SizeVM(String parentId, String parentName, String sizeId, String sizeName) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.parentId = parentId;
        this.parentName = parentName;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
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

package com.goshop.app.presentation.model;

public class CategoryRightParentVM extends CategoryRightMenuModel {

    private boolean isExpand = false;

    private String title;

    public CategoryRightParentVM() {
        super(CategoryRightMenuModel.VIEW_TYPE_PARENT);
    }

    public CategoryRightParentVM(String title) {
        super(CategoryRightMenuModel.VIEW_TYPE_PARENT);
        this.title = title;

    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

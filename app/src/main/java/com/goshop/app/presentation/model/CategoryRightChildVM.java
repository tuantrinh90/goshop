package com.goshop.app.presentation.model;

public class CategoryRightChildVM extends CategoryRightMenuModel {

    private String title;

    public CategoryRightChildVM() {
        super(CategoryRightMenuModel.VIEW_TYPE_CHILD);
    }

    public CategoryRightChildVM(String title) {
        super(CategoryRightMenuModel.VIEW_TYPE_CHILD);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

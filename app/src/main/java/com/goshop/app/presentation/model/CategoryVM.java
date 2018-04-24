package com.goshop.app.presentation.model;

import java.util.List;

public class CategoryVM {

    private List<CategoriesParentVM> categories;

    public List<CategoriesParentVM> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesParentVM> categories) {
        this.categories = categories;
    }

}

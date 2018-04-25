package com.goshop.app.data.model.response;

import java.util.List;

public class CategoryResponse {

    private List<CategoriesParent> categories;

    public List<CategoriesParent> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesParent> categories) {
        this.categories = categories;
    }

}

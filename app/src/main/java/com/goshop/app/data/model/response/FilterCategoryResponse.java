package com.goshop.app.data.model.response;


import com.goshop.app.data.model.response.common.FilterCategorieData;

import java.util.List;

public class FilterCategoryResponse {

    private List<FilterCategorieData> categories;

    public List<FilterCategorieData> getCategories() {
        return categories;
    }

    public void setCategories(List<FilterCategorieData> categories) {
        this.categories = categories;
    }

}

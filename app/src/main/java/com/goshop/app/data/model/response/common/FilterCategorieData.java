package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class FilterCategorieData {
    /**
     * category_id : 1
     * category_name : Health
     */

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("category_name")
    private String categoryName;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

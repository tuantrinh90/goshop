package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class DealCategoryData {

    /**
     * category_id : 2
     * category_name : Food
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

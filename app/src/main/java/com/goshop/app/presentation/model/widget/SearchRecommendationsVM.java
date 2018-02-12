package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/12.
 */

public class SearchRecommendationsVM {

    private String category;

    /**
     * keyword : value
     * category : value
     */

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

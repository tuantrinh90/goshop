package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/18.
 */

public class SearchCategoryVM extends SearchFilterModel {

    private String category;

    private String keywords;

    public SearchCategoryVM(String keywords, String category) {
        super(SearchFilterModel.SEARCH_CATEGORY);
        this.keywords = keywords;
        this.category = category;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

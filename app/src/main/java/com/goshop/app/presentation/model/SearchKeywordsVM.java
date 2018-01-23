package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/18.
 */

public class SearchKeywordsVM extends SearchFilterModel {

    private String keywords;

    public SearchKeywordsVM(String keywords) {
        super(SearchFilterModel.SEARCH_KEYWORDS);
        this.keywords = keywords;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

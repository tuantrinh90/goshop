package com.goshop.app.presentation.model.widget;

import java.util.List;

/**
 * Created by helen on 2018/2/12.
 */

public class SearchResultDataVM {

    private List<ProductItemVM> products;

    private List<SearchRecommendationsVM> recommendations;

    public List<SearchRecommendationsVM> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<SearchRecommendationsVM> recommendations) {
        this.recommendations = recommendations;
    }

    public List<ProductItemVM> getProducts() {
        return products;
    }

    public void setProducts(List<ProductItemVM> products) {
        this.products = products;
    }

}

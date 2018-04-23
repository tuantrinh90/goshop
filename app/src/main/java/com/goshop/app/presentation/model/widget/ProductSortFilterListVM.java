package com.goshop.app.presentation.model.widget;

import com.goshop.app.presentation.model.SortVM;

import java.util.List;

public class ProductSortFilterListVM {

    private List<VideoProductsVM> productsVMS;

    private List<SortVM> sortVMS;

    public ProductSortFilterListVM(List<SortVM> sortVMS, List<VideoProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
        this.sortVMS = sortVMS;

    }

    public List<SortVM> getSortVMS() {
        return sortVMS;
    }

    public void setSortVMS(List<SortVM> sortVMS) {
        this.sortVMS = sortVMS;
    }

    public List<VideoProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<VideoProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }
}

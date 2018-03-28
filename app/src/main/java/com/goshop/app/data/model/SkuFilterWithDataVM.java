package com.goshop.app.data.model;

import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.List;

public class SkuFilterWithDataVM extends PromotionSkuModel {

    private List<FilterMenuModel> filterMenuModels;

    private List<ProductsVM> productsVMS;

    private List<SortVM> sortVMS;

    public SkuFilterWithDataVM(List<ProductsVM> productsVMS, List<SortVM> sortVMS,
        List<FilterMenuModel> filterMenuModels) {
        super(PromotionSkuModel.TYPE_FILTER_WITH_DATA);
        this.productsVMS = productsVMS;
        this.sortVMS = sortVMS;
        this.filterMenuModels = filterMenuModels;
    }

    public List<FilterMenuModel> getFilterMenuModels() {
        return filterMenuModels;
    }

    public void setFilterMenuModels(
        List<FilterMenuModel> filterMenuModels) {
        this.filterMenuModels = filterMenuModels;
    }

    public List<ProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<ProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }

    public List<SortVM> getSortVMS() {
        return sortVMS;
    }

    public void setSortVMS(List<SortVM> sortVMS) {
        this.sortVMS = sortVMS;
    }
}

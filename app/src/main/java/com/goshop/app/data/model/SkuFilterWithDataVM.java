package com.goshop.app.data.model;

import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.VideoProductsVM;

import java.util.List;

public class SkuFilterWithDataVM extends PromotionSkuModel {

    private List<FilterMenuModel> filterMenuModels;

    private List<VideoProductsVM> productsVMS;

    private List<SortVM> sortVMS;

    public SkuFilterWithDataVM(List<VideoProductsVM> productsVMS, List<SortVM> sortVMS,
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

    public List<VideoProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<VideoProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }

    public List<SortVM> getSortVMS() {
        return sortVMS;
    }

    public void setSortVMS(List<SortVM> sortVMS) {
        this.sortVMS = sortVMS;
    }
}

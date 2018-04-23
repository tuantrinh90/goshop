package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.VideoProductsVM;

import java.util.List;

public class TrendingHorizontalProductsVM extends TrendingNowModel {

    private String detailTitle;

    private List<VideoProductsVM> productsVMS;

    public TrendingHorizontalProductsVM(String detailTitle,
        List<VideoProductsVM> productsVMS) {
        super(TrendingNowModel.VIEW_TYPE_HORIZONTAL_PRODUCTS);
        this.detailTitle = detailTitle;
        this.productsVMS = productsVMS;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public List<VideoProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<VideoProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }
}

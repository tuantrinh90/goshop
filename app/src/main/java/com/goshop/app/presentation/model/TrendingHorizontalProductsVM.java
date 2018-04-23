package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.List;

public class TrendingHorizontalProductsVM extends TrendingNowModel {

    private String detailTitle;

    private List<ProductsVM> productsVMS;

    public TrendingHorizontalProductsVM(String detailTitle,
        List<ProductsVM> productsVMS) {
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

    public List<ProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<ProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }
}

package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.List;

public class PromotionBannerScrollerVM extends PromotionBannerModel {

    private List<ProductsVM> productsVMS;

    public PromotionBannerScrollerVM(List<ProductsVM> productsVMS) {
        super(PromotionBannerModel.VIEW_SCROLLER);
        this.productsVMS = productsVMS;
    }

    public List<ProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<ProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }
}

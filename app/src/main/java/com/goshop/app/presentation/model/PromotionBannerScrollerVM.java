package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.VideoProductsVM;

import java.util.List;

public class PromotionBannerScrollerVM extends PromotionBannerModel {

    private List<VideoProductsVM> productsVMS;

    public PromotionBannerScrollerVM(List<VideoProductsVM> productsVMS) {
        super(PromotionBannerModel.VIEW_SCROLLER);
        this.productsVMS = productsVMS;
    }

    public List<VideoProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<VideoProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }
}

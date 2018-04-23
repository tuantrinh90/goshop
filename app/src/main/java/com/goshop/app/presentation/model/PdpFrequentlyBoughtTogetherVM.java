package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.VideoProductsVM;

import java.util.List;

public class PdpFrequentlyBoughtTogetherVM extends ProductDetailModel {

    private List<VideoProductsVM> productsVMS;

    public PdpFrequentlyBoughtTogetherVM(
        List<VideoProductsVM> productsVMS) {
        super(ProductDetailModel.DETAIL_FREQUENTLY_BOUGHT_TOGETHER);
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

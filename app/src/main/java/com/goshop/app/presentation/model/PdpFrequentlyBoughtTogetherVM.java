package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.List;

public class PdpFrequentlyBoughtTogetherVM extends ProductDetailModel {

    private List<ProductsVM> productsVMS;

    public PdpFrequentlyBoughtTogetherVM(
        List<ProductsVM> productsVMS) {
        super(ProductDetailModel.DETAIL_FREQUENTLY_BOUGHT_TOGETHER);
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

package com.goshop.app.presentation.model.widget;

import java.util.List;

public class ProductFilterListVM {

    private List<ProductsVM> productsVMS;

    public ProductFilterListVM(
        List<ProductsVM> productsVMS) {
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

package com.goshop.app.presentation.model.widget;

public class ProductCartListVM extends ProductListModel {

    private VideoProductsVM productsVM;

    public ProductCartListVM(VideoProductsVM productsVM) {
        super(ProductListModel.TYPE_SHOPPING_CART);
        this.productsVM = productsVM;
    }

    public VideoProductsVM getProductsVM() {
        return productsVM;
    }

    public void setProductsVM(VideoProductsVM productsVM) {
        this.productsVM = productsVM;
    }
}

package com.goshop.app.presentation.model.widget;

public class ProductCartListVM extends ProductListModel {

    private ProductsVM productsVM;

    public ProductCartListVM(ProductsVM productsVM) {
        super(ProductListModel.TYPE_SHOPPING_CART);
        this.productsVM = productsVM;
    }

    public ProductsVM getProductsVM() {
        return productsVM;
    }

    public void setProductsVM(ProductsVM productsVM) {
        this.productsVM = productsVM;
    }
}

package com.goshop.app.presentation.model.widget;

public class ProductPriceVM {

    private ProductPriceRMVM rm;

    public ProductPriceVM(ProductPriceRMVM rm) {
        this.rm = rm;
    }

    public ProductPriceRMVM getRm() {
        return rm;
    }

    public void setRm(ProductPriceRMVM rm) {
        this.rm = rm;
    }
}

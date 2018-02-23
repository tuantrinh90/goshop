package com.goshop.app.presentation.model.widget;

public class ProductPriceVM {

    private ProductPriceRMVM RM;

    public ProductPriceVM(ProductPriceRMVM RM) {
        this.RM = RM;
    }

    public ProductPriceRMVM getRM() {
        return RM;
    }

    public void setRM(ProductPriceRMVM RM) {
        this.RM = RM;
    }

}

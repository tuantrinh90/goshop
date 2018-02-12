package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/12.
 */

public class ProductPriceVM {

    /**
     * RM : {"original":"200","discounted":149,"discountTitle":"25% OFF"}
     */

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

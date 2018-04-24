package com.goshop.app.presentation.model.widget;

public class ProductPriceRMVM {

    private String discountTitle;

    private String discounted;

    private String original;

    public ProductPriceRMVM(String discountTitle, String discounted, String original) {
        this.discountTitle = discountTitle;
        this.discounted = discounted;
        this.original = original;
    }

    public ProductPriceRMVM() {
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getDiscounted() {
        return discounted;
    }

    public void setDiscounted(String discounted) {
        this.discounted = discounted;
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

    public void setDiscountTitle(String discountTitle) {
        this.discountTitle = discountTitle;
    }
}

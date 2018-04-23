package com.goshop.app.presentation.model;

public class ShoppingCartApplyVM extends ShoppingCartModel {

    private String subTotal;

    private String discount;

    private String shipping;

    private String total;

    public ShoppingCartApplyVM() {
        super(ShoppingCartModel.CART_APPLY);
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

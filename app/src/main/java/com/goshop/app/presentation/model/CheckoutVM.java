package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ProductListModel;

import java.util.List;

public class CheckoutVM {

    private String shippingUserName;

    private String shippingAddressOne;

    private String shippingAddressTwo;

    private String shippingCityStatePost;

    private String shippingCountry;

    private String shippingTel;

    private boolean isUseSame = true;

    private String billingUserName;

    private String billingAddressOne;

    private String billingAddressTwo;

    private String billingCityStatePost;

    private String billingCountry;

    private String billingTel;

    private List<PaymentMethodVM> paymentMethodVMs;

    private List<ProductListModel> productListModels;

    private String subTotal;

    private String shipping;

    private String discountCode;

    private String discountAmount;

    private String eGiftCode;

    private String eGiftAmount;

    private String pointsApplied;

    private String pointsAmount;

    private String billingTotal;

    public String getShippingUserName() {
        return shippingUserName;
    }

    public void setShippingUserName(String shippingUserName) {
        this.shippingUserName = shippingUserName;
    }

    public String getShippingAddressOne() {
        return shippingAddressOne;
    }

    public void setShippingAddressOne(String shippingAddressOne) {
        this.shippingAddressOne = shippingAddressOne;
    }

    public String getShippingAddressTwo() {
        return shippingAddressTwo;
    }

    public void setShippingAddressTwo(String shippingAddressTwo) {
        this.shippingAddressTwo = shippingAddressTwo;
    }

    public String getShippingCityStatePost() {
        return shippingCityStatePost;
    }

    public void setShippingCityStatePost(String shippingCityStatePost) {
        this.shippingCityStatePost = shippingCityStatePost;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingTel() {
        return shippingTel;
    }

    public void setShippingTel(String shippingTel) {
        this.shippingTel = shippingTel;
    }

    public boolean isUseSame() {
        return isUseSame;
    }

    public void setUseSame(boolean useSame) {
        isUseSame = useSame;
    }

    public String getBillingUserName() {
        return billingUserName;
    }

    public void setBillingUserName(String billingUserName) {
        this.billingUserName = billingUserName;
    }

    public String getBillingAddressOne() {
        return billingAddressOne;
    }

    public void setBillingAddressOne(String billingAddressOne) {
        this.billingAddressOne = billingAddressOne;
    }

    public String getBillingAddressTwo() {
        return billingAddressTwo;
    }

    public void setBillingAddressTwo(String billingAddressTwo) {
        this.billingAddressTwo = billingAddressTwo;
    }

    public String getBillingCityStatePost() {
        return billingCityStatePost;
    }

    public void setBillingCityStatePost(String billingCityStatePost) {
        this.billingCityStatePost = billingCityStatePost;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingTel() {
        return billingTel;
    }

    public void setBillingTel(String billingTel) {
        this.billingTel = billingTel;
    }

    public List<PaymentMethodVM> getPaymentMethodVMs() {
        return paymentMethodVMs;
    }

    public void setPaymentMethodVMs(
        List<PaymentMethodVM> paymentMethodVMs) {
        this.paymentMethodVMs = paymentMethodVMs;
    }

    public List<ProductListModel> getProductListModels() {
        return productListModels;
    }

    public void setProductListModels(
        List<ProductListModel> productListModels) {
        this.productListModels = productListModels;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String geteGiftCode() {
        return eGiftCode;
    }

    public void seteGiftCode(String eGiftCode) {
        this.eGiftCode = eGiftCode;
    }

    public String geteGiftAmount() {
        return eGiftAmount;
    }

    public void seteGiftAmount(String eGiftAmount) {
        this.eGiftAmount = eGiftAmount;
    }

    public String getPointsApplied() {
        return pointsApplied;
    }

    public void setPointsApplied(String pointsApplied) {
        this.pointsApplied = pointsApplied;
    }

    public String getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(String pointsAmount) {
        this.pointsAmount = pointsAmount;
    }

    public String getBillingTotal() {
        return billingTotal;
    }

    public void setBillingTotal(String billingTotal) {
        this.billingTotal = billingTotal;
    }
}

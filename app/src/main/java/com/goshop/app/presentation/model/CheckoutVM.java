package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.common.ProductVM;

import java.util.List;

public class CheckoutVM {

    private boolean isUseSame = true;

    private List<AddressVM> addressVMS;

    private List<PaymentMethodVM> paymentMethodVMs;

    private List<ProductVM> productVMS;

    private String subTotal;

    private String shipping;

    private String discountCode;

    private String discountAmount;

    private String eGiftCode;

    private String eGiftAmount;

    private String pointsApplied;

    private String pointsAmount;

    private String billingTotal;

    public List<AddressVM> getAddressVMS() {
        return addressVMS;
    }

    public void setAddressVMS(List<AddressVM> addressVMS) {
        this.addressVMS = addressVMS;
    }

    public boolean isUseSame() {
        return isUseSame;
    }

    public void setUseSame(boolean useSame) {
        isUseSame = useSame;
    }

    public List<PaymentMethodVM> getPaymentMethodVMs() {
        return paymentMethodVMs;
    }

    public void setPaymentMethodVMs(
        List<PaymentMethodVM> paymentMethodVMs) {
        this.paymentMethodVMs = paymentMethodVMs;
    }

    public List<ProductVM> getProductVMS() {
        return productVMS;
    }

    public void setProductVMS(List<ProductVM> productVMS) {
        this.productVMS = productVMS;
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

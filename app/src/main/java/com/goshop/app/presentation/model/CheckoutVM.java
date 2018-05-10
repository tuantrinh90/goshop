package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.common.ProductVM;

import java.util.List;

public class CheckoutVM {

    private boolean isUseSame = true;

    private List<AddressVM> addressVMS;

    private List<PaymentMethodVM> paymentMethodVMs;

    private List<ProductVM> productVMS;

    private BillingVM billingVM;

    public BillingVM getBillingVM() {
        return billingVM;
    }

    public void setBillingVM(BillingVM billingVM) {
        this.billingVM = billingVM;
    }

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

}

package com.goshop.app.presentation.model;

public class PaymentStatusVM {

    private String email;

    private boolean isSuccess;

    private String orderId;

    private String tel;

    public PaymentStatusVM(String email, String orderId, String tel, boolean isSuccess) {
        this.email = email;
        this.orderId = orderId;
        this.tel = tel;
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

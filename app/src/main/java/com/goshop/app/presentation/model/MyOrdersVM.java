package com.goshop.app.presentation.model;

import java.util.List;

public class MyOrdersVM {

    private List<MyOrdersProductVM> myOrdersProductVMS;

    private String orderNumber;

    private String orderStatus;

    private String totalPrice;

    public MyOrdersVM(String orderNumber, String orderStatus,
        List<MyOrdersProductVM> myOrdersProductVMS, String totalPrice) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.myOrdersProductVMS = myOrdersProductVMS;
        this.totalPrice = totalPrice;
    }

    public List<MyOrdersProductVM> getMyOrdersProductVMS() {
        return myOrdersProductVMS;
    }

    public void setMyOrdersProductVMS(
        List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS = myOrdersProductVMS;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}

package com.goshop.app.presentation.model;

import java.util.List;

public class OrderDetailVM {

    private String method;

    private List<MyOrdersProductVM> myOrdersProductVMS;

    private String orderNumber;

    private String orderStatus;

    private String placeAt;

    private String shipAddress;

    private String shipCity;

    private String shipCountry;

    private String shipName;

    private String shipTel;

    public OrderDetailVM(String orderNumber, String orderStatus, String placeAt,
        String shipName, String shipAddress, String shipCity, String shipCountry,
        String shipTel, String method,
        List<MyOrdersProductVM> myOrdersProductVMS) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.placeAt = placeAt;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipCountry = shipCountry;
        this.shipTel = shipTel;
        this.method = method;
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

    public String getPlaceAt() {
        return placeAt;
    }

    public void setPlaceAt(String placeAt) {
        this.placeAt = placeAt;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getShipTel() {
        return shipTel;
    }

    public void setShipTel(String shipTel) {
        this.shipTel = shipTel;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<MyOrdersProductVM> getMyOrdersProductVMS() {
        return myOrdersProductVMS;
    }

    public void setMyOrdersProductVMS(
        List<MyOrdersProductVM> myOrdersProductVMS) {
        this.myOrdersProductVMS = myOrdersProductVMS;
    }
}

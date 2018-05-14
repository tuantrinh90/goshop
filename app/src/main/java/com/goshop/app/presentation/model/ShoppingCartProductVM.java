package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.common.ProductVM;

import java.util.List;

public class ShoppingCartProductVM {

    private String id;

    private String color;

    private int count;

    private int icon;

    private String nowPrice;

    private String oldPrice;

    private List<ProductVM> productVMS;

    private String title;

    private BillingVM billingVM;

    public ShoppingCartProductVM() {
    }

    public BillingVM getBillingVM() {
        return billingVM;
    }

    public void setBillingVM(BillingVM billingVM) {
        this.billingVM = billingVM;
    }

    public List<ProductVM> getProductVMS() {
        return productVMS;
    }

    public void setProductVMS(List<ProductVM> productVMS) {
        this.productVMS = productVMS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ProductListModel;

import java.util.List;

public class ShoppingCartProductVM{

    private String id;

    private String color;

    private int count;

    private int icon;

    private String nowPrice;

    private String oldPrice;

    private List<ProductListModel> productListModels;

    private String title;

    private String subTotal;

    private String discount;

    private String shipping;

    private String total;

    public ShoppingCartProductVM(){}

    public ShoppingCartProductVM(List<ProductListModel> productListModels) {
        this.productListModels = productListModels;
    }

    public ShoppingCartProductVM(String title, String color, String oldPrice,
        String nowPrice, int icon, int count) {
        this.title = title;
        this.color = color;
        this.oldPrice = oldPrice;
        this.nowPrice = nowPrice;
        this.icon = icon;
        this.count = count;
    }

    public List<ProductListModel> getProductListModels() {
        return productListModels;
    }

    public void setProductListModels(
        List<ProductListModel> productListModels) {
        this.productListModels = productListModels;
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

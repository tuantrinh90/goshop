package com.goshop.app.presentation.model;

public class ShoppingCartProductVM extends ShoppingCartModel {

    private String color;

    private int count;

    private int icon;

    private String nowPrice;

    private String oldPrice;

    private String title;

    public ShoppingCartProductVM(String title, String color, String oldPrice,
        String nowPrice, int icon, int count) {
        super(ShoppingCartModel.CART_PRODUCT);
        this.title = title;
        this.color = color;
        this.oldPrice = oldPrice;
        this.nowPrice = nowPrice;
        this.icon = icon;
        this.count = count;
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

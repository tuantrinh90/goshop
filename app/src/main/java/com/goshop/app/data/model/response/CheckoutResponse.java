package com.goshop.app.data.model.response;

import java.util.List;

/**
 * Created by img on 2018/2/2.
 */

public class CheckoutResponse {

    private String userName;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String tel;
    private List<CheckoutItem> checkoutItems;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<CheckoutItem> getCheckoutItems() {
        return checkoutItems;
    }

    public void setCheckoutItems(
        List<CheckoutItem> checkoutItems) {
        this.checkoutItems = checkoutItems;
    }

    public static class CheckoutItem{
        private String productName;
        private String color;
        private String size;
        private String oldPrice;
        private String currentPrice;
        private String amount;
        private String image;


        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(String oldPrice) {
            this.oldPrice = oldPrice;
        }

        public String getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(String currentPrice) {
            this.currentPrice = currentPrice;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}

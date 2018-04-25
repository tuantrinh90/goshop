package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class DiscountData {

    private String amount;

    /**
     * code : ASTRO10
     * amount : 10.00
     */

    private String code;

    private String discount;

    @SerializedName("discounted_price")
    private String discountedPrice;

    @SerializedName("original_price")
    private String originalPrice;

    /**
     * type : flat
     * discount : 10
     * original_price : 120
     * discounted_price : 110
     */

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

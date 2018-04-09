package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class RMData {

    @SerializedName("discount_title")
    private String discountTitle;

    private String discounted;

    /**
     * original : 200
     * discounted : 149
     * discount_title : 25% OFF
     */

    private String original;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getDiscounted() {
        return discounted;
    }

    public void setDiscounted(String discounted) {
        this.discounted = discounted;
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

    public void setDiscountTitle(String discountTitle) {
        this.discountTitle = discountTitle;
    }
}
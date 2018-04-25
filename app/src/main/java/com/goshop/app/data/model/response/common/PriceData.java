package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class PriceData {

    /**
     * RM : {"original":"200","discounted":"149","discount_title":"25% OFF"}
     */
    @SerializedName("RM")
    private RMData rm;

    @SerializedName("new_price")
    private String newPrice;

    /**
     * original_price : 120
     * new_price : 20
     */

    @SerializedName("original_price")
    private String originalPrice;

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public RMData getRM() {
        return rm;
    }

    public void setRM(RMData rm) {
        this.rm = rm;
    }
}

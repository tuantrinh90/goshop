package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

public class VideoRMResponse {

    @SerializedName("discount_title")
    private String discountTitle;

    private String discounted;

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

package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CancelData {

    private List<ReasonData> reason;

    @SerializedName("product_handling")
    private List<ProductHandlingData> productHandling;

    public List<ReasonData> getReason() {
        return reason;
    }

    public void setReason(List<ReasonData> reason) {
        this.reason = reason;
    }

    public List<ProductHandlingData> getProductHandling() {
        return productHandling;
    }

    public void setProductHandling(List<ProductHandlingData> productHandling) {
        this.productHandling = productHandling;
    }

}

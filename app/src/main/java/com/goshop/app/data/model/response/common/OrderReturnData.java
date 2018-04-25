package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderReturnData {

    @SerializedName("product_resolution")
    private List<ProductResolutionData> productResolution;

    private List<ReasonData> reason;

    public List<ReasonData> getReason() {
        return reason;
    }

    public void setReason(List<ReasonData> reason) {
        this.reason = reason;
    }

    public List<ProductResolutionData> getProductResolution() {
        return productResolution;
    }

    public void setProductResolution(List<ProductResolutionData> productResolution) {
        this.productResolution = productResolution;
    }

}

package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.GoshopPointsData;
import com.goshop.app.data.model.response.common.PriceData;

public class ApplyPointsResponse {

    /**
     * goshop_points : {"total":"100","applied":"10","balance":"90"}
     * price : {"original_price":"120","new_price":"110"}
     */

    @SerializedName("goshop_points")
    private GoshopPointsData goshopPoints;

    private PriceData price;

    public GoshopPointsData getGoshopPoints() {
        return goshopPoints;
    }

    public void setGoshopPoints(GoshopPointsData goshopPoints) {
        this.goshopPoints = goshopPoints;
    }

    public PriceData getPrice() {
        return price;
    }

    public void setPrice(PriceData price) {
        this.price = price;
    }

}

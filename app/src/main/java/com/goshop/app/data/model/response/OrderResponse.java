package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

public class OrderResponse {

    /**
     * order_id : 3425
     */

    @SerializedName("order_id")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}

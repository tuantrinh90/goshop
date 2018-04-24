package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class OrderBillingData {

    @SerializedName("RM")
    private OrderRMData rm;

    public OrderRMData getRm() {
        return rm;
    }

    public void setRm(OrderRMData rm) {
        this.rm = rm;
    }
}

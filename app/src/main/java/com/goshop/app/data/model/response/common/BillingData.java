package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class BillingData {
    /**
     * RM : {"sub_total":"100.00","discount":"20.00","shipping":"15.00","total":"95.00"}
     */

    @SerializedName("RM")
    private RMData rm;

    public RMData getRm() {
        return rm;
    }

    public void setRm(RMData rm) {
        this.rm = rm;
    }
}

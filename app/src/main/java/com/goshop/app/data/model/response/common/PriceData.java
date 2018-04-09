package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class PriceData {

    /**
     * RM : {"original":"200","discounted":"149","discount_title":"25% OFF"}
     */
    @SerializedName("RM")
    private RMData rm;

    public RMData getRM() {
        return rm;
    }

    public void setRM(RMData rm) {
        this.rm = rm;
    }
}

package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class DealMerchantData {

    /**
     * merchant_id : 20180419133833
     * merchant_name : Starbucks
     */

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("merchant_name")
    private String merchantName;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}

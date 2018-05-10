package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import com.goshop.app.data.model.response.common.BillingData;
import com.goshop.app.data.model.response.common.GoshopPointsData;
import com.goshop.app.data.model.response.common.PriceData;

public class ApplyPointsResponse {

    private BillingData billing;

    public BillingData getBilling() {
        return billing;
    }

    public void setBilling(BillingData billing) {
        this.billing = billing;
    }

}

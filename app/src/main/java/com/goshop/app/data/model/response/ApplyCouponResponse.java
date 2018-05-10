package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.BillingData;

public class ApplyCouponResponse {

    private BillingData billing;

    public BillingData getBilling() {
        return billing;
    }

    public void setBilling(BillingData billing) {
        this.billing = billing;
    }
}

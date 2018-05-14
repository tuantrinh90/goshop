package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.BillingData;
import com.goshop.app.data.model.response.common.EgiftCardData;
import com.goshop.app.data.model.response.common.PriceData;

public class ApplyEGiftResponse {

    private BillingData billing;

    public BillingData getBilling() {
        return billing;
    }

    public void setBilling(BillingData billing) {
        this.billing = billing;
    }
}

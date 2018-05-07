package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.DealsData;

import java.util.List;

public class DealsResponse {

    private List<DealsData> deals;

    public List<DealsData> getDeals() {
        return deals;
    }

    public void setDeals(List<DealsData> deals) {
        this.deals = deals;
    }
}

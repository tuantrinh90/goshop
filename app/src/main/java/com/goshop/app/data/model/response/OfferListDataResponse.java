package com.goshop.app.data.model.response;

import java.util.List;

public class OfferListDataResponse {

    private List<OfferListItemsResponse> items;

    public List<OfferListItemsResponse> getItems() {
        return items;
    }

    public void setItems(List<OfferListItemsResponse> items) {
        this.items = items;
    }
}

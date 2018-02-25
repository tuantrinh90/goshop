package com.goshop.app.data.model.response;

import java.util.List;

public class OfferListDataReponse {

    private List<OfferListItemsReponse> items;

    public List<OfferListItemsReponse> getItems() {
        return items;
    }

    public void setItems(List<OfferListItemsReponse> items) {
        this.items = items;
    }
}

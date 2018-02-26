package com.goshop.app.data.model.response;

import java.util.List;

public class ProductScrollerDataResponse {

    private List<ProductScrollerItemsResponse> items;

    public List<ProductScrollerItemsResponse> getItems() {
        return items;
    }

    public void setItems(List<ProductScrollerItemsResponse> items) {
        this.items = items;
    }
}

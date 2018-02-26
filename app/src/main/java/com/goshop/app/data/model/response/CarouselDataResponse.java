package com.goshop.app.data.model.response;

import java.util.List;

public class CarouselDataResponse {

    private List<CarouselItemsResponse> items;

    public List<CarouselItemsResponse> getItems() {
        return items;
    }

    public void setItems(List<CarouselItemsResponse> items) {
        this.items = items;
    }
}

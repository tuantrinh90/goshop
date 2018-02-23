package com.goshop.app.presentation.model.widget;

import java.util.List;

public class CarouselDataVM {

    private List<CarouselItemsVM> items;

    public CarouselDataVM(
        List<CarouselItemsVM> items) {
        this.items = items;
    }

    public List<CarouselItemsVM> getItems() {
        return items;
    }

    public void setItems(List<CarouselItemsVM> items) {
        this.items = items;
    }
}

package com.goshop.app.presentation.model.widget;

import java.util.List;

public class ProductDataVM {

    private List<ProductItemVM> items;

    public ProductDataVM(List<ProductItemVM> items) {
        this.items = items;
    }

    public List<ProductItemVM> getItems() {
        return items;
    }

    public void setItems(List<ProductItemVM> items) {
        this.items = items;
    }
}

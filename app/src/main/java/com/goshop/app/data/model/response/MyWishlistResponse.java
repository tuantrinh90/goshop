package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.ProductData;

import java.util.List;

public class MyWishlistResponse {

    private List<ProductData> product;

    public List<ProductData> getProduct() {
        return product;
    }

    public void setProduct(List<ProductData> product) {
        this.product = product;
    }
}

package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.data.model.response.common.ProductData;

import java.util.List;

public class MyWishlistResponse {

    private List<ProductData> product;

    private PaginationData pagination;

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }

    public List<ProductData> getProduct() {
        return product;
    }

    public void setProduct(List<ProductData> product) {
        this.product = product;
    }
}

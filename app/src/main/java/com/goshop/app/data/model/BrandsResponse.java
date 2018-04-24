package com.goshop.app.data.model;

import com.goshop.app.data.model.response.*;
import com.goshop.app.data.model.response.common.PaginationData;
import java.util.List;

public class BrandsResponse {

    private int total;

    private PaginationData pagination;

    private List<BrandListData> brands;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PaginationData getPagination() {
        return pagination;
    }

    public void setPagination(PaginationData pagination) {
        this.pagination = pagination;
    }

    public List<BrandListData> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandListData> brands) {
        this.brands = brands;
    }

}

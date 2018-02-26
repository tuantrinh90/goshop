package com.goshop.app.data.model.response;

public class ProductScrollerResponse extends BaseWidgetResponse {

    private ProductScrollerCountResponse count;

    private ProductScrollerDataResponse data;

    private ProductScrollerDetailsResponse details;

    private ProductScrollerPageResponse page;

    private String title;

    public ProductScrollerDataResponse getData() {
        return data;
    }

    public void setData(ProductScrollerDataResponse data) {
        this.data = data;
    }

    public ProductScrollerDetailsResponse getDetails() {
        return details;
    }

    public void setDetails(ProductScrollerDetailsResponse details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductScrollerCountResponse getCount() {
        return count;
    }

    public void setCount(ProductScrollerCountResponse count) {
        this.count = count;
    }

    public ProductScrollerPageResponse getPage() {
        return page;
    }

    public void setPage(ProductScrollerPageResponse page) {
        this.page = page;
    }


}

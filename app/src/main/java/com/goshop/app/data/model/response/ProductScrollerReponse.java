package com.goshop.app.data.model.response;

public class ProductScrollerReponse extends BaseWidgetReponse {

    private ProductScrollerCountReponse count;

    private ProductScrollerDataReponse data;

    private ProductScrollerDetailsReponse details;

    private ProductScrollerPageReponse page;

    private String title;

    public ProductScrollerDataReponse getData() {
        return data;
    }

    public void setData(ProductScrollerDataReponse data) {
        this.data = data;
    }

    public ProductScrollerDetailsReponse getDetails() {
        return details;
    }

    public void setDetails(ProductScrollerDetailsReponse details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductScrollerCountReponse getCount() {
        return count;
    }

    public void setCount(ProductScrollerCountReponse count) {
        this.count = count;
    }

    public ProductScrollerPageReponse getPage() {
        return page;
    }

    public void setPage(ProductScrollerPageReponse page) {
        this.page = page;
    }


}

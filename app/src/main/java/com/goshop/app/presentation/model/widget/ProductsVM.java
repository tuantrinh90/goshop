package com.goshop.app.presentation.model.widget;

import java.util.List;

public class ProductsVM {

    private List<String> attributes;

    private String id;

    private String image;

    private String link;

    private ProductPriceVM priceVM;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ProductPriceVM getPriceVM() {
        return priceVM;
    }

    public void setPriceVM(ProductPriceVM priceVM) {
        this.priceVM = priceVM;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }
}

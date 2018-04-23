package com.goshop.app.presentation.model.widget;

import java.util.List;

public class VideoProductsVM {

    private List<String> attributes;

    private List<String> labels;

    private String id;

    private String image;

    private String link;

    private String name;

    private String sku;

    private ProductPriceVM priceVM;

    private String title;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

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

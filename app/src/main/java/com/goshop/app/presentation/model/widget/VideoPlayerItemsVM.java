package com.goshop.app.presentation.model.widget;

import java.util.List;

public class VideoPlayerItemsVM {

    private String id;

    private String link;

    private String name;

    private List<ProductsVM> productsVMS;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<ProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<ProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }
}

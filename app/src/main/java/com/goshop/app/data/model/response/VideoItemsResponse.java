package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoItemsResponse {

    @SerializedName("id")
    private String idX;

    private String link;

    @SerializedName("name")
    private String nameX;

    private List<VideoProductsResponse> products;

    public String getIdX() {
        return idX;
    }

    public void setIdX(String idX) {
        this.idX = idX;
    }

    public String getNameX() {
        return nameX;
    }

    public void setNameX(String nameX) {
        this.nameX = nameX;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<VideoProductsResponse> getProducts() {
        return products;
    }

    public void setProducts(List<VideoProductsResponse> products) {
        this.products = products;
    }
}

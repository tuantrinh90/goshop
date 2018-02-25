package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoItemsReponse {

    @SerializedName("id")
    private String idX;

    private String link;

    @SerializedName("name")
    private String nameX;

    private List<VideoProductsReponse> products;

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

    public List<VideoProductsReponse> getProducts() {
        return products;
    }

    public void setProducts(List<VideoProductsReponse> products) {
        this.products = products;
    }
}

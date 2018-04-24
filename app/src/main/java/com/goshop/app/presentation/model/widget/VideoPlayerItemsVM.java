package com.goshop.app.presentation.model.widget;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoPlayerItemsVM {

    private String id;

    private String link;

    private String name;

    @SerializedName("playback_url")
    private String playbackUrl;

    private List<ProductsVM> productsVMS;

    public String getPlaybackUrl() {
        return playbackUrl;
    }

    public void setPlaybackUrl(String playbackUrl) {
        this.playbackUrl = playbackUrl;
    }

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

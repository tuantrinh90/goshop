package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoItemsResponse {

    private String id;

    @SerializedName("playback_url")
    private String playbackUrl;

    private String link;

    private String name;

    private List<VideoProductsResponse> products;

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

    public List<VideoProductsResponse> getProducts() {
        return products;
    }

    public void setProducts(List<VideoProductsResponse> products) {
        this.products = products;
    }
}

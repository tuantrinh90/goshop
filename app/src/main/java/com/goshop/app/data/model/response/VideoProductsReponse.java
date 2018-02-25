package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoProductsReponse {

    private List<String> attributes;

    @SerializedName("id")
    private String idX;

    private String image;

    private String link;

    private VideoPriceReponse price;

    private String title;

    public String getIdX() {
        return idX;
    }

    public void setIdX(String idX) {
        this.idX = idX;
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

    public VideoPriceReponse getPrice() {
        return price;
    }

    public void setPrice(VideoPriceReponse price) {
        this.price = price;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }


}

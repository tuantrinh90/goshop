package com.goshop.app.data.model.response.common;

import java.util.List;

public class BannerData {

    /**
     * id : 123
     * position : 0
     * images : [{"path":"https://image.goshop.com.my/banner1.jpg","link":"https://api.goshop.com
     * .my/catalog/product/123"}]
     */

    private String id;

    private int position;

    private List<ImagesData> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<ImagesData> getImages() {
        return images;
    }

    public void setImages(List<ImagesData> images) {
        this.images = images;
    }
}

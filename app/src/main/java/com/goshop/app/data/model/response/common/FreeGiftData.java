package com.goshop.app.data.model.response.common;

public class FreeGiftData {

    private String image;

    private String name;

    /**
     * sku : 123
     * name : Free gift
     * image : https://image.goshop.com.my/resources/ms/image/contents/prd/22/32/9102820_01_35.jpg
     */

    private String sku;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

package com.goshop.app.data.model.response;

public class BrandListData {

    /**
     * id : 123
     * name : Philips
     * image : https://image.goshop.com.my/brand1.jpg
     * link : http://<domain-name>/<base-path>/catalog/product?website_id=1&store_id=3&limit
     * =10&page=1&brand=123
     */

    private String id;

    private String name;

    private String image;

    private String link;

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
}

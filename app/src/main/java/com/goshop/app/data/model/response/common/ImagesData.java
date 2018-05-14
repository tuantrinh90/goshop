package com.goshop.app.data.model.response.common;

public class ImagesData {

    /**
     * path : https://image.goshop.com.my/banner1.jpg
     * link : https://api.goshop.com.my/catalog/product/123
     */

    private String path;

    private String link;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

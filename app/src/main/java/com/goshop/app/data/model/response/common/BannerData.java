package com.goshop.app.data.model.response.common;

public class BannerData {

    /**
     * id : 123
     * type : event
     * link : /event1
     * image : https://image.goshop.com.my/banner1.jpg
     */

    private int id;

    private String type;

    private String link;

    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

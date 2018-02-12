package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/12.
 */

public class CarouselItemsVM {

    /**
     * image : https://image.goshop.com.my/resources/ms/image/contents/prd/22/32
     * /20052232_01_400.jpg
     * link : /prd/20052232
     */

    private String image;

    private String link;

    public CarouselItemsVM(String image) {
        this.image = image;
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

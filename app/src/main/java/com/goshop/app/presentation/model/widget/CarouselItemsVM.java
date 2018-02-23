package com.goshop.app.presentation.model.widget;

public class CarouselItemsVM {

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

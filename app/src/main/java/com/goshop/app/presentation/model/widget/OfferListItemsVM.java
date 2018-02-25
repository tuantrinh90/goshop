package com.goshop.app.presentation.model.widget;

public class OfferListItemsVM {

    private int iconDefault;

    private String image;

    private String link;

    public OfferListItemsVM(int iconDefault, String image, String link) {
        this.iconDefault = iconDefault;
        this.image = image;
        this.link = link;
    }

    public int getIconDefault() {
        return iconDefault;
    }

    public void setIconDefault(int iconDefault) {
        this.iconDefault = iconDefault;
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

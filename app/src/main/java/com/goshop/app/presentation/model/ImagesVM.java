package com.goshop.app.presentation.model;

import android.os.Parcel;

public class ImagesVM {

    private int imageDefault;

    private String imageUrl;

    private boolean isSelected = false;

    public ImagesVM(int imageDefault, String imageUrl) {
        this.imageDefault = imageDefault;
        this.imageUrl = imageUrl;
    }

    protected ImagesVM(Parcel in) {
        imageDefault = in.readInt();
        imageUrl = in.readString();
        isSelected = in.readByte() != 0;
    }

    public int getImageDefault() {
        return imageDefault;
    }

    public void setImageDefault(int imageDefault) {
        this.imageDefault = imageDefault;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


}

package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetSinglePictureVM extends WidgetViewModel {

    private int iconDefault;

    private String imageUrl;

    public WidgetSinglePictureVM(String imageUrl, int iconDefault) {
        super(WidgetViewModel.VIEW_TYPE_SINGLE_PICTURE);
        this.imageUrl = imageUrl;
        this.iconDefault = iconDefault;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getIconDefault() {
        return iconDefault;
    }

    public void setIconDefault(int iconDefault) {
        this.iconDefault = iconDefault;
    }

}

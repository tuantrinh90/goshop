package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/11.
 */

public class PdpBannerVM extends ProductDetailModel {

    private String imageUrl;
    public PdpBannerVM() {
        super(ProductDetailModel.DETAIL_TOP_BANNER);
    }

    public PdpBannerVM(String imageUrl) {
        super(ProductDetailModel.DETAIL_TOP_BANNER);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

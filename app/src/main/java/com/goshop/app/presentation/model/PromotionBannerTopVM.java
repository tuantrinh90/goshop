package com.goshop.app.presentation.model;

public class PromotionBannerTopVM extends PromotionBannerModel {

    private int bannerDefault;

    private String bannerUrl;

    public PromotionBannerTopVM(String bannerUrl, int bannerDefault) {
        super(PromotionBannerModel.VIEW_TOP_BANNER);
        this.bannerUrl = bannerUrl;
        this.bannerDefault = bannerDefault;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public int getBannerDefault() {
        return bannerDefault;
    }

    public void setBannerDefault(int bannerDefault) {
        this.bannerDefault = bannerDefault;
    }
}

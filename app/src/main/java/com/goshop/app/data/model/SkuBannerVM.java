package com.goshop.app.data.model;

public class SkuBannerVM extends PromotionSkuModel {

    private int bannerDefault;

    private String bannerUrl;

    public SkuBannerVM(String bannerUrl, int bannerDefault) {
        super(PromotionSkuModel.TYPE_BANNER);
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

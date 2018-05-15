package com.goshop.app.presentation.model;

public class TrendingSingleBannerVM extends TrendingNowModel {

    private BannerImageVM bannerImageVM;

    public TrendingSingleBannerVM(BannerImageVM bannerImageVM) {
        super(TrendingNowModel.VIEW_TYPE_SINGLE_BANNER);
        this.bannerImageVM = bannerImageVM;
    }

    public BannerImageVM getBannerImageVM() {
        return bannerImageVM;
    }

    public void setBannerImageVM(BannerImageVM bannerImageVM) {
        this.bannerImageVM = bannerImageVM;
    }
}

package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.BannerData;

import java.util.ArrayList;

public class BannerResponse {

    private ArrayList<BannerData> banners;

    public ArrayList<BannerData> getBanners() {
        return banners;
    }

    public void setBanners(ArrayList<BannerData> banners) {
        this.banners = banners;
    }
}

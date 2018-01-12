package com.goshop.app.presentation.model;

import java.util.List;

/**
 * Created by helen on 2018/1/11.
 */

public class PdpBannerVM extends ProductDetailModel {

    private List<String> urls;

    public PdpBannerVM() {
        super(ProductDetailModel.DETAIL_TOP_BANNER);
    }

    public PdpBannerVM(List<String> urls) {
        super(ProductDetailModel.DETAIL_TOP_BANNER);
        this.urls = urls;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}

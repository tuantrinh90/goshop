package com.goshop.app.presentation.model;

import java.util.List;

/**
 * Created by helen on 2018/2/5.
 */

public class WidgetBannerVM extends WidgetViewModel {
    private List<String> urls;

    public WidgetBannerVM(List<String> urls) {
        super(WidgetViewModel.VIEW_TYPE_BANNER);
        this.urls = urls;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}

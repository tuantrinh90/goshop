package com.goshop.app.presentation.model;

import java.util.List;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetHorizontalVM extends WidgetViewModel {

    private List<WidgetGridDetailVM> detailVMS;

    private String title;

    public WidgetHorizontalVM(String title,
        List<WidgetGridDetailVM> detailVMS) {
        super(WidgetViewModel.VIEW_TYPE_HORIZONTAL);
        this.title = title;
        this.detailVMS = detailVMS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<WidgetGridDetailVM> getDetailVMS() {
        return detailVMS;
    }

    public void setDetailVMS(List<WidgetGridDetailVM> detailVMS) {
        this.detailVMS = detailVMS;
    }
}

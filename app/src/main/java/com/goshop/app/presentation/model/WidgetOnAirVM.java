package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetOnAirVM extends WidgetViewModel {

    private String detailImageUrl;

    private String detailNow;

    private String detailOld;

    private String detailPercent;

    private String detailTitle;

    private String videoUrl;

    public WidgetOnAirVM(String videoUrl, String detailImageUrl,
        String detailTitle, String detailOld, String detailNow, String detailPercent) {
        super(WidgetViewModel.VIEW_TYPE_ON_AIR);
        this.videoUrl = videoUrl;
        this.detailImageUrl = detailImageUrl;
        this.detailTitle = detailTitle;
        this.detailOld = detailOld;
        this.detailNow = detailNow;
        this.detailPercent = detailPercent;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDetailImageUrl() {
        return detailImageUrl;
    }

    public void setDetailImageUrl(String detailImageUrl) {
        this.detailImageUrl = detailImageUrl;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailOld() {
        return detailOld;
    }

    public void setDetailOld(String detailOld) {
        this.detailOld = detailOld;
    }

    public String getDetailNow() {
        return detailNow;
    }

    public void setDetailNow(String detailNow) {
        this.detailNow = detailNow;
    }

    public String getDetailPercent() {
        return detailPercent;
    }

    public void setDetailPercent(String detailPercent) {
        this.detailPercent = detailPercent;
    }
}

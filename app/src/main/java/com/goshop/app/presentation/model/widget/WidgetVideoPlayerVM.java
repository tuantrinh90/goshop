package com.goshop.app.presentation.model.widget;

import java.util.List;

public class WidgetVideoPlayerVM extends WidgetViewModel {

    private String autoChannel;

    private String autoEnabled;

    private String detailLink;

    private String detailTitle;

    private String pageTitle;

    private String title;

    private List<VideoPlayerItemsVM> videoPlayerItemsVMS;

    public WidgetVideoPlayerVM(String title, String detailTitle,
        List<VideoPlayerItemsVM> videoPlayerItemsVMS) {
        super(WidgetViewModel.VIEW_TYPE_VIDEOPLAYER);
        this.title = title;
        this.detailTitle = detailTitle;
        this.videoPlayerItemsVMS = videoPlayerItemsVMS;
    }

    public String getAutoChannel() {
        return autoChannel;
    }

    public void setAutoChannel(String autoChannel) {
        this.autoChannel = autoChannel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getAutoEnabled() {
        return autoEnabled;
    }

    public void setAutoEnabled(String autoEnabled) {
        this.autoEnabled = autoEnabled;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    public List<VideoPlayerItemsVM> getVideoPlayerItemsVMS() {
        return videoPlayerItemsVMS;
    }

    public void setVideoPlayerItemsVMS(
        List<VideoPlayerItemsVM> videoPlayerItemsVMS) {
        this.videoPlayerItemsVMS = videoPlayerItemsVMS;
    }
}

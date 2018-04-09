package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;

import java.util.List;

public class TrendingVideoVM extends TrendingNowModel {

    private String detailTitle;

    private String title;

    private List<VideoPlayerItemsVM> videoPlayerItemsVMS;

    public TrendingVideoVM(String title, String detailTitle,
        List<VideoPlayerItemsVM> videoPlayerItemsVMS) {
        super(TrendingNowModel.VIEW_TYPE_VIDEOPLAYER);
        this.detailTitle = detailTitle;
        this.title = title;
        this.videoPlayerItemsVMS = videoPlayerItemsVMS;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<VideoPlayerItemsVM> getVideoPlayerItemsVMS() {
        return videoPlayerItemsVMS;
    }

    public void setVideoPlayerItemsVMS(
        List<VideoPlayerItemsVM> videoPlayerItemsVMS) {
        this.videoPlayerItemsVMS = videoPlayerItemsVMS;
    }
}

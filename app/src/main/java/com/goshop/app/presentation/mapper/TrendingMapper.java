package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.OnAirScheduleResponse;
import com.goshop.app.data.model.response.VideoItemsResponse;
import com.goshop.app.data.model.response.VideoProductsResponse;
import com.goshop.app.data.model.response.common.BannerData;
import com.goshop.app.data.model.response.BannerResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.BannerVm;
import com.goshop.app.presentation.model.TrendingVideoVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.VideoProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;

import java.util.ArrayList;
import java.util.List;

public class TrendingMapper {

    public static List<BannerVm> transformBanner(Response<BannerResponse> response) {
        List<BannerVm> bannerVmList = new ArrayList<>();
        if (response != null && response.getData() != null && response.getData().getBanners()
            .size() > 0) {
            for (BannerData banner : response.getData().getBanners()) {
                BannerVm bannerVm = new BannerVm();
                bannerVm.setId(banner.getId());
                bannerVm.setImage(banner.getImage());
                bannerVm.setLink(banner.getLink());
                bannerVm.setType(banner.getType());
                bannerVmList.add(bannerVm);
            }
        }
        return bannerVmList;
    }

    public static List<VideoPlayerItemsVM> transformOnAirSchedule(
        Response<OnAirScheduleResponse> response) {
        List<VideoPlayerItemsVM> videoPlayerItemsVMS = new ArrayList<>();
        if (response != null && response.getData() != null && response.getData()
            .getChannel() != null && response.getData().getChannel().size() > 0) {
            for (VideoItemsResponse videoItemsResponse : response.getData().getChannel()) {
                VideoPlayerItemsVM videoPlayerItemsVM = new VideoPlayerItemsVM();
                videoPlayerItemsVM.setId(videoItemsResponse.getId());
                videoPlayerItemsVM.setName(videoItemsResponse.getName());
                videoPlayerItemsVM.setPlaybackUrl(videoItemsResponse.getPlaybackUrl());
                if (videoItemsResponse.getProducts() != null && videoItemsResponse.getProducts()
                    .size() > 0) {
                    List<VideoProductsVM> videoProductsVMs = new ArrayList<>();
                    for (VideoProductsResponse videoProductsResponse : videoItemsResponse
                        .getProducts()) {
                        VideoProductsVM videoProductsVM = new VideoProductsVM();
                        videoProductsVM.setImage(videoProductsResponse.getImage());
                        videoProductsVM.setLabels(videoProductsResponse.getLabels());
                        videoProductsVM.setLink(videoProductsResponse.getLink());
                        videoProductsVM.setName(videoProductsResponse.getName());
                        videoProductsVM.getPriceVM().getRm().setDiscounted(
                            videoProductsResponse.getPrice().getRM().getDiscounted());
                        videoProductsVM.getPriceVM().getRm().setDiscountTitle(
                            videoProductsResponse.getPrice().getRM().getDiscountTitle());
                        videoProductsVM.getPriceVM().getRm()
                            .setOriginal(videoProductsResponse.getPrice().getRM().getOriginal());
                        videoProductsVM.setSku(videoProductsResponse.getSku());
                        videoProductsVMs.add(videoProductsVM);
                    }
                    videoPlayerItemsVM.setProductsVMS(videoProductsVMs);
                }
                videoPlayerItemsVMS.add(videoPlayerItemsVM);
            }
        }
        return videoPlayerItemsVMS;
    }

}

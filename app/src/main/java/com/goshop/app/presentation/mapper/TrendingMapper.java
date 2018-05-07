package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.OnAirScheduleResponse;
import com.goshop.app.data.model.response.VideoItemsResponse;
import com.goshop.app.data.model.response.VideoProductsResponse;
import com.goshop.app.data.model.response.common.BannerData;
import com.goshop.app.data.model.response.BannerResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.BannerVm;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;

import java.util.ArrayList;
import java.util.List;

public class TrendingMapper {

    public static final String VIDEO_URL = "http://playback01.aotg-video.astro.com" +
        ".my/AOTGHLS/master_AGSS.m3u8";

    public static List<BannerVm> transformBanner(Response<BannerResponse> response) {
        List<BannerVm> bannerVmList = new ArrayList<>();
        if (response != null && response.getData() != null && !response.getData().getBanners()
            .isEmpty()) {
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
            .getChannel() != null && !response.getData().getChannel().isEmpty()) {
            for (int i = 0; i < response.getData().getChannel().size(); i++) {
                VideoItemsResponse videoItemsResponse = response.getData().getChannel().get(i);
                VideoPlayerItemsVM videoPlayerItemsVM = new VideoPlayerItemsVM();
                videoPlayerItemsVM.setId(videoItemsResponse.getId());
                videoPlayerItemsVM.setName(videoItemsResponse.getName());
                // TODO: 2018/4/26 mock video url
                videoPlayerItemsVM.setPlaybackUrl(VIDEO_URL);
//                videoPlayerItemsVM.setPlaybackUrl(videoItemsResponse.getPlaybackUrl());
                if (videoItemsResponse.getProducts() != null && !videoItemsResponse.getProducts()
                    .isEmpty()) {
                    List<ProductsVM> videoProductsVMs = new ArrayList<>();
                    for (VideoProductsResponse videoProductsResponse : videoItemsResponse
                        .getProducts()) {
                        ProductsVM videoProductsVM = new ProductsVM();
                        videoProductsVM.setImage(videoProductsResponse.getImage());
                        videoProductsVM.setLabels(videoProductsResponse.getLabels());
                        videoProductsVM.setLink(videoProductsResponse.getLink());
                        videoProductsVM.setName(videoProductsResponse.getName());
                        if (videoProductsResponse.getPrice() != null && videoProductsResponse
                            .getPrice().getRM() != null) {
                            ProductPriceRMVM productPriceRMVM = new ProductPriceRMVM();
                            productPriceRMVM.setOriginal(
                                videoProductsResponse.getPrice().getRM().getOriginal());
                            productPriceRMVM.setDiscountTitle(
                                videoProductsResponse.getPrice().getRM().getDiscountTitle());
                            productPriceRMVM.setDiscounted(
                                videoProductsResponse.getPrice().getRM().getDiscounted());
                            ProductPriceVM productPriceVM = new ProductPriceVM(productPriceRMVM);
                            videoProductsVM.setPriceVM(productPriceVM);
                        }
                        videoProductsVM.setSku(videoProductsResponse.getSku());
                        videoProductsVMs.add(videoProductsVM);
                    }
                    videoPlayerItemsVM.setProductsVMS(videoProductsVMs);
                }
                videoPlayerItemsVMS.add(videoPlayerItemsVM);
            }
            for (VideoItemsResponse videoItemsResponse : response.getData().getChannel()) {

            }
        }
        return videoPlayerItemsVMS;
    }

}

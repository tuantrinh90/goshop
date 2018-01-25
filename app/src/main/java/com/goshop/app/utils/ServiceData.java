package com.goshop.app.utils;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by img on 2018/1/5.
 */

public class ServiceData {

    static String productName = GoShopApplication.getAppContext().getResources()
        .getString(R.string.home_item_test_product_name);

    static String productPrice = GoShopApplication.getAppContext().getResources()
        .getString(R.string.home_item_test_product_price);

    /**
     * TODO this is temp code
     */
    public static Observable<HomeResponse> getBaseData() {
        HomeResponse topBannerData = getTopBannerData();
        HomeResponse contentVideoData = getContentVideoData(topBannerData);
        HomeResponse bottomSlidedata = getBottomSlidedata(contentVideoData);
        return Observable.just(bottomSlidedata);
    }

    /**
     * TODO this is temp code
     * @return
     */
    public static HomeResponse getTopBannerData() {
        HomeResponse homeResponse=new HomeResponse();
        List<HomeResponse.TopBanner> topBanners = new ArrayList<>();
        //top banner
        List<String> imgs = Arrays.asList(Const.HOME_TEST_IMG1,
            Const.HOME_TEST_IMG2,
            Const.HOME_TEST_IMG3);
        HomeResponse.TopBanner topbanner1 = new HomeResponse.TopBanner();
        topbanner1.setImg(Const.HOME_TEST_IMG1);
        topbanner1.setType(Const.PROMOTION_PAGE_PDP);
        topBanners.add(topbanner1);

        HomeResponse.TopBanner topbanner2 = new HomeResponse.TopBanner();
        topbanner2.setImg(Const.HOME_TEST_IMG2);
        topbanner2.setType(Const.PROMOTION_PAGE_LIST);
        topBanners.add(topbanner2);

        HomeResponse.TopBanner topbanner3 = new HomeResponse.TopBanner();
        topbanner3.setImg(Const.HOME_TEST_IMG3);
        topbanner3.setType(Const.PROMOTION_PAGE_BANNER);
        topBanners.add(topbanner3);

        homeResponse.setTopBanner(topBanners);
        return homeResponse;
    }

    /**
     * TODO this is temp code
     * @return
     */
    public static HomeResponse getContentVideoData(HomeResponse homeResponse) {
        List<HomeResponse.CenterVideo> centerVideos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            HomeResponse.CenterVideo centerVideo = new HomeResponse.CenterVideo();
            HomeResponse.CenterVideo.CenterVideoMsg centerVideoMsg = new HomeResponse.CenterVideo
                .CenterVideoMsg();
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_VIDEO);
            centerVideoMsg.setVideoMsg("i'm " + i + " page");
            centerVideo.setPosition(i);
            centerVideo.setCenterVideoMsg(centerVideoMsg);
            List<HomeResponse.CenterVideo.CenterVideoList> centerVideoLists = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                HomeResponse.CenterVideo.CenterVideoList centerVideoList = new HomeResponse
                    .CenterVideo.CenterVideoList();
                centerVideoList.setImgUrl(Const.HOME_TEST_IMG1);
                centerVideoList.setProductName(productName + j);
                centerVideoList.setProductPrice(productPrice);
                centerVideo.setItemType(1);
                centerVideoLists.add(centerVideoList);
            }
            centerVideo.setCenterVideoList(centerVideoLists);

            HomeResponse.CenterVideo.PrevAndNext prevAndNext = new HomeResponse.CenterVideo
                .PrevAndNext();
            prevAndNext.setImgUrls(Const.HOME_TEST_IMG1);
            prevAndNext.setProductName(productName + i);
            prevAndNext.setProductPrice(productPrice);
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_PREV_NEXT);
            centerVideo.setPrevAndNext(prevAndNext);
            centerVideos.add(centerVideo);
        }
        homeResponse.setCenterVideo(centerVideos);
        return homeResponse;
    }

    /**
     * TODO this is temp code
     * @return
     */
    public static HomeResponse getBottomSlidedata(HomeResponse homeResponse) {
        List<HomeResponse.BottomSlide> bottomSlides = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String headImageUrl = Const.HOME_TEST_IMG3;
            HomeResponse.BottomSlide bottomSlideHeader = new HomeResponse.BottomSlide();
            bottomSlideHeader.setHeadImageUrl(headImageUrl);
            bottomSlideHeader.setViewType(Const.HOME_BOTTOM_SLIDE_HEADER_IMG);
            bottomSlides.add(bottomSlideHeader);
            HomeResponse.BottomSlide bottomSlideTitle = new HomeResponse.BottomSlide();
            bottomSlideTitle.setViewType(Const.HOME_BOTTOM_SLIDE_TITLE);
            bottomSlideTitle.setSlideTitle(GoShopApplication.getAppContext().getResources()
                .getString(R.string.home_bottom_slide_title));
            bottomSlides.add(bottomSlideTitle);
            HomeResponse.BottomSlide bottomSlideItem = new HomeResponse.BottomSlide();
            List<HomeResponse.BottomSlide.BottomSlideChild> bottomSlideChildren = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                HomeResponse.BottomSlide.BottomSlideChild bottomSlideBody = new HomeResponse
                    .BottomSlide.BottomSlideChild();
                bottomSlideBody.setProductName(productName);
                bottomSlideBody.setProductPrice(productPrice);
                bottomSlideBody.setImageUrl(Const.HOME_TEST_IMG2);
                bottomSlideChildren.add(bottomSlideBody);
            }
            bottomSlideItem.setViewType(Const.HOME_BOTTOM_SLIDE_BODY);
            bottomSlideItem.setBottomSlideChildren(bottomSlideChildren);
            bottomSlides.add(bottomSlideItem);
        }
        homeResponse.setBottomSlide(bottomSlides);
        return homeResponse;
    }

    /**
     * TODO this is temp code
     */
    public static Observable<PromotionListResponse> getPromotionListData() {
        PromotionListResponse promotionLandingResponses = new PromotionListResponse();
        List<PromotionListResponse.PromotionItem> promotionItems = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            PromotionListResponse.PromotionItem response = new PromotionListResponse
                .PromotionItem();
            response.setImageUrl(Const.HOME_TEST_IMG3);
            response.setProductCurrentPrice("RM 120.00");
            response.setProductName(
                "new balabce new balabce new balabce new balabce new balabce new balabce");
            response.setProductOldPrice("RM 180.00");
            response.setProductOff("30% OFF");
            if (i % 2 == 0) {
                response.setBest(true);
                response.setGiftShow(false);
                response.setNew(true);
                response.setTvShow(false);
            } else {
                response.setBest(false);
                response.setGiftShow(true);
                response.setNew(false);
                response.setTvShow(true);
            }
            promotionItems.add(response);
        }
        promotionLandingResponses.setPromotionItems(promotionItems);
        promotionLandingResponses
            .setTitle(GoShopApplication.getAppContext().getString(R.string.promotion_list_symbol));
        promotionLandingResponses.setBannerUrl(Const.BANNER_IMG1);
        return Observable.just(promotionLandingResponses);
    }

    public static Observable<PromotionBannerResponse> getPromotionBannerLists() {
        PromotionBannerResponse promotionBannerResponse = new PromotionBannerResponse();
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add(Const.BANNER_IMG1);
        imageUrls.add(Const.BANNER_IMG2);
        imageUrls.add(Const.BANNER_IMG3);
        imageUrls.add(Const.BANNER_IMG4);
        promotionBannerResponse.setImageUrl(imageUrls);
        return Observable.just(promotionBannerResponse);
    }


}

package com.goshop.app.utils;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.MultipleItem;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;

import java.util.ArrayList;
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
    public static List<MultipleItem> getBaseData() {
        List<MultipleItem> list = new ArrayList<>();
        list.addAll(getTopBannerData());
        list.add(new MultipleItem(Const.HOME_TOP_CATEGORY, ""));
        list.addAll(getContentVideoData());
        list.addAll(getBottomSlidedata());
        return list;
    }

    /**
     * TODO this is temp code
     */
    public static List<MultipleItem> getTopBannerData() {
        List<MultipleItem> list = new ArrayList<>();
        //top banner
        MultipleItem multipleItemTopBanner = new MultipleItem(Const.HOME_TOP_BANNER, "");

        List<MultipleItem.TopBanner> topBanner = new ArrayList<>();

        MultipleItem.TopBanner topbanner1 = new MultipleItem.TopBanner();
        topbanner1.setImg(Const.HOME_TEST_IMG1);
        topbanner1.setType(Const.PROMOTION_PAGE_PDP);
        topBanner.add(topbanner1);
        MultipleItem.TopBanner topbanner2 = new MultipleItem.TopBanner();
        topbanner2.setImg(Const.HOME_TEST_IMG2);
        topbanner2.setType(Const.PROMOTION_PAGE_LIST);
        topBanner.add(topbanner2);
        MultipleItem.TopBanner topbanner3 = new MultipleItem.TopBanner();
        topbanner3.setImg(Const.HOME_TEST_IMG3);
        topbanner3.setType(Const.PROMOTION_PAGE_BANNER);
        topBanner.add(topbanner3);
        multipleItemTopBanner.setTopBanner(topBanner);
        list.add(multipleItemTopBanner);

        return list;
    }

    /**
     * TODO this is temp code
     */
    public static List<MultipleItem> getContentVideoData() {
        List<MultipleItem> list = new ArrayList<>();
        List<MultipleItem.CenterVideo> centerVideos = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            MultipleItem.CenterVideo centerVideo = new MultipleItem.CenterVideo();
            MultipleItem.CenterVideo.CenterVideoMsg centerVideoMsg = new MultipleItem.CenterVideo
                .CenterVideoMsg();
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_VIDEO);
            centerVideoMsg.setVideoMsg("i'm " + i + " page");
            centerVideo.setPosition(i);
            centerVideo.setCenterVideoMsg(centerVideoMsg);
            List<MultipleItem.CenterVideo.CenterVideoList> centerVideoLists = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                MultipleItem.CenterVideo.CenterVideoList centerVideoList = new MultipleItem
                    .CenterVideo.CenterVideoList();
                centerVideoList.setImgUrl(Const.HOME_TEST_IMG1);
                centerVideoList.setProductName(productName + j);
                centerVideoList.setProductPrice(productPrice);
                centerVideo.setItemType(1);
                centerVideoLists.add(centerVideoList);
            }
            centerVideo.setCenterVideoList(centerVideoLists);

            MultipleItem.CenterVideo.PrevAndNext prevAndNext = new MultipleItem.CenterVideo
                .PrevAndNext();
            prevAndNext.setImgUrls(Const.HOME_TEST_IMG1);
            prevAndNext.setProductName(productName + i);
            prevAndNext.setProductPrice(productPrice);
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_PREV_NEXT);
            centerVideo.setPrevAndNext(prevAndNext);
            centerVideos.add(centerVideo);
        }

        MultipleItem multipleItemTopBanner = new MultipleItem(Const.HOME_CENTER_VIDEO, "");
        multipleItemTopBanner.setCenterVideo(centerVideos);
        list.add(multipleItemTopBanner);
        return list;
    }

    /**
     * TODO this is temp code
     */
    public static List<MultipleItem> getBottomSlidedata() {
        List<MultipleItem> multipleItems = new ArrayList<>();
        MultipleItem bottomSldieItem = new MultipleItem(Const.HOME_CENTER_VIDEO, "");
        List<MultipleItem.BottomSlide> bottomSlides = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String headImageUrl = Const.HOME_TEST_IMG3;
            MultipleItem.BottomSlide bottomSlideHeader = new MultipleItem.BottomSlide();
            bottomSlideHeader.setHeadImageUrl(headImageUrl);
            bottomSlideHeader.setViewType(Const.HOME_BOTTOM_SLIDE_HEADER_IMG);
            bottomSlides.add(bottomSlideHeader);
            MultipleItem.BottomSlide bottomSlideTitle = new MultipleItem.BottomSlide();
            bottomSlideTitle.setViewType(Const.HOME_BOTTOM_SLIDE_TITLE);
            bottomSlideTitle.setSlideTitle(GoShopApplication.getAppContext().getResources()
                .getString(R.string.home_bottom_slide_title));
            bottomSlides.add(bottomSlideTitle);
            MultipleItem.BottomSlide bottomSlideItem = new MultipleItem.BottomSlide();
            List<MultipleItem.BottomSlide.BottomSlideChild> bottomSlideChildren = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                MultipleItem.BottomSlide.BottomSlideChild bottomSlideBody = new MultipleItem
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
        bottomSldieItem.setBottomSlide(bottomSlides);
        multipleItems.add(bottomSldieItem);
        return multipleItems;
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

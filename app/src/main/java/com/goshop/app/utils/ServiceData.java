package com.goshop.app.utils;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.response.HomeResponse;

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
     * @return
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
        //top banner
        List<String> imgs = Arrays.asList(Const.HOME_TEST_IMG1,
            Const.HOME_TEST_IMG2,
            Const.HOME_TEST_IMG3);
        HomeResponse.TopBanner topbanner = new HomeResponse.TopBanner(imgs);
        homeResponse.setTopBanner(topbanner);
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
            bottomSlideHeader.setViewType(Const.BOTTOM_SLIDE_HEADER_IMG);
            bottomSlides.add(bottomSlideHeader);
            HomeResponse.BottomSlide bottomSlideTitle = new HomeResponse.BottomSlide();
            bottomSlideTitle.setViewType(Const.BOTTOM_SLIDE_TITLE);
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
            bottomSlideItem.setViewType(Const.BOTTOM_SLIDE_BODY);
            bottomSlideItem.setBottomSlideChildren(bottomSlideChildren);
            bottomSlides.add(bottomSlideItem);
        }
        homeResponse.setBottomSlide(bottomSlides);
        return homeResponse;
    }


}

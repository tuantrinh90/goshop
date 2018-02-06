package com.goshop.app.utils;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
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
     */
    public static HomeResponse getTopBannerData() {
        HomeResponse homeResponse = new HomeResponse();
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
            for (int j = 0; j < 4; j++) {
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

    /**
     * TODO this is temp mock code
     */
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

    /**
     * TODO this is temp mock code
     */
    public static Observable<MyOrderListResponse> getMyOrderLists() {
        MyOrderListResponse myOrderListResponse = new MyOrderListResponse();
        List<MyOrderListResponse.ResultsBean> results = new ArrayList<>();

        for (int k = 0; k < 5; k++) {
            MyOrderListResponse.ResultsBean titleBean = new MyOrderListResponse.ResultsBean();
            titleBean.setDate("21 Mar 2017");
            titleBean.setOrderId(String.valueOf(44814 + k));
            titleBean.setOrderSn(String.valueOf(910312525 + k));
            titleBean.setTotal("245.00");
            titleBean.setStatus("pending");
            titleBean.setType(Const.MYORDER_LIST_TITLE);
            results.add(titleBean);

            for (int i = 0; i < 3; i++) {
                MyOrderListResponse.ResultsBean bodyBean = new MyOrderListResponse.ResultsBean();
                bodyBean.setProductId(String.valueOf(145071 + i));
                bodyBean.setItemId(String.valueOf(467363 + i));
                bodyBean.setName("PS4 DUALSHOCK®4 Wireless Controller (Wave Blue)");
                bodyBean.setBrand("PlayStation");
                bodyBean.setBrandId(String.valueOf(4813 + i));
                bodyBean.setCategory("Others");
                bodyBean.setQty(1 + i);
                bodyBean.setPrice("208.00");
                bodyBean.setImage(Const.BANNER_IMG1);
                bodyBean.setId(String.valueOf(910312525 + i));
                bodyBean.setStatus("Shipped");
                bodyBean.setType(Const.MYORDER_LIST_CONTENT);
                results.add(bodyBean);
            }

            MyOrderListResponse.ResultsBean bottomPriceBean = new MyOrderListResponse.ResultsBean();
            bottomPriceBean.setTotal("245.00");
            bottomPriceBean.setType(Const.MYORDER_LIST_PRICE);
            results.add(bottomPriceBean);
        }

        myOrderListResponse.setResults(results);
        myOrderListResponse.setStatus(1);
        myOrderListResponse.setTotal(results.size());
        return Observable.just(myOrderListResponse);
    }

    /**
     * TODO this is temp mock code
     */
    public static Observable<MyOrderDetailReponse> getMyOrderDetail() {
        MyOrderDetailReponse myOrderDetailReponse = new MyOrderDetailReponse();
        myOrderDetailReponse.setOrderId("44752");
        myOrderDetailReponse.setDate("11 Jan 2018");
        myOrderDetailReponse.setState("processing");
        myOrderDetailReponse.setStatus(1);
        myOrderDetailReponse.setCustomerName("Test Test");
        myOrderDetailReponse.setPaymentMethod("PayPal Express Checkout");
        myOrderDetailReponse.setSubtotal("RM 1,461.00");
        myOrderDetailReponse.setShippingFee("RM 0.00");
        myOrderDetailReponse.setGrandTotal("RM 1,461.00");

        MyOrderDetailReponse.ShippingAddressBean shippingAddressBean = new MyOrderDetailReponse
            .ShippingAddressBean();
        shippingAddressBean.setFirstname("Test Name");
        shippingAddressBean.setCountry("China");
        shippingAddressBean.setRegion("Discovery Bay & Tung Chung");
        shippingAddressBean.setCity("Hong kong");
        shippingAddressBean.setPostcode("123");
        shippingAddressBean.setTelephone("+123456789");
        myOrderDetailReponse.setShippingAddress(shippingAddressBean);

        ArrayList<MyOrderDetailReponse.SubordersBean> subordersBeans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            MyOrderDetailReponse.SubordersBean subordersBean = new MyOrderDetailReponse
                .SubordersBean();
            subordersBean.setProductId(String.valueOf(467363123 + i));
            if (i % 2 == 0) {
                subordersBean.setStatus("Shipped");
            } else {
                subordersBean.setStatus("Processing");
            }
            subordersBean.setName("PS4 DUALSHOCK®4 Wireless Controller (Wave Blue)");
            subordersBean.setImage(Const.HOME_TEST_IMG2);
            subordersBeans.add(subordersBean);
        }
        myOrderDetailReponse.setSuborders(subordersBeans);
        return Observable.just(myOrderDetailReponse);

    }

    public static Observable<CheckoutResponse> getCheckout(){
        CheckoutResponse response=new CheckoutResponse();
        response.setCity("Taibei");
        response.setUserName("test1");
        response.setFirstAddress("new Land");
        response.setSecondAddress("new Land2");
        response.setPostcode("0000");
        response.setCountry("China");
        response.setTel("+1234567");
        List<CheckoutResponse.CheckoutItem> checkoutItems=new ArrayList<>();
        for (int i=0;i<5;i++){
            CheckoutResponse.CheckoutItem checkoutItem=new CheckoutResponse.CheckoutItem();
            checkoutItem.setProductName(ScreenHelper.getString(R.string.home_item_test_product_name));
            checkoutItem.setAmount(String.valueOf(i));
            checkoutItem.setColor("Blue");
            checkoutItem.setCurrentPrice("RM 119.00");
            checkoutItem.setOldPrice("RM 269.00");
            checkoutItem.setImage(Const.BANNER_IMG4);
            checkoutItems.add(checkoutItem);
        }
        response.setCheckoutItems(checkoutItems);
        return Observable.just(response);
    }

    public static Observable<NotificationsResponse> getNotification(){
        NotificationsResponse response=new NotificationsResponse();
        List<NotificationsResponse.NotificationBean> notificationBeanList=new ArrayList<>();
        for (int i=0;i<10;i++){
            NotificationsResponse.NotificationBean notificationBean=new NotificationsResponse
                .NotificationBean();
            notificationBean.setNotifyName("lorem ipsum dolor sit amet,consectetur adipiscing edit. Nulla quam velit.");
            notificationBean.setHour("12:00");
            notificationBean.setNew(i%2==0);
            notificationBean.setDate("1/2/18");
            notificationBeanList.add(notificationBean);
        }
        response.setNotificationBean(notificationBeanList);
        return Observable.just(response);
    }

}

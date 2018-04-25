package com.goshop.app.utils;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class ServiceData {

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
    public static Observable<CheckoutResponse> getCheckout() {
        CheckoutResponse response = new CheckoutResponse();
        response.setCity("City, State");
        response.setUserName("User Name test");
        response.setFirstAddress("Address 1");
        response.setSecondAddress("Address 2");
        response.setPostcode("1000");
        response.setCountry("China");
        response.setTel("T:+1234567890");
        List<CheckoutResponse.CheckoutItem> checkoutItems = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            CheckoutResponse.CheckoutItem checkoutItem = new CheckoutResponse.CheckoutItem();
            checkoutItem
                .setProductName(ScreenHelper.getString(R.string.home_item_test_product_name));
            checkoutItem.setAmount("x " + String.valueOf(i+1));
            checkoutItem.setColor("Blue");
            checkoutItem.setCurrentPrice("RM 119.00");
            checkoutItem.setOldPrice("RM 269.00");
            checkoutItem.setImage("");
            checkoutItems.add(checkoutItem);
        }
        response.setCheckoutItems(checkoutItems);
        return Observable.just(response);
    }

    /**
     * TODO this is temp mock code
     */
    public static Observable<NotificationsResponse> getNotification() {
        NotificationsResponse response = new NotificationsResponse();
        List<NotificationsResponse.NotificationBean> notificationBeanList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NotificationsResponse.NotificationBean notificationBean = new NotificationsResponse
                .NotificationBean();
            notificationBean.setNotifyName(
                "lorem ipsum dolor sit amet,consectetur adipiscing edit. Nulla quam velit.");
            notificationBean.setHour("12:00");
            notificationBean.setNew(i % 2 == 0);
            notificationBean.setDate("1/2/18");
            notificationBeanList.add(notificationBean);
        }
        response.setNotificationBean(notificationBeanList);
        return Observable.just(response);
    }

}

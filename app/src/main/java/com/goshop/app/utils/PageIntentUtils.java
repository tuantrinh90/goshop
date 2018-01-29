package com.goshop.app.utils;

import com.goshop.app.Const;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.presentation.home.PromotionBannerActivity;
import com.goshop.app.presentation.home.PromotionLandingListActivity;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

/**
 * Created by img on 2018/1/22.
 */

public class PageIntentUtils {

    public static final String PROMOTION_BANNER_URL = "PROMOTION_BANNER_URL";

    public static void skipBannerPromotion(Context context, Serializable serializable) {
        //Home TopBanner click
        if (serializable instanceof HomeResponse.TopBanner) {
            HomeResponse.TopBanner topBanner = (HomeResponse.TopBanner) serializable;
            switch (topBanner.getType()) {
                case Const.PROMOTION_PAGE_PDP:
                    break;
                case Const.PROMOTION_PAGE_BANNER:
                    Intent bannerIntent = new Intent();
                    bannerIntent.setClass(context, PromotionBannerActivity.class);
                    bannerIntent.putExtra(PROMOTION_BANNER_URL, topBanner.getImg());
                    context.startActivity(bannerIntent);
                    break;
                case Const.PROMOTION_PAGE_LIST:
                    Intent listIntent = new Intent();
                    listIntent.setClass(context, PromotionLandingListActivity.class);
                    listIntent.putExtra(PROMOTION_BANNER_URL, topBanner.getImg());
                    context.startActivity(listIntent);
                    break;
            }
            //Home Bottom head img click
        } else if (serializable instanceof HomeResponse.BottomSlide) {
            HomeResponse.BottomSlide bottomSlide = (HomeResponse.BottomSlide) serializable;
            Intent bottomSlideIntent = new Intent();
            bottomSlideIntent.setClass(context, PromotionBannerActivity.class);
            bottomSlideIntent.putExtra(PROMOTION_BANNER_URL, bottomSlide.getHeadImageUrl());
            context.startActivity(bottomSlideIntent);
        }
    }
}

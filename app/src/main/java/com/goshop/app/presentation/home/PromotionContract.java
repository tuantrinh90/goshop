package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;

import java.util.Map;

public interface PromotionContract {

    interface View extends BaseView {

        void showPromotionList(PromotionListResponse response);

        void showPromotionBanner(PromotionBannerResponse response);

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);
    }

    interface Presenter extends BasePresenter<PromotionContract.View> {

        void getPromotionList(Map<String, Object> params);

        void getPromotionBanner(Map<String, Object> params);
    }
}

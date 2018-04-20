package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.model.MyEGiftModel;

import java.util.List;

public class MyEGiftCardContract {

    interface View extends BaseView {

        void getEGiftCardSuccess(List<MyEGiftModel> eGiftModels, PaginationData pagination);

        void activeSuccess(List<MyEGiftModel> transform, PaginationData pagination);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String errorMessage);

    }

    public interface Presenter extends BasePresenter<View> {

        void eGiftCardsRequest(String uniqueCode, int page);

        void getEGiftCardDetails(int page, boolean isShowLoading);
    }

}

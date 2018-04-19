package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.MyEGiftModel;

import java.util.List;

public class MyEGiftCardContract {

    interface View extends BaseView {

        void getEGiftCardSuccess(List<MyEGiftModel> eGiftModels);

        void getEGiftCardFailed(String errorMessage);

        void activeSuccess();

        void activeFailed(String errorMessage);

    }

    public interface Presenter extends BasePresenter<View> {

        void eGiftCardsRequest(String uniqueCode);

        void getEGiftCardDetails();
    }

}

package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.MyEGiftModel;

import java.util.List;
import java.util.Map;

public class MyEGiftCardContract {

    interface View extends BaseView {

        void showGiftCardsResult(List<MyEGiftModel> eGiftModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void eGiftCardsRequest(Map<String, Object> params);
    }

}

package com.goshop.app.presentation.login;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

public interface RegisterContract {

    interface View extends BaseView {

        void registerSuccess();

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);
    }

    interface Presenter extends BasePresenter<View> {

        void registerRequest(Map<String, Object> params);
    }
}

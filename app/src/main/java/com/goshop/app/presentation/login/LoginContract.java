package com.goshop.app.presentation.login;

import com.facebook.CallbackManager;
import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.UserInfo;

import java.util.Map;

public interface LoginContract {

    interface View extends BaseView {

        void showLogin(UserInfo userInfo);

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);

        void fbLoginError();

        void loginSuccess();

    }

    interface Presenter extends BasePresenter<LoginContract.View> {

        void getUserLogin(String username, String password);

        void thirdLogin(String platform, String accessToken);

        CallbackManager initFaceBook();

        void loginRequest(Map<String, Object> params);
    }
}

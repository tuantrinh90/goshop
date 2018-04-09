package com.goshop.app.presentation.login;

import com.facebook.AccessToken;
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

        void setFacebookLoginParams(String email, String fbId, String token, String name, String gender);

    }

    interface Presenter extends BasePresenter<LoginContract.View> {

        void getUserLogin(String username, String password);

        CallbackManager initFaceBook();

        void loginRequest(String email, String password);

        void facebookLoginRequest(String email, String fbId, String token, String name,
            String gender);

        void getFacebookAccessToken(AccessToken accessToken);
    }
}

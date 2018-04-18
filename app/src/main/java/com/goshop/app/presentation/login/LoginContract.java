package com.goshop.app.presentation.login;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.FacebookLoginVm;

public interface LoginContract {

    interface View extends BaseView {

        void showLogin(UserInfo userInfo);

        void showNetworkErrorMessage(String errorMessage);

        void showServiceErrorMessage(String errorMessage);

        void fbLoginError();

        void loginSuccess(Response<LoginResponse> response);

        void setFacebookLoginParams(FacebookLoginVm facebookLoginVm);
    }

    interface Presenter extends BasePresenter<LoginContract.View> {

        CallbackManager initFaceBook();

        void loginRequest(String email, String password);

        void facebookLoginRequest(String email, String fbId, String token, String name,
            String gender);

        void getFacebookAccessToken(AccessToken accessToken);
    }
}

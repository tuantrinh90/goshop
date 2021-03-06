package com.goshop.app.presentation.login;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.FacebookLoginVm;
import com.goshop.app.presentation.model.UserDataVM;

public interface LoginContract {

    interface View extends BaseView {

        void showNetworkErrorMessage(String errorMessage);

        void showServiceErrorMessage(String errorMessage);

        void fbLoginError();

        void loginSuccess(UserDataVM response);

        void setFacebookLoginParams(FacebookLoginVm facebookLoginVm);
    }

    interface Presenter extends BasePresenter<LoginContract.View> {

        CallbackManager initFaceBook();

        void loginRequest(String email, String password);

        void getFacebookAccessToken(AccessToken accessToken);

        void saveUserInfo(UserDataVM userDataVM);
    }
}

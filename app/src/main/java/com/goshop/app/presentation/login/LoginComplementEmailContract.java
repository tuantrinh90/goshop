package com.goshop.app.presentation.login;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.FacebookLoginVm;
import com.goshop.app.presentation.model.UserDataVM;

public class LoginComplementEmailContract {

    interface View extends BaseView {

        void complementEmailSuccess(UserDataVM response);

        void showServiceErrorMessage(String message);

        void showNetworkErrorMessage(String message);

    }

    public interface Presenter extends BasePresenter<View> {

        void facebookLoginRequest(FacebookLoginVm facebookLoginVm);

        void saveUserInfo(UserDataVM response);
    }

}

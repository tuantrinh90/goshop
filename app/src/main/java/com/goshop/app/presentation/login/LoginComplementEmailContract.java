package com.goshop.app.presentation.login;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.FacebookLoginVm;

import java.util.Map;

public class LoginComplementEmailContract {

    interface View extends BaseView {

        void complementEmailSuccess();

        void showServiceErrorMessage(String message);

        void showNetworkErrorMessage(String message);

    }

    public interface Presenter extends BasePresenter<View> {

        void complementEmailRequest(Map<String, Object> params);

        void facebookLoginRequest(FacebookLoginVm facebookLoginVm);
    }

}

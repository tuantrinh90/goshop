package com.goshop.app.presentation.account;

import com.facebook.CallbackManager;
import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.UserInfo;

/**
 * Created by img on 2018/1/9.
 */

public interface LoginContract {

    interface View extends BaseView {

        void showLogin(UserInfo userInfo);
        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);
        void fbLoginError();

    }
    interface Presenter extends BasePresenter<LoginContract.View> {
        void getUserLogin(String username,String password);
        void thirdLogin(String platform,String accessToken);
        CallbackManager initFaceBook();
    }
}

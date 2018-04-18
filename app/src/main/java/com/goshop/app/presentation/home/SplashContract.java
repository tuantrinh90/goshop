package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.UserData;

public class SplashContract {

    interface View extends BaseView {

        void onDelayFinished();

        void checkLoginSuccess(UserData userData);
    }

    public interface Presenter extends BasePresenter<View> {

        void delayToJump();

        void getUserInfo();
    }

}

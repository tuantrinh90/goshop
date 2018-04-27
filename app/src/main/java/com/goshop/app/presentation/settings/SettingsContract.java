package com.goshop.app.presentation.settings;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.UserData;

import java.util.Map;

public class SettingsContract {

    interface View extends BaseView {

        void logoutSuccess();

        void userInfoClearedSucceed(Boolean response);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String errorMessage);

        void onUserInfoGetSuccess(UserData response);
    }

    public interface Presenter extends BasePresenter<View> {

        void settingsLogoutRequest();

        void clearUserInfo();
        void getUserInfo();
    }

}

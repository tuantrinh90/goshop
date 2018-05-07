package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.presentation.model.FlagsVM;
import com.goshop.app.presentation.model.UserDataVM;

public class SplashContract {

    interface View extends BaseView {

        void onDelayFinished();

        void getLocalUserInfoSuccess(UserDataVM userData);

        void getUserProfileSuccess(UserDataVM userDataVM);

        void showErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void delayToJump();

        void getLocalUserInfo();

        void getFlags();

        void saveFlags(boolean isLoadLocalData, String type);

        void getStates();

        void getCitys(String stateId);

        void getZipCode(String stateId,String cityCode);

        void getUserProfile();

        void updateUserInfo(UserDataVM userDataVM);
    }

}

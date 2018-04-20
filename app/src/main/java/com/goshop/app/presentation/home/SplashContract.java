package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.presentation.model.FlagsVM;

public class SplashContract {

    interface View extends BaseView {

        void onDelayFinished();

        void checkLoginSuccess(UserData userData);

        void getFlagsSuccess(FlagsVM response);
    }

    public interface Presenter extends BasePresenter<View> {

        void delayToJump();

        void getUserInfo();

        void getFlags();

        void saveFlags(boolean isLoadLocalData, String type);
    }

}

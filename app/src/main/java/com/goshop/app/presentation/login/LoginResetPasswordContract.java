package com.goshop.app.presentation.login;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

public class LoginResetPasswordContract {

    interface View extends BaseView {

        void resetPwdSuccess();
        void resetPwdFailed(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void resetPasswordRequest(String email);
    }

}

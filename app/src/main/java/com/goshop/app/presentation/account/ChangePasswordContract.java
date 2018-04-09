package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

public class ChangePasswordContract {

    interface View extends BaseView {

        void success();

        void failed(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void changePasswordRequest(String customerId, String currentPassword, String newPassword);
    }
}

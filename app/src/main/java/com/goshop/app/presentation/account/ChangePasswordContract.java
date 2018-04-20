package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

public class ChangePasswordContract {

    interface View extends BaseView {

        void onChangePasswordSuccess();

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void changePasswordRequest(int customerId, String currentPassword, String newPassword);
    }
}

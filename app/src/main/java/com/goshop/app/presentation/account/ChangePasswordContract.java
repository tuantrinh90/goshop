package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

public class ChangePasswordContract {

    interface View extends BaseView {

        void success();

        void failed(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void changePasswordRequest(Map<String, Object> params);
    }
}

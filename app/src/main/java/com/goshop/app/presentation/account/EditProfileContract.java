package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

public class EditProfileContract {

    interface View extends BaseView {

        void editProfileResult();
    }

    public interface Presenter extends BasePresenter<View> {

        void editProfileRequest(Map<String, Object> params);
    }
}

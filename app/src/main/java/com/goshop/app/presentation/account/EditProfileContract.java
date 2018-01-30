package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

/**
 * Created by helen on 2018/1/26.
 */

public class EditProfileContract {

    interface View extends BaseView {

        void editProfileResult();
    }

    public interface Presenter extends BasePresenter<View> {

        void editProfileRequest(Map<String, Object> params);
    }
}

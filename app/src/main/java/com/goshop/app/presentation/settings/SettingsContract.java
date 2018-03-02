package com.goshop.app.presentation.settings;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

public class SettingsContract {

    interface View extends BaseView {

        void logoutResult();
    }

    public interface Presenter extends BasePresenter<View> {

        void settingsLogoutRequest(Map<String, Object> params);
    }

}

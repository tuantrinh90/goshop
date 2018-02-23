package com.goshop.app.presentation.settings;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.SettingsModel;

import java.util.List;

public class SettingsContract {

    interface View extends BaseView {

        void showSettingView(List<SettingsModel> settingsModelse);

        void startChangePasswordScreen();
    }

    public interface Presenter extends BasePresenter<View> {

        void getSettingsDetail();
    }

}

package com.goshop.app.presentation.settings;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.SettingsModel;

import java.util.List;

/**
 * Created by helen on 2018/2/8.
 */

public class SettingsContract {

    interface View extends BaseView {
        void showSettingView(List<SettingsModel> settingsModelse);
    }

    public interface Presenter extends BasePresenter<View> {
        void getSettingsDetail();
    }

}

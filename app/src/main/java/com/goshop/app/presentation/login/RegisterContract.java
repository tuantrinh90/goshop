package com.goshop.app.presentation.login;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.List;

public interface RegisterContract {

    interface View extends BaseView {

        void registerSuccess();

        void showNetworkErrorMessage(String errorMessage);

        void showServiceErrorMessage(String errorMessage);
    }

    interface Presenter extends BasePresenter<View> {

        void registerRequest(String name, String email, String password, String title,
            String gender, String birth, String mobile, String language, boolean sendEmail,
            boolean sendEms);

        List<ProfileMetaVM> getTitleChooses();

        List<ProfileMetaVM> getLanguageChooses();
    }
}

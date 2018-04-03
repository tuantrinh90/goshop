package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

import java.util.List;
import java.util.Map;

public class EditProfileContract {

    interface View extends BaseView {

        void editProfileResult();

        void editProfileSuccess();

        void editProfileFailed(String errorMessage);

        void setProfileVM(ProfileVM profileVM);
    }

    public interface Presenter extends BasePresenter<View> {

        void editProfileRequest(Map<String, Object> params);

        List<SingleChooseVM> getTitleChooses();

        List<SingleChooseVM> getLanguageChoose();

        List<SingleChooseVM> getRaceChoose();

        void getUserProfile();

    }
}

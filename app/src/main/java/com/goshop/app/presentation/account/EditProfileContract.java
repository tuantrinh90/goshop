package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.presentation.model.ProfileVM;

import java.util.List;

public class EditProfileContract {

    interface View extends BaseView {

        void editProfileResult();

        void editProfileSuccess();

        void getUserProfileSuccess(ProfileVM profileVM);

        void setLanguage(List<ProfileMetaVM> languageVMs);

        void setRace(List<ProfileMetaVM> raceVMs);

        void setGender(List<ProfileMetaVM> genderVMs);

        void showErrorMessage(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void editProfileRequest(String name, String email, String title, String gender,
            String birth, String mobile, String language);

        List<ProfileMetaVM> getTitleChooses();

        List<ProfileMetaVM> getLanguageChoose();

        List<ProfileMetaVM> getRaceChoose();

        void getUserProfile();

        void getProfileMetadata();

    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class EditProfileActivity extends BaseActivity<EditProfileContract.Presenter> implements
    EditProfileContract.View, PopWindowUtil.OnPopWindowDismissListener,
    PopWindowUtil.OnDatePickerDialogClickListener {

    @BindView(R.id.et_profile_email)
    CustomAnimEditText etProfileEmail;

    @BindView(R.id.et_profile_name)
    CustomAnimEditText etProfileName;

    @BindView(R.id.et_profile_mobile)
    CustomAnimEditText etProfileMobile;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    @BindView(R.id.tv_date_birth_hint)
    RobotoRegularTextView tvDateBirthHint;

    @BindView(R.id.iv_select_female)
    ImageView ivSelectFemale;

    @BindView(R.id.iv_select_male)
    ImageView ivSelectMale;

    @BindView(R.id.tv_gender_warning)
    RobotoRegularTextView tvGenderWarning;

    @BindView(R.id.tv_profile_date_of_birth)
    RobotoRegularTextView tvProfileDateOfBirth;

    @BindView(R.id.tv_profile_date_of_birth_warning)
    RobotoRegularTextView tvProfileDateOfBirthWarning;

    @BindView(R.id.tv_profile_language)
    RobotoRegularTextView tvProfileLanguage;

    @BindView(R.id.tv_profile_race)
    RobotoRegularTextView tvProfileRace;

    @BindView(R.id.tv_profile_title)
    RobotoRegularTextView tvProfileTitle;

    private String currentPopType = "";

    private String gender;

    private List<ProfileMetaVM> languagesVMS;

    private List<ProfileMetaVM> raceVMS;

    private List<ProfileMetaVM> titleVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getUserProfile();
        titleVMS = mPresenter.getTitleChooses();
        mPresenter.getProfileMetadata();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_edit_profile;
    }

    @Override
    public void inject() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        ivSelectFemale.setSelected(true);
        hideRightMenu();
        initPresenter();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.edit_profile);
    }

    @OnClick({R.id.imageview_left_menu, R.id.textview_right_menu, R.id.ll_select_female, R.id
        .ll_select_male, R.id.tv_profile_date_of_birth, R.id.tv_profile_title, R.id
        .tv_profile_language, R.id.tv_profile_race})
    public void onEditProfileClick(View view) {

        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                finish();
                break;
            case R.id.textview_right_menu:
                EditTextUtil.eidtLoseFocus(textviewRightMenu);
                String email = etProfileEmail.getText();
                String name = etProfileName.getText();
                String birth = tvProfileDateOfBirth.getText().toString();
                String title = tvProfileTitle.getText().toString();
                String mobile = etProfileMobile.getText();
                String language = tvProfileLanguage.getText().toString();
                String race = tvProfileRace.getText().toString();
                gender = ivSelectMale.isSelected() ? "0" : "1";
                judgmentInput(email, name, gender, birth, title, mobile, language,
                    race);
                break;
            case R.id.ll_select_female:
                EditTextUtil.eidtLoseFocus(view);
                ivSelectFemale.setSelected(true);
                if (ivSelectMale.isSelected()) {
                    ivSelectMale.setSelected(false);
                }
                break;
            case R.id.ll_select_male:
                EditTextUtil.eidtLoseFocus(view);
                ivSelectMale.setSelected(true);
                if (ivSelectFemale.isSelected()) {
                    ivSelectFemale.setSelected(false);
                }
                break;
            case R.id.tv_profile_date_of_birth:
                EditTextUtil.eidtLoseFocus(view);
                PopWindowUtil.showDatePickerDialog(tvProfileDateOfBirth, this::onDatePicker);
                break;

            case R.id.tv_profile_title:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.TITLE_POP;
                PopWindowUtil.showSingleChoosePop(tvProfileTitle,
                    getResources().getString(R.string.choose_title), titleVMS, this);
                break;

            case R.id.tv_profile_language:
                //todo please dont delete this it now use default
                /*EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.LANGUAGE_POP;
                PopWindowUtil.showSingleChoosePop(tvProfileLanguage,
                    getResources().getString(R.string.choose_language), languagesVMS, this);*/
                break;

            case R.id.tv_profile_race:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.RACE_POP;
                PopWindowUtil.showSingleChoosePop(tvProfileRace,
                    getResources().getString(R.string.choose_race), raceVMS, this);
                break;
        }
    }

    private void judgmentInput(String email, String name, String gender,
        String birth, String title, String mobile, String language, String race) {
        if (TextUtils.isEmpty(email) || !etProfileEmail.isEmail()) {
            etProfileEmail.setErrorMessage(getResources().getString(R.string.format_email_warning));
            return;
        }
        if (TextUtils.isEmpty(name)) {
            etProfileName.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }

        if (TextUtils.isEmpty(gender)) {
            tvGenderWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvGenderWarning.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(birth)) {
            tvProfileDateOfBirthWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvProfileDateOfBirthWarning.setVisibility(View.INVISIBLE);
        }
        if (TextUtils.isEmpty(mobile) || !etProfileMobile.isMobileNo()) {
            etProfileMobile
                .setErrorMessage(getResources().getString(R.string.format_mobile_warning));
            return;
        }

        mPresenter.editProfileRequest(name, email, title, gender, birth, mobile, language);
    }

    @Override
    public void editProfileResult() {
        //TODO  wait for api
    }

    @Override
    public void editProfileSuccess() {
        finish();
    }

    @Override
    public void getUserProfileSuccess(ProfileVM profileVM) {
        etProfileEmail.setText(profileVM.getEmail());
        etProfileName.setText(profileVM.getName());
        tvProfileDateOfBirth.setText(profileVM.getBirth());
        etProfileMobile.setText(profileVM.getMobile());
    }

    @Override
    public void setLanguage(List<ProfileMetaVM> languageVMs) {
        this.languagesVMS = languageVMs;
    }

    @Override
    public void setRace(List<ProfileMetaVM> raceVMs) {
        this.raceVMS = raceVMs;
    }

    @Override
    public void setGender(List<ProfileMetaVM> genderVMs) {
        //todo need decide
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(textviewRightMenu, errorMessage);
    }

    @Override
    public void onDatePicker(String time) {
        tvProfileDateOfBirth.setText(time);
        tvDateBirthHint.setVisibility(View.VISIBLE);
        tvProfileDateOfBirthWarning.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPopItemClick(int position) {
        if (!TextUtils.isEmpty(currentPopType)) {
            switch (currentPopType) {
                case PopWindowUtil.LANGUAGE_POP:
                    languagesVMS = PopWindowUtil.updateSinglePopDatas(position, languagesVMS);
                    tvProfileLanguage
                        .setText(languagesVMS.get(position).getValue());
                    break;
                case PopWindowUtil.TITLE_POP:
                    titleVMS = PopWindowUtil.updateSinglePopDatas(position, titleVMS);
                    tvProfileTitle.setText(titleVMS.get(position).getValue());
                    break;
                case PopWindowUtil.RACE_POP:
                    raceVMS = PopWindowUtil.updateSinglePopDatas(position, raceVMS);
                    tvProfileRace.setText(raceVMS.get(position).getValue());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //todo wait for design
    }

}

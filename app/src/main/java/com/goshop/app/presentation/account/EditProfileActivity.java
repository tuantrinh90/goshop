package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.presentation.model.widget.SingleChooseVM;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class EditProfileActivity extends BaseActivity<EditProfileContract.Presenter> implements
    EditProfileContract.View, PopWindowUtil.OnPopWindowDismissListener,
    PopWindowUtil.OnDatePickerDialogClickListener {

    @BindView(R.id.et_profile_email)
    CustomAnimEditText etProfileEmail;

    @BindView(R.id.et_profile_first)
    CustomAnimEditText etProfileFirst;

    @BindView(R.id.et_profile_last)
    CustomAnimEditText etProfileLast;

    @BindView(R.id.et_profile_mobile)
    CustomAnimEditText etProfileMobile;

    @BindView(R.id.tv_date_birth_hint)
    RobotoRegularTextView tvDateBirthHint;

    @BindView(R.id.iv_select_female)
    ImageView ivSelectFemale;

    @BindView(R.id.iv_select_male)
    ImageView ivSelectMale;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

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

    private List<SingleChooseVM> languagesVMS;

    private List<SingleChooseVM> raceVMS;

    private List<SingleChooseVM> titleVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        languagesVMS = mPresenter.getLanguageChoose();
        mPresenter.getUserProfile();
        titleVMS = mPresenter.getTitleChooses();
        raceVMS = mPresenter.getRaceChoose();
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
        initEditText();
        initPresenter();
    }

    private void initEditText() {
        etProfileFirst.initInputType(InputType.TYPE_CLASS_TEXT);
        etProfileFirst.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etProfileLast.initInputType(InputType.TYPE_CLASS_TEXT);
        etProfileLast.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etProfileEmail.initInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etProfileEmail.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etProfileMobile.initInputType(InputType.TYPE_CLASS_NUMBER);
        etProfileMobile.initImeOptions(EditorInfo.IME_ACTION_NEXT);
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
                String firstName = etProfileFirst.getText();
                String lastName = etProfileLast.getText();
                String birth = tvProfileDateOfBirth.getText().toString();
                String title = tvProfileTitle.getText().toString();
                String mobile = etProfileMobile.getText();
                String language = tvProfileLanguage.getText().toString();
                String race = tvProfileRace.getText().toString();
                gender = ivSelectMale.isSelected()?"0":"1";
                judgmentInput(email, firstName, lastName, gender, birth, title, mobile, language,
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
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.LANGUAGE_POP;
                PopWindowUtil.showSingleChoosePop(tvProfileLanguage,
                    getResources().getString(R.string.choose_language), languagesVMS, this);
                break;

            case R.id.tv_profile_race:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.RACE_POP;
                PopWindowUtil.showSingleChoosePop(tvProfileRace,
                    getResources().getString(R.string.choose_race), raceVMS, this);
                break;
        }
    }

    private void judgmentInput(String email, String firstName, String lastName, String gender,
        String birth, String title, String mobile, String language, String race) {
        if (TextUtils.isEmpty(email)) {
            etProfileEmail.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(firstName)) {
            etProfileFirst.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(lastName)) {
            etProfileLast.setErrorMessage(getResources().getString(R.string.empty_error));
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
        if (TextUtils.isEmpty(mobile)) {
            etProfileMobile.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        String name = firstName + " " + lastName;
        Map<String, Object> params = new HashMap<>();
        params.put("website_id", "");
        params.put("store_id", "");
        params.put("name", name);
        params.put("email", email);
        params.put("title", title);
        params.put("gender", gender);
        params.put("dob", birth);
        params.put("mobile_number", mobile);
        params.put("language", language);

        mPresenter.editProfileRequest(params);
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
    public void editProfileFailed(String errorMessage) {
        //todo wait for design
        Log.d("EditProfileActivity", errorMessage);
    }

    @Override
    public void setProfileVM(ProfileVM profileVM) {
        etProfileEmail.setText(profileVM.getEmail());
        etProfileFirst.setText(profileVM.getFirstName());
        tvProfileDateOfBirth.setText(profileVM.getBirth());
        etProfileMobile.setText(profileVM.getMobile());
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
                        .setText(languagesVMS.get(position).getContent());
                    break;
                case PopWindowUtil.TITLE_POP:
                    titleVMS = PopWindowUtil.updateSinglePopDatas(position, titleVMS);
                    tvProfileTitle.setText(titleVMS.get(position).getContent());
                    break;
                case PopWindowUtil.RACE_POP:
                    raceVMS = PopWindowUtil.updateSinglePopDatas(position, raceVMS);
                    tvProfileRace.setText(raceVMS.get(position).getContent());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //todo wait for design
    }

}

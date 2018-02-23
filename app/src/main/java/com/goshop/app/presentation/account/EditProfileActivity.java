package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomAnimSpinner;
import com.goshop.app.common.view.CustomTextView;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class EditProfileActivity extends BaseActivity<EditProfileContract.Presenter> implements
    EditProfileContract.View {

    @BindView(R.id.et_profile_date)
    CustomAnimSpinner etProfileDate;

    @BindView(R.id.et_profile_email)
    CustomAnimEditText etProfileEmail;

    @BindView(R.id.et_profile_first)
    CustomAnimEditText etProfileFirst;

    @BindView(R.id.et_profile_language)
    CustomAnimSpinner etProfileLanguage;

    @BindView(R.id.et_profile_last)
    CustomAnimEditText etProfileLast;

    @BindView(R.id.et_profile_mobile)
    CustomAnimEditText etProfileMobile;

    @BindView(R.id.et_profile_race)
    CustomAnimSpinner etProfileRace;

    @BindView(R.id.et_profile_title)
    CustomAnimSpinner etProfileTitle;

    @BindView(R.id.rb_edit_profile_female)
    RadioButton rbEditProfileFemale;

    @BindView(R.id.rb_edit_profile_male)
    RadioButton rbEditProfileMale;

    @BindView(R.id.rg_edit_profile_gender)
    RadioGroup rgEditProfileGender;

    @BindView(R.id.tv_btn_layout_pink)
    CustomTextView tvBtnLayout;

    private boolean isMale = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_edit_profile;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initSprinner();
        initRadioGroup();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.edit_profile);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @SuppressWarnings("unchecked")
    private void initSprinner() {
        etProfileDate.getEditText().setItems(getMockDatas());
        etProfileDate.getEditText().setOnItemSelectedListener((item, selectedIndex) -> {

        });

        etProfileTitle.getEditText().setItems(getMockDatas());
        etProfileTitle.getEditText().setOnItemSelectedListener((item, selectedIndex) -> {

        });

        etProfileLanguage.getEditText().setItems(getMockDatas());
        etProfileLanguage.getEditText().setOnItemSelectedListener((item, selectedIndex) -> {

        });

        etProfileRace.getEditText().setItems(getMockDatas());
        etProfileRace.getEditText().setOnItemSelectedListener((item, selectedIndex) -> {

        });

    }

    private void initRadioGroup() {
        if (isMale) {
            rbEditProfileMale.setChecked(true);
        } else {
            rbEditProfileFemale.setChecked(true);
        }
        rgEditProfileGender.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_edit_profile_female:
                    isMale = false;
                    break;
                case R.id.rb_edit_profile_male:
                    isMale = true;
                    break;
            }
        });
    }

    //TODO(helen)this is mock data will delete
    private List<String> getMockDatas() {
        List<String> list = new ArrayList<>();
        Resources res = getResources();
        String[] testList = res.getStringArray(R.array.test_list);
        Collections.addAll(list, testList);
        return list;
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_layout_pink})
    public void onEditProfileClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_layout_pink:
                judgmentInput(etProfileEmail.getText(), etProfileFirst.getText(),
                    etProfileLast.getText(), etProfileDate.getText(), etProfileMobile.getText());
                break;
        }
    }

    private void judgmentInput(String email, String firstName, String lastName, String birth,
        String mobile) {
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
        if (TextUtils.isEmpty(birth)) {
            etProfileDate.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(mobile)) {
            etProfileMobile.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        //TODO(helen) wait for api
        mPresenter.editProfileRequest(null);
    }

    @Override
    public void editProfileResult() {
        //TODO(helen) wait for api
    }
}

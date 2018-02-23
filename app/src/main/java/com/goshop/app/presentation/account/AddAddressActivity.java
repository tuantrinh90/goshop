package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomAnimSpinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class AddAddressActivity extends BaseActivity<AddAddressContract.Presenter> implements
    AddAddressContract.View {

    @BindView(R.id.cb_register_email)
    CheckBox cbRegisterEmail;

    @BindView(R.id.cb_register_sms)
    CheckBox cbRegisterSms;

    @BindView(R.id.et_add_address_first)
    CustomAnimEditText etAddAddressFirst;

    @BindView(R.id.et_add_address_last)
    CustomAnimEditText etAddAddressLast;

    @BindView(R.id.et_add_address_one)
    CustomAnimEditText etAddAddressOne;

    @BindView(R.id.et_add_address_phone)
    CustomAnimEditText etAddAddressPhone;

    @BindView(R.id.et_add_address_two)
    CustomAnimEditText etAddAddressTwo;

    @BindView(R.id.et_add_address_zip)
    CustomAnimEditText etAddAddressZip;

    @BindView(R.id.et_profile_city)
    CustomAnimSpinner etProfileCity;

    @BindView(R.id.et_profile_country)
    CustomAnimSpinner etProfileCountry;

    @BindView(R.id.et_profile_state)
    CustomAnimSpinner etProfileState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_add_address;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.add_address);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_layout_pink})
    public void onAddAddressClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_layout_pink:
                judgmentInput(etAddAddressFirst.getText(), etAddAddressLast.getText(),
                    etAddAddressOne.getText(), etAddAddressTwo.getText(),
                    etProfileCountry.getText(), etProfileState.getText(), etAddAddressZip.getText(),
                    etAddAddressPhone.getText());
                break;
        }
    }

    private void judgmentInput(String firstName, String lastName, String addressOne,
        String addressTwo, String country, String state, String zip, String phone) {
        if (TextUtils.isEmpty(firstName)) {
            etAddAddressFirst.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(lastName)) {
            etAddAddressLast.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(addressOne)) {
            etAddAddressOne.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(addressTwo)) {
            etAddAddressTwo.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(country)) {
            etProfileCountry.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(state)) {
            etProfileState.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(zip)) {
            etAddAddressZip.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            etAddAddressPhone.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        //todo(helen) wait for api
        mPresenter.addAddressRequest(null);
    }

    @Override
    public void addAddressResult() {

    }
}

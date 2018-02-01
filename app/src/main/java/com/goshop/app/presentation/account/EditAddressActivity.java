package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomAnimSpinner;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.AddressVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by helen on 2018/1/29.
 */

public class EditAddressActivity extends BaseActivity {

    public static final String EDIT_ADDRESS = "edit_address";

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

    @BindView(R.id.ll_add_address_bottom)
    LinearLayout llAddAddressBottom;

    @BindView(R.id.tv_btn_layout_pink)
    CustomTextView tvBtnLayoutPink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_add_address;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.edit_address);
    }

    @Override
    public void inject() {
        hideRightMenu();
        setUp();
    }

    private void setUp() {
        AddressVM addressVM = getIntent().getParcelableExtra(EDIT_ADDRESS);
        //TODO(helen) wait for real data
        etAddAddressFirst.setText("Test");
        etAddAddressLast.setText("Test");
        etAddAddressOne.setText("Test Address 1");
        etAddAddressTwo.setText("Test Address 2");
        etAddAddressZip.setText("02600");
        etAddAddressPhone.setText("111111");
        cbRegisterEmail.setChecked(true);
        cbRegisterSms.setChecked(true);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onEditAddressClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}

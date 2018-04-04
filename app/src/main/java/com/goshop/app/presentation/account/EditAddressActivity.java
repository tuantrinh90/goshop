package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.presentation.model.widget.SingleChooseVM;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class EditAddressActivity extends BaseActivity<EditAddressContract.Presenter> implements
    EditAddressContract.View, PopWindowUtil
    .OnPopWindowDismissListener {

    public static final String EDIT_ADDRESS = "edit_address";

    @BindView(R.id.et_edit_address_first)
    CustomAnimEditText etEditAddressFirst;

    @BindView(R.id.et_edit_address_last)
    CustomAnimEditText etEditAddressLast;

    @BindView(R.id.et_edit_address_one)
    CustomAnimEditText etEditAddressOne;

    @BindView(R.id.et_edit_address_phone)
    CustomAnimEditText etEditAddressPhone;

    @BindView(R.id.et_edit_address_two)
    CustomAnimEditText etEditAddressTwo;

    @BindView(R.id.et_edit_address_zip)
    CustomAnimEditText etEditAddressZip;

    @BindView(R.id.iv_edit_address_email)
    ImageView ivEditAddressEmail;

    @BindView(R.id.iv_edit_address_sms)
    ImageView ivEditAddressSms;

    @BindView(R.id.ll_edit_address_email)
    LinearLayout llEditAddressEmail;

    @BindView(R.id.ll_edit_address_sms)
    LinearLayout llEditAddressSms;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    @BindView(R.id.tv_edit_address_city)
    RobotoRegularTextView tvEditAddressCity;

    @BindView(R.id.tv_edit_address_city_warning)
    RobotoRegularTextView tvEditAddressCityWarning;

    @BindView(R.id.tv_edit_address_country)
    RobotoRegularTextView tvEditAddressCountry;

    @BindView(R.id.tv_edit_address_country_warning)
    RobotoRegularTextView tvEditAddressCountryWarning;

    @BindView(R.id.tv_edit_address_state)
    RobotoRegularTextView tvEditAddressState;

    @BindView(R.id.tv_edit_address_state_warning)
    RobotoRegularTextView tvEditAddressStateWarning;

    private List<SingleChooseVM> cityVMS;

    private List<SingleChooseVM> countryVMS;

    private String currentPop = "";

    private List<SingleChooseVM> stateVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countryVMS = mPresenter.getCountryChooses();
        stateVMS = mPresenter.getStateChooses();
        cityVMS = mPresenter.getCityChooses();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_edit_address;
    }

    @Override
    public void inject() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        ivEditAddressSms.setSelected(true);
        ivEditAddressEmail.setSelected(true);
        setUp();
        initPresenter();
    }

    private void setUp() {
        AddressVM addressVM = getIntent().getParcelableExtra(EDIT_ADDRESS);
        //TODO  wait for real data
        etEditAddressFirst.setText("Test");
        etEditAddressLast.setText("Test");
        etEditAddressOne.setText("Test Address 1");
        etEditAddressTwo.setText("Test Address 2");
        etEditAddressZip.setText("02600");
        etEditAddressPhone.setText("111111");
        ivEditAddressEmail.setSelected(true);
        ivEditAddressSms.setSelected(true);
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
        return getResources().getString(R.string.edit_address);
    }

    @OnClick({R.id.imageview_left_menu, R.id.ll_edit_address_email, R.id.ll_edit_address_sms, R
        .id.textview_right_menu, R.id.tv_edit_address_city, R.id.tv_edit_address_country, R.id
        .tv_edit_address_state})
    public void onEditAddressClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
                String firstName = etEditAddressFirst.getText();
                String lastName = etEditAddressLast.getText();
                String addressOne = etEditAddressOne.getText();
                String addressTwo = etEditAddressTwo.getText();
                String country = tvEditAddressCountry.getText().toString();
                String state = tvEditAddressState.getText().toString();
                String city = tvEditAddressCity.getText().toString();
                String zip = etEditAddressZip.getText();
                String phone = etEditAddressPhone.getText();
                judgmentInput(firstName, lastName, addressOne, addressTwo, country, state, city,
                    zip, phone, ivEditAddressEmail.isSelected(), ivEditAddressSms.isSelected());

                break;
            case R.id.ll_edit_address_email:
                ivEditAddressEmail.setSelected(!ivEditAddressEmail.isSelected());
                break;
            case R.id.ll_edit_address_sms:
                ivEditAddressSms.setSelected(!ivEditAddressSms.isSelected());
                break;
            case R.id.tv_edit_address_city:
                currentPop = PopWindowUtil.CITY_POP;
                PopWindowUtil
                    .showSingleChoosePop(view, getResources().getString(R.string.city), cityVMS,
                        this);
                break;
            case R.id.tv_edit_address_country:
                currentPop = PopWindowUtil.COUNTRY_POP;
                PopWindowUtil.showSingleChoosePop(view, getResources().getString(R.string.country),
                    countryVMS, this);
                break;
            case R.id.tv_edit_address_state:
                currentPop = PopWindowUtil.STATE_POP;
                PopWindowUtil
                    .showSingleChoosePop(view, getResources().getString(R.string.state), stateVMS,
                        this);
                break;
        }
    }

    private void judgmentInput(String firstName, String lastName, String addressOne,
        String addressTwo, String country, String state, String city, String zip, String phone,
        boolean firstChecked, boolean secondChecked) {
        if (TextUtils.isEmpty(firstName)) {
            etEditAddressFirst.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(lastName)) {
            etEditAddressLast.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(addressOne)) {
            etEditAddressOne.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(addressTwo)) {
            etEditAddressTwo.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(country)) {
            tvEditAddressCountryWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvEditAddressCountryWarning.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(state)) {
            tvEditAddressStateWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvEditAddressCountryWarning.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(city)) {
            tvEditAddressCityWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvEditAddressCityWarning.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(zip)) {
            etEditAddressZip.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            etEditAddressPhone.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }

        AddressRequest request = new AddressRequest();
        AddressRequest.RequestData requestData = new AddressRequest.RequestData();
        requestData.setWebsite_id(1);
        requestData.setStore_id(3);
        AddressRequest.RequestData.AddressData addressData = new AddressRequest.RequestData
            .AddressData();
        addressData.setName(firstName);
        addressData.setAddress1(addressOne);
        addressData.setAddress2(addressTwo);
        addressData.setCountry(country);
        //todo need decide by api
        addressData.setState(123);
        addressData.setCity(123);
        addressData.setZipcode(Integer.parseInt(zip));
        addressData.setPhone_number(phone);
        addressData.setDefault_shipping_address(firstChecked);
        requestData.setAddress(addressData);
        request.setRequest(requestData);
        mPresenter.editAddressRequest(request);
    }

    @Override
    public void onPopItemClick(int position) {
        if (!TextUtils.isEmpty(currentPop)) {
            switch (currentPop) {
                case PopWindowUtil.COUNTRY_POP:
                    countryVMS = PopWindowUtil.updateSinglePopDatas(position, countryVMS);
                    tvEditAddressCountry
                        .setText(countryVMS.get(position).getContent());
                    break;
                case PopWindowUtil.STATE_POP:
                    stateVMS = PopWindowUtil.updateSinglePopDatas(position, stateVMS);
                    tvEditAddressState.setText(stateVMS.get(position).getContent());
                    break;
                case PopWindowUtil.CITY_POP:
                    cityVMS = PopWindowUtil.updateSinglePopDatas(position, cityVMS);
                    tvEditAddressCity.setText(cityVMS.get(position).getContent());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //todo wait for api
    }

    @Override
    public void showEditAddressResult() {
        //todo wait for api
    }

    @Override
    public void editAddressSuccess() {
        finish();
    }

    @Override
    public void editAddressFailed(String errorMessage) {
        //todo need decide
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }
}

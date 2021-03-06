package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoLightCheckBox;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.request.common.AddressRequestData;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EditAddressActivity extends BaseActivity<EditAddressContract.Presenter> implements
    EditAddressContract.View, PopWindowUtil
    .OnPopWindowDismissListener {

    public static final String EDIT_ADDRESS = "edit_address";

    @BindView(R.id.checkbox_default_billing)
    RobotoLightCheckBox checkboxDefaultBilling;

    @BindView(R.id.checkbox_default_shipping)
    RobotoLightCheckBox checkboxDefaultShipping;

    @BindView(R.id.et_edit_name)
    CustomAnimEditText etEditName;

    @BindView(R.id.et_edit_address_one)
    CustomAnimEditText etEditAddressOne;

    @BindView(R.id.et_edit_address_phone)
    CustomAnimEditText etEditAddressPhone;

    @BindView(R.id.et_edit_address_two)
    CustomAnimEditText etEditAddressTwo;

    @BindView(R.id.et_edit_address_zip)
    CustomAnimEditText etEditAddressZip;

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

    private List<ProfileMetaVM> cityVMS;

    private List<ProfileMetaVM> countryVMS;

    private String currentPop = "";

    private List<ProfileMetaVM> stateVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 2018/4/25 this code need decide
        mPresenter.getStates();
        mPresenter.getCitys("543");
        mPresenter.getZipCode("543", "Kualalumpur");
        countryVMS = mPresenter.getCountryChooses();
        stateVMS = new ArrayList<>();
        cityVMS = new ArrayList<>();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_edit_address;
    }

    @Override
    public void inject() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        tvEditAddressCountry.setText(getResources().getString(R.string.malaysia));
        checkboxDefaultBilling.setChecked(true);
        checkboxDefaultShipping.setChecked(true);
        setUp();
        initPresenter();
    }

    private void setUp() {
        AddressVM addressVM = getIntent().getParcelableExtra(EDIT_ADDRESS);
        etEditName.setText(addressVM.getName());
        String[] addresses = addressVM.getAddress().split(",");
        etEditAddressOne.setText(addresses[0]);
        etEditAddressTwo.setText(addresses[1]);
        etEditAddressZip.setText(addressVM.getCode());
        etEditAddressPhone.setText(addressVM.getTel().replace("T: +", ""));
        tvEditAddressCity.setText(addressVM.getCity());
        tvEditAddressState.setText(addressVM.getState());
        tvEditAddressCountry.setText(addressVM.getCountry());
        checkboxDefaultBilling.setChecked(true);
        checkboxDefaultShipping.setChecked(true);
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.edit_address);
    }

    @OnClick({R.id.imageview_left_menu, R
        .id.textview_right_menu, R.id.tv_edit_address_city, R.id.tv_edit_address_country, R.id
        .tv_edit_address_state})
    public void onEditAddressClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
                String name = etEditName.getText();
                String addressOne = etEditAddressOne.getText();
                String addressTwo = etEditAddressTwo.getText();
                String country = tvEditAddressCountry.getText().toString();
                String state = tvEditAddressState.getText().toString();
                String city = tvEditAddressCity.getText().toString();
                String zip = etEditAddressZip.getText();
                String phone = etEditAddressPhone.getText();
                judgmentInput(name, addressOne, addressTwo, country, state, city,
                    zip, phone);

                break;
            case R.id.tv_edit_address_city:
                currentPop = PopWindowUtil.CITY_POP;
                PopWindowUtil
                    .showSingleChoosePop(view, getResources().getString(R.string.city), cityVMS,
                        this);
                break;
            case R.id.tv_edit_address_country:
                //todo now api have no data about country
                // todo this will do nothing, please dont delete
//                currentPop = PopWindowUtil.COUNTRY_POP;
//                PopWindowUtil.showSingleChoosePop(view, getResources().getString(R.string
// .country),
//                    countryVMS, this);
                break;
            case R.id.tv_edit_address_state:
                currentPop = PopWindowUtil.STATE_POP;
                PopWindowUtil
                    .showSingleChoosePop(view, getResources().getString(R.string.state), stateVMS,
                        this);
                break;
        }
    }

    @Override
    public void onStatesRequestSuccess(List<ProfileMetaVM> response) {
        stateVMS.addAll(response);
    }

    @Override
    public void onCitysRequestSuccess(List<ProfileMetaVM> response) {
        cityVMS.addAll(response);
    }

    @Override
    public void onZipCodeRequestSuccess(List<ProfileMetaVM> response) {
        //need decide
    }

    private void judgmentInput(String name, String addressOne,
        String addressTwo, String country, String state, String city, String zip, String phone) {
        if (TextUtils.isEmpty(name)) {
            etEditName.setErrorMessage(getResources().getString(R.string.empty_error));
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
        AddressRequestData requestData = new AddressRequestData();
        requestData.setWebsiteId(Const.WEBSITE_ID + "");
        requestData.setStoreId(Const.STORE_ID + "");
        requestData.setFirstName(name);
        HashMap<String, Object> street = new HashMap<>();
        //todo this hard code need wait for api decide
        street.put("0", "Bukit Jalil");
        street.put("1", "Astro");
        requestData.setStreet(street);
        requestData.setCountryId("");
        requestData.setRegionId(1);
        requestData.setCity(city);
        requestData.setPostcode(1);
        requestData.setTelephone(phone);
        requestData.setDefaultBilling(checkboxDefaultBilling.isChecked());
        requestData.setDefaultShipping(checkboxDefaultShipping.isChecked());
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
                        .setText(countryVMS.get(position).getValue());
                    break;
                case PopWindowUtil.STATE_POP:
                    stateVMS = PopWindowUtil.updateSinglePopDatas(position, stateVMS);
                    tvEditAddressState.setText(stateVMS.get(position).getValue());
                    break;
                case PopWindowUtil.CITY_POP:
                    cityVMS = PopWindowUtil.updateSinglePopDatas(position, cityVMS);
                    tvEditAddressCity.setText(cityVMS.get(position).getValue());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //todo wait for api
    }

    @Override
    public void editAddressSuccess() {
        finish();
    }

    @Override
    public void editAddressFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(textviewRightMenu, errorMessage);
    }


}

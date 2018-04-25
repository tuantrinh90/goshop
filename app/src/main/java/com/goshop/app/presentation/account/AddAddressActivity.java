package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoLightCheckBox;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.request.common.AddressRequestData;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class AddAddressActivity extends BaseActivity<AddAddressContract.Presenter> implements
    AddAddressContract.View, PopWindowUtil.OnPopWindowDismissListener {

    @BindView(R.id.checkbox_default_billing)
    RobotoLightCheckBox checkboxDefaultBilling;

    @BindView(R.id.checkbox_default_shipping)
    RobotoLightCheckBox checkboxDefaultShipping;

    @BindView(R.id.et_add_address_name)
    CustomAnimEditText etAddAddressName;

    @BindView(R.id.et_add_address_one)
    CustomAnimEditText etAddAddressOne;

    @BindView(R.id.et_add_address_phone)
    CustomAnimEditText etAddAddressPhone;

    @BindView(R.id.et_add_address_two)
    CustomAnimEditText etAddAddressTwo;

    @BindView(R.id.et_add_address_zip)
    CustomAnimEditText etAddAddressZip;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    @BindView(R.id.tv_add_address_city)
    RobotoRegularTextView tvAddAddressCity;

    @BindView(R.id.tv_add_address_city_warning)
    RobotoRegularTextView tvAddAddressCityWarning;

    @BindView(R.id.tv_add_address_country)
    RobotoRegularTextView tvAddAddressCountry;

    @BindView(R.id.tv_add_address_country_warning)
    RobotoRegularTextView tvAddAddressCountryWarning;

    @BindView(R.id.tv_add_address_state)
    RobotoRegularTextView tvAddAddressState;

    @BindView(R.id.tv_add_address_state_warning)
    RobotoRegularTextView tvAddAddressStateWarning;

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
        return R.layout.activity_add_address;
    }

    @Override
    public void inject() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        tvAddAddressCountry.setText(getResources().getString(R.string.malaysia));
        checkboxDefaultBilling.setChecked(true);
        checkboxDefaultShipping.setChecked(true);
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
        return getResources().getString(R.string.add_address);
    }

    @OnClick({R.id.imageview_left_menu, R.id.textview_right_menu,
        R.id.tv_add_address_city, R.id.tv_add_address_country, R.id
        .tv_add_address_state})
    public void onAddAddressClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
                String firstName = etAddAddressName.getText();
                String addressOne = etAddAddressOne.getText();
                String addressTwo = etAddAddressTwo.getText();
                String state = tvAddAddressState.getText().toString();
                String city = tvAddAddressCity.getText().toString();
                String zip = etAddAddressZip.getText();
                String phone = etAddAddressPhone.getText();
                judgmentInput(firstName, addressOne, addressTwo, state, city, zip, phone);
                break;
            case R.id.tv_add_address_city:
                currentPop = PopWindowUtil.CITY_POP;
                PopWindowUtil
                    .showSingleChoosePop(view, getResources().getString(R.string.city), cityVMS,
                        this);
                break;
            case R.id.tv_add_address_country:
                //todo now api have no data about country
                // todo this will do nothing, please dont delete
                /*currentPop = PopWindowUtil.COUNTRY_POP;
                PopWindowUtil.showSingleChoosePop(view, getResources().getString(R.string.country),
                    countryVMS, this);*/
                break;
            case R.id.tv_add_address_state:
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
        String addressTwo, String state, String city, String zip, String phone) {
        if (TextUtils.isEmpty(name)) {
            etAddAddressName.setErrorMessage(getResources().getString(R.string.empty_error));
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
        if (TextUtils.isEmpty(state)) {
            tvAddAddressStateWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvAddAddressCountryWarning.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(city)) {
            tvAddAddressCityWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvAddAddressCityWarning.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(zip)) {
            etAddAddressZip.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            etAddAddressPhone.setErrorMessage(getResources().getString(R.string.empty_error));
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
        requestData.setCountryId(Const.COUNTRY_ID);
        requestData.setCity(city);
        requestData.setPostcode(1);
        requestData.setTelephone(phone);
        requestData.setDefaultBilling(checkboxDefaultBilling.isChecked());
        requestData.setDefaultShipping(checkboxDefaultShipping.isChecked());
        request.setRequest(requestData);
        mPresenter.addAddressRequest(request);
    }

    @Override
    public void addAddressResult() {

    }

    @Override
    public void addAddressSuccess() {
        finish();
    }

    @Override
    public void addAddressFailed(String errorMessage) {
        //todo need decide
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPopItemClick(int position) {
        if (!TextUtils.isEmpty(currentPop)) {
            switch (currentPop) {
                case PopWindowUtil.COUNTRY_POP:
                    countryVMS = PopWindowUtil.updateSinglePopDatas(position, countryVMS);
                    tvAddAddressCountry
                        .setText(countryVMS.get(position).getValue());
                    break;
                case PopWindowUtil.STATE_POP:
                    stateVMS = PopWindowUtil.updateSinglePopDatas(position, stateVMS);
                    tvAddAddressState.setText(stateVMS.get(position).getValue());
                    break;
                case PopWindowUtil.CITY_POP:
                    cityVMS = PopWindowUtil.updateSinglePopDatas(position, cityVMS);
                    tvAddAddressCity.setText(cityVMS.get(position).getValue());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {

    }
}

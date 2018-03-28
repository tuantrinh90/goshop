package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
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

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class AddAddressActivity extends BaseActivity<AddAddressContract.Presenter> implements
    AddAddressContract.View, PopWindowUtil.OnPopWindowDismissListener {

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

    @BindView(R.id.iv_add_address_email)
    ImageView ivAddAddressEmail;

    @BindView(R.id.iv_add_address_sms)
    ImageView ivAddAddressSms;

    @BindView(R.id.ll_add_address_email)
    LinearLayout llAddAddressEmail;

    @BindView(R.id.ll_add_address_sms)
    LinearLayout llAddAddressSms;

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
        return R.layout.activity_add_address;
    }

    @Override
    public void inject() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        ivAddAddressEmail.setSelected(true);
        ivAddAddressSms.setSelected(true);
        initEditType();
        initPresenter();
    }

    private void initEditType() {
        etAddAddressFirst.initInputType(InputType.TYPE_CLASS_TEXT);
        etAddAddressFirst.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etAddAddressLast.initInputType(InputType.TYPE_CLASS_TEXT);
        etAddAddressLast.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etAddAddressOne.initInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etAddAddressOne.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etAddAddressTwo.initInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etAddAddressTwo.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etAddAddressPhone.initInputType(InputType.TYPE_CLASS_NUMBER);
        etAddAddressPhone.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etAddAddressZip.initInputType(InputType.TYPE_CLASS_NUMBER);
        etAddAddressZip.initImeOptions(EditorInfo.IME_ACTION_NEXT);
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

    @OnClick({R.id.imageview_left_menu, R.id.textview_right_menu, R.id.ll_add_address_email, R.id
        .ll_add_address_sms, R.id.tv_add_address_city, R.id.tv_add_address_country, R.id
        .tv_add_address_state})
    public void onAddAddressClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
                String firstName = etAddAddressFirst.getText();
                String lastName = etAddAddressLast.getText();
                String addressOne = etAddAddressOne.getText();
                String addressTwo = etAddAddressTwo.getText();
                String country = tvAddAddressCountry.getText().toString();
                String state = tvAddAddressState.getText().toString();
                String city = tvAddAddressCity.getText().toString();
                String zip = etAddAddressZip.getText();
                String phone = etAddAddressPhone.getText();
                judgmentInput(firstName, lastName, addressOne, addressTwo, country, state, city,
                    zip, phone, ivAddAddressEmail.isSelected(), ivAddAddressSms.isSelected());
                break;
            case R.id.ll_add_address_email:
                ivAddAddressEmail.setSelected(!ivAddAddressEmail.isSelected());
                break;
            case R.id.ll_add_address_sms:
                ivAddAddressSms.setSelected(!ivAddAddressSms.isSelected());
                break;
            case R.id.tv_add_address_city:
                currentPop = PopWindowUtil.CITY_POP;
                PopWindowUtil
                    .showSingleChoosePop(view, getResources().getString(R.string.city), cityVMS,
                        this);
                break;
            case R.id.tv_add_address_country:
                currentPop = PopWindowUtil.COUNTRY_POP;
                PopWindowUtil.showSingleChoosePop(view, getResources().getString(R.string.country),
                    countryVMS, this);
                break;
            case R.id.tv_add_address_state:
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
            tvAddAddressCountryWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvAddAddressCountryWarning.setVisibility(View.GONE);
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
        //todo  wait for api
        mPresenter.addAddressRequest(null);
    }

    @Override
    public void addAddressResult() {

    }

    @Override
    public void onPopItemClick(int position) {
        if (!TextUtils.isEmpty(currentPop)) {
            switch (currentPop) {
                case PopWindowUtil.COUNTRY_POP:
                    countryVMS = PopWindowUtil.updateSinglePopDatas(position, countryVMS);
                    tvAddAddressCountry
                        .setText(countryVMS.get(position).getContent());
                    break;
                case PopWindowUtil.STATE_POP:
                    stateVMS = PopWindowUtil.updateSinglePopDatas(position, stateVMS);
                    tvAddAddressState.setText(stateVMS.get(position).getContent());
                    break;
                case PopWindowUtil.CITY_POP:
                    cityVMS = PopWindowUtil.updateSinglePopDatas(position, cityVMS);
                    tvAddAddressCity.setText(cityVMS.get(position).getContent());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {

    }
}

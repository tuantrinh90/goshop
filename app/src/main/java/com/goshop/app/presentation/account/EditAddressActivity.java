package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
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
        hideRightMenu();
        ivEditAddressSms.setSelected(true);
        ivEditAddressEmail.setSelected(true);
        initEditType();
        setUp();
        initPresenter();
    }

    private void initEditType() {
        etEditAddressFirst.initInputType(InputType.TYPE_CLASS_TEXT);
        etEditAddressFirst.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etEditAddressLast.initInputType(InputType.TYPE_CLASS_TEXT);
        etEditAddressLast.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etEditAddressOne.initInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etEditAddressOne.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etEditAddressTwo.initInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        etEditAddressTwo.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etEditAddressPhone.initInputType(InputType.TYPE_CLASS_NUMBER);
        etEditAddressPhone.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        etEditAddressZip.initInputType(InputType.TYPE_CLASS_NUMBER);
        etEditAddressZip.initImeOptions(EditorInfo.IME_ACTION_NEXT);
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
        .id.tv_btn_layout_pink, R.id.tv_edit_address_city, R.id.tv_edit_address_country, R.id
        .tv_edit_address_state})
    public void onEditAddressClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_layout_pink:
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

    }

    @Override
    public void showEditAddressResult() {

    }
}

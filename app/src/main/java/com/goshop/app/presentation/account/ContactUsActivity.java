package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.presentation.model.ContactUsVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ContactUsActivity extends BaseActivity<ContactUsContract.Presenter> implements
    ContactUsContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.et_contact_us_mobile)
    CustomAnimEditText etContactUsMobile;

    @BindView(R.id.iv_contact_facebook)
    ImageView ivContactFacebook;

    @BindView(R.id.iv_contact_group)
    ImageView ivContactGroup;

    @BindView(R.id.iv_contact_twitter)
    ImageView ivContactTwitter;

    @BindView(R.id.tv_contact_email)
    RobotoLightTextView tvContactEmail;

    @BindView(R.id.tv_contact_phone)
    RobotoLightTextView tvContactPhone;

    private ToastUtil toastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getContactInfo();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_contact_us;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        toastUtil = new ToastUtil(this, this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.contact_us);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void showContactInfo(ContactUsVM contactUsVM) {
        tvContactEmail.setText(contactUsVM.getEmail());
        tvContactPhone.setText(NumberFormater.formaterPhoneNumber(contactUsVM.getPhone()));
    }

    @Override
    public void requestResult() {
        //TODO  wait for api
        toastUtil.showThanksToast();
    }

    @Override
    public void onToastCancel() {
        finish();
    }

    @OnClick({R.id.imageview_left_menu, R.id.iv_contact_facebook, R.id.iv_contact_group, R.id
        .iv_contact_twitter, R.id.tv_btn_contact_us})
    public void onContactUsClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.iv_contact_facebook:
            case R.id.iv_contact_group:
            case R.id.iv_contact_twitter:
                break;
            case R.id.tv_btn_contact_us:
                //TODO wait for api
                mPresenter.contactMessageRequest(null);
                break;
        }
    }


}

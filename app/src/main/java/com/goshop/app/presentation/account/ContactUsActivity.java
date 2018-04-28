package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.presentation.model.ContactUsVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ToastUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ContactUsActivity extends BaseActivity<ContactUsContract.Presenter> implements
    ContactUsContract.View, ToastUtil.OnToastListener {

    public static final String REDIRECT_TYPE_EMAIL = "email";

    public static final String REDIRECT_TYPE_PHONE = "phone";

    public static final String REDIRECT_TYPE_FACEBOOK = "facebook";

    public static final String REDIRECT_TYPE_INSTAGRAM = "instagram";

    public static final String REDIRECT_TYPE_TWITTER = "twitter";

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

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

    @BindView(R.id.et_name)
    CustomAnimEditText etName;

    @BindView(R.id.et_email)
    CustomAnimEditText etEmail;

    @BindView(R.id.et_phone)
    CustomAnimEditText etPhone;

    @BindView(R.id.et_product_handing)
    CustomAnimEditText etProductHanding;

    @BindView(R.id.et_detail)
    RobotoRegularEditText etDetail;

    private ToastUtil toastUtil;

    private String name;

    private String email;

    private String mobile;

    private String productHanding;

    private String details;

    private ContactUsVM contactUsVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.getContactInfo();
    }

    private void initView() {
        etPhone.setInputType(InputType.TYPE_CLASS_PHONE);
        hideRightMenu();
        toastUtil = new ToastUtil(this, this);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_contact_us;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.contact_us);
    }

    @Override
    public void showContactInfo(ContactUsVM contactUsVM) {
        this.contactUsVM = contactUsVM;
        tvContactEmail.setText(contactUsVM.getEmail());
        tvContactPhone.setText(NumberFormater.formaterPhoneNumber(contactUsVM.getPhone()));
    }

    @Override
    public void requestResult() {
        toastUtil.showThanksToast();
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(llContainer, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String message) {
        PopWindowUtil.showRequestMessagePop(llContainer, message);
    }

    @Override
    public void onToastCancel() {
        finish();
    }

    @OnClick({R.id.tv_contact_email, R.id.tv_contact_phone, R.id.imageview_left_menu, R.id
        .iv_contact_facebook, R.id.iv_contact_group, R.id
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
            case R.id.tv_contact_email:
                redirectContactUs(REDIRECT_TYPE_EMAIL);
                break;
            case R.id.tv_contact_phone:
                redirectContactUs(REDIRECT_TYPE_PHONE);
                break;
            case R.id.iv_contact_facebook:
                redirectContactUs(REDIRECT_TYPE_FACEBOOK);
                break;
            case R.id.iv_contact_group:
                redirectContactUs(REDIRECT_TYPE_INSTAGRAM);
                break;
            case R.id.iv_contact_twitter:
                redirectContactUs(REDIRECT_TYPE_TWITTER);
                break;
            case R.id.tv_btn_contact_us:
                name = etName.getText();
                email = etEmail.getText();
                mobile = etPhone.getText();
                productHanding = etProductHanding.getText();
                details = etDetail.getText().toString();
                checkDataAndRequest();
                break;
        }
    }

    private void redirectContactUs(String type) {
        // TODO: 2018/4/25 this method need decide
        Intent intent = new Intent();
        String url = "";
        switch (type) {
            case REDIRECT_TYPE_EMAIL:
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, "me@abc.com");
                it.putExtra(Intent.EXTRA_TEXT, "The email body text");
                it.setType("text/plain");
                startActivity(Intent.createChooser(it, "Choose Email Client"));
                break;
            case REDIRECT_TYPE_PHONE:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contactUsVM.getPhone()));
                break;
            case REDIRECT_TYPE_FACEBOOK:
                url = "https://www.facebook.com/";
                break;
            case REDIRECT_TYPE_TWITTER:
                url = "https://twitter.com/";
                break;
            case REDIRECT_TYPE_INSTAGRAM:
                url = "https://www.instagram.com/";
                break;
        }
        if (!TextUtils.isEmpty(url)) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
        }
        if (intent.resolveActivity(this.getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void checkDataAndRequest() {
        if (TextUtils.isEmpty(name)) {
            etName.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        if (TextUtils.isEmpty(productHanding)) {
            etProductHanding.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }

        if (TextUtils.isEmpty(email) || !etEmail.isEmail()) {
            etEmail
                .setErrorMessage(getResources().getString(R.string.format_email_warning));
            return;
        }

        if (TextUtils.isEmpty(details)) {
            etDetail.setError(getResources().getString(R.string.empty_error));
            return;
        }
        mPresenter.contactMessageRequest(name, email, mobile, productHanding, details);
    }


}

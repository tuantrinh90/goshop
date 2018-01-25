package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomTitleDelEditText;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.ToastUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/8.
 */

public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements
    RegisterContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.cb_register_email)
    CheckBox cbRegisterEmail;

    @BindView(R.id.cb_register_sms)
    CheckBox cbRegisterSms;

    @BindView(R.id.ctd_et_register_confirmation_password)
    CustomTitleDelEditText ctdEtRegisterConfirmationPassword;

    @BindView(R.id.ctd_et_register_email)
    CustomTitleDelEditText ctdEtRegisterEmail;

    @BindView(R.id.ctd_et_register_firstname)
    CustomTitleDelEditText ctdEtRegisterFirstname;

    @BindView(R.id.ctd_et_register_lastname)
    CustomTitleDelEditText ctdEtRegisterLastname;

    @BindView(R.id.ctd_et_register_mobile)
    CustomTitleDelEditText ctdEtRegisterMobile;

    @BindView(R.id.ctd_et_register_password)
    CustomTitleDelEditText ctdEtRegisterPassword;

    @BindView(R.id.rb_register_female)
    RadioButton rbRegisterFemale;

    @BindView(R.id.rb_register_male)
    RadioButton rbRegisterMale;

    @BindView(R.id.tv_btn_register)
    CustomTextView tvBtnRegister;

    @BindView(R.id.tv_btn_register_login)
    CustomBoldTextView tvBtnRegisterLogin;

    @BindView(R.id.tv_register_date_of_birth)
    CustomTextView tvRegisterDateOfBirth;

    @BindView(R.id.tv_register_language)
    CustomTextView tvRegisterLanguage;

    @BindView(R.id.tv_register_read)
    CustomTextView tvRegisterRead;

    @BindView(R.id.tv_register_title)
    CustomTextView tvRegisterTitle;

    private ToastUtil toastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.register);
    }

    @Override
    public void inject() {
        initPresenter();
        initEditText();
        checkBoxActionListener();
        toastUtil = new ToastUtil(this, this);
        initRead();
    }

    //TODO(helen)hard code need decide
    private void initRead() {
        SpannableString spannableString = new SpannableString(
            getResources().getString(R.string.register_tips));
        spannableString.setSpan(new UnderlineSpan(), 69, 83, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString
            .setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_main_pink)), 69, 83, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 85, 105, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.MAGENTA), 85, 105, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 107, 120, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.MAGENTA), 107, 120, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        }, 69, 83, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(RegisterActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        },85, 105, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(RegisterActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        },107, 120, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvRegisterRead.setText(spannableString);
        tvRegisterRead.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initEditText() {
        ctdEtRegisterFirstname.initInputType(InputType.TYPE_CLASS_TEXT);
        ctdEtRegisterFirstname.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        ctdEtRegisterFirstname.focusListener(CustomTitleDelEditText.EDITTEXT_TEXT);
        ctdEtRegisterLastname.initInputType(InputType.TYPE_CLASS_TEXT);
        ctdEtRegisterLastname.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        ctdEtRegisterLastname.focusListener(CustomTitleDelEditText.EDITTEXT_TEXT);
        ctdEtRegisterEmail.initInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        ctdEtRegisterEmail.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        ctdEtRegisterEmail.focusListener(CustomTitleDelEditText.EDITTEXT_EMAIL);
        ctdEtRegisterMobile.initInputType(InputType.TYPE_CLASS_NUMBER);
        ctdEtRegisterMobile.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        ctdEtRegisterMobile.focusListener(CustomTitleDelEditText.EDITTEXT_NUMBER);
        ctdEtRegisterPassword.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        ctdEtRegisterPassword.focusListener(CustomTitleDelEditText.EDITTEXT_NUMBER);
        ctdEtRegisterConfirmationPassword.initImeOptions(EditorInfo.IME_ACTION_NEXT);
        ctdEtRegisterConfirmationPassword.focusListener(CustomTitleDelEditText.EDITTEXT_NUMBER);

    }

    private void checkBoxActionListener() {
        cbRegisterEmail.setOnCheckedChangeListener(
            (view, isChecked) -> EditTextUtil.eidtLoseFocus(cbRegisterEmail));
        cbRegisterSms.setOnCheckedChangeListener(
            (view, isChecked) -> EditTextUtil.eidtLoseFocus(cbRegisterSms));
    }

    @Override
    public void registerSuccess() {
        //TODO(helen)when register success
        showToast();
    }

    private void showToast() {
        toastUtil.showThanksToast();
    }

    @Override
    public void showNetwordErrorMessage() {
        //TODO(helen)when net error
    }

    @Override
    public void showFaildMessage(String errorMessage) {
        //TODO(helen)when register failed
    }

    @OnClick({R.id.tv_btn_register, R.id.tv_btn_register_login, R.id.imageview_left_menu, R.id
        .imageview_right_menu, R.id.tv_register_title, R.id.tv_register_language, R.id
        .tv_register_date_of_birth})
    public void onRegisterClick(View view) {
        switch (view.getId()) {
            case R.id.tv_btn_register:
                EditTextUtil.eidtLoseFocus(tvBtnRegister);
                //TODO(helen)wait for api
                //getInputDatas();
                mPresenter.registerRequest(null);
                break;
            case R.id.tv_btn_register_login:
                startLoginScreen();
                break;
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.imageview_right_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;

            case R.id.tv_register_title:
                break;
            case R.id.tv_register_language:
                break;
            case R.id.tv_register_date_of_birth:
                break;

        }
    }

    private void startLoginScreen() {
        //TODO(helen) it will completed when code merge
    }

    private void getInputDatas() {
        //TODO(helen)wait for api
        boolean isSendEmail = cbRegisterEmail.isChecked();
        boolean isSendSms = cbRegisterSms.isChecked();
    }

    @Override
    public void onToastCancel() {
        finish();
    }
}

package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.account.WebContentActivity;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.EncryptPasswordHandler;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PasswordEncoderUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ToastUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements
    RegisterContract.View, ToastUtil.OnToastListener, PopWindowUtil.OnPopWindowDismissListener,
    PopWindowUtil.OnDatePickerDialogClickListener, EncryptPasswordHandler
    .OnPasswordEncryptListener {

    public static final int MESSAGE_WHAT_ENCRYPTION = 0;

    public static final String TIP_TYPE_PRIVACY_POLICY = "Privacy Policy";

    public static final String TIP_TYPE_TERMS_AND_CONDITIONS = "Terms & Conditions";

    public static final String TIP_TYPE_TERMS_OF_USER = "Terms Of User";

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    @BindView(R.id.ctd_et_register_confirmation_password)
    CustomPasswordEditText etRegisterConfirmationPassword;

    @BindView(R.id.ctd_et_register_email)
    CustomAnimEditText etRegisterEmail;

    @BindView(R.id.ctd_et_register_name)
    CustomAnimEditText etRegisterName;

    @BindView(R.id.ctd_et_register_mobile)
    CustomAnimEditText etRegisterMobile;

    @BindView(R.id.ctd_et_register_password)
    CustomPasswordEditText etRegisterPassword;

    @BindView(R.id.iv_register_email)
    ImageView ivRegisterEmail;

    @BindView(R.id.iv_register_sms)
    ImageView ivRegisterSms;

    @BindView(R.id.iv_select_female)
    ImageView ivSelectFemale;

    @BindView(R.id.iv_select_male)
    ImageView ivSelectMale;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    @BindView(R.id.tv_btn_register_login)
    RobotoRegularTextView tvBtnRegisterLogin;

    @BindView(R.id.tv_register_date_of_birth)
    RobotoRegularTextView tvRegisterDateOfBirth;

    @BindView(R.id.tv_register_date_of_birth_warning)
    RobotoRegularTextView tvRegisterDateOfBirthWarning;

    @BindView(R.id.tv_register_language)
    RobotoRegularTextView tvRegisterLanguage;

    @BindView(R.id.tv_register_read)
    RobotoLightTextView tvRegisterRead;

    @BindView(R.id.tv_register_title)
    RobotoRegularTextView tvRegisterTitle;

    private String currentPopType = "";

    private List<ProfileMetaVM> languagesVMS;

    private List<ProfileMetaVM> titleVMS;

    private ToastUtil toastUtil;

    private String name;

    private String email;

    private String password;

    private String confirmPassword;

    private String title;

    private String mobile;

    private String birth;

    private String language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }

    private void initView() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        ivRegisterSms.setSelected(true);
        ivRegisterEmail.setSelected(true);
        ivSelectFemale.setSelected(true);
        tvRegisterDateOfBirthWarning.setVisibility(View.GONE);
    }

    private void initData() {
        toastUtil = new ToastUtil(this, this);
        languagesVMS = mPresenter.getLanguageChooses();
        titleVMS = mPresenter.getTitleChooses();
        initPrivacyPolicyAndTerms();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_register;
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
        return getResources().getString(R.string.register);
    }

    private void initPrivacyPolicyAndTerms() {
        String registerTips = getResources().getString(R.string.register_tips);
        String registerTips01 = getResources().getString(R.string.register_tips_privacy_policy);
        String registerTips02 = getResources()
            .getString(R.string.register_tips_terms_and_conditions);
        String registerTips03 = getResources().getString(R.string.register_tips_terms_of_user);
        int index01 = registerTips.indexOf(registerTips01);
        int index02 = registerTips.indexOf(registerTips02);
        int index03 = registerTips.indexOf(registerTips03);
        SpannableString spannableString = new SpannableString(registerTips);
        spannableStringFormat(spannableString, index01, registerTips01, TIP_TYPE_PRIVACY_POLICY);
        spannableStringFormat(spannableString, index02, registerTips02,
            TIP_TYPE_TERMS_AND_CONDITIONS);
        spannableStringFormat(spannableString, index03, registerTips03, TIP_TYPE_TERMS_OF_USER);
        tvRegisterRead.setText(spannableString);
        tvRegisterRead.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void spannableStringFormat(SpannableString spannableString, int startIndex,
        String text, String type) {
        spannableString.setSpan(new UnderlineSpan(), startIndex, startIndex + text.length(),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString
            .setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_main_pink)),
                startIndex, startIndex + text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                switch (type) {
                    case TIP_TYPE_PRIVACY_POLICY:
                        gotoInfoDetails(type);
                        break;
                    case TIP_TYPE_TERMS_AND_CONDITIONS:
                        gotoInfoDetails(type);
                        break;
                    case TIP_TYPE_TERMS_OF_USER:
                        gotoInfoDetails(type);
                        break;
                }
            }
        }, startIndex, startIndex + text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    //TODO  need decide
    private void gotoInfoDetails(String type) {
        Intent intent = new Intent(this, WebContentActivity.class);
        intent.putExtra(WebContentActivity.EXTRA_TYPE, type);
        intent.putExtra(WebContentActivity.EXTRA__TITLE, type);
        startActivity(intent);
    }

    @Override
    public void registerSuccess() {
        toastUtil.showThanksToast();
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(llContainer, errorMessage);
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(llContainer, errorMessage);
    }

    @OnClick({R.id.tv_btn_register_login, R.id.imageview_left_menu, R.id
        .textview_right_menu, R.id.tv_register_title, R.id.tv_register_language, R.id
        .tv_register_date_of_birth, R.id.ll_register_email, R.id.ll_register_sms, R.id
        .ll_select_male, R.id.ll_select_female})
    public void onRegisterClick(View view) {

        switch (view.getId()) {
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
            case R.id.textview_right_menu:
                KeyBoardUtils.hideKeyboard(this);
                name = etRegisterName.getText();
                email = etRegisterEmail.getText();
                password = etRegisterPassword.getText();
                confirmPassword = etRegisterConfirmationPassword.getText();
                title = tvRegisterTitle.getText().toString();
                mobile = etRegisterMobile.getText();
                birth = tvRegisterDateOfBirth.getText().toString();
                language = tvRegisterLanguage.getText().toString();
                judgmentRegister();
                break;
            case R.id.tv_register_title:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.TITLE_POP;
                PopWindowUtil.showSingleChoosePop(tvRegisterLanguage,
                    getResources().getString(R.string.choose_title), titleVMS, this);
                break;
            case R.id.tv_register_language:
                //todo please dont delete this, now it use default value
                /*EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.LANGUAGE_POP;
                PopWindowUtil.showSingleChoosePop(tvRegisterLanguage,
                    getResources().getString(R.string.choose_language), languagesVMS, this);*/
                break;
            case R.id.tv_register_date_of_birth:
                EditTextUtil.eidtLoseFocus(view);
                PopWindowUtil.showDatePickerDialog(tvRegisterDateOfBirth, this::onDatePicker);
                break;
            case R.id.ll_register_email:
                EditTextUtil.eidtLoseFocus(view);
                ivRegisterEmail.setSelected(!ivRegisterEmail.isSelected());
                break;
            case R.id.ll_register_sms:
                EditTextUtil.eidtLoseFocus(view);
                ivRegisterSms.setSelected(!ivRegisterSms.isSelected());
                break;
            case R.id.ll_select_female:
                EditTextUtil.eidtLoseFocus(view);
                ivSelectFemale.setSelected(true);
                if (ivSelectMale.isSelected()) {
                    ivSelectMale.setSelected(false);
                }
                break;
            case R.id.ll_select_male:
                EditTextUtil.eidtLoseFocus(view);
                ivSelectMale.setSelected(true);
                if (ivSelectFemale.isSelected()) {
                    ivSelectFemale.setSelected(false);
                }
                break;
        }
    }

    private void startLoginScreen() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void judgmentRegister() {
        if (TextUtils.isEmpty(name)) {
            etRegisterName.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }

        if (TextUtils.isEmpty(email) || !etRegisterEmail.isEmail()) {
            etRegisterEmail
                .setErrorMessage(getResources().getString(R.string.format_email_warning));
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etRegisterPassword.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            etRegisterConfirmationPassword
                .setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }

        if (!password.equals(confirmPassword)) {
            etRegisterConfirmationPassword
                .setErrorMessage(getResources().getString(R.string.confirm_warning));
            return;
        }
        if (TextUtils.isEmpty(mobile) || !etRegisterMobile.isMobileNo()) {
            etRegisterMobile
                .setErrorMessage(getResources().getString(R.string.format_mobile_warning));
            return;
        }
        if (TextUtils.isEmpty(birth)) {
            tvRegisterDateOfBirthWarning.setVisibility(View.VISIBLE);
            return;
        } else {
            tvRegisterDateOfBirthWarning.setVisibility(View.GONE);
        }
        showLoadingBar();
        PasswordEncoderUtil.getEncryptPassword(new EncryptPasswordHandler(this), password);
    }

    @Override
    public void onPasswordEncrypted(String password) {
        this.password = password;
        registerRequest();
    }

    private void registerRequest() {
        String gender = ivSelectMale.isSelected() ? "1" : "2";
        boolean isRegisterEmail = ivRegisterEmail.isSelected();
        boolean isRegisterSms = ivRegisterSms.isSelected();
        mPresenter
            .registerRequest(name, email, password, title, gender, birth,
                mobile, language, isRegisterEmail, isRegisterSms);
    }

    @Override
    public void onToastCancel() {
        finish();
    }

    @Override
    public void onPopItemClick(int position) {
        if (!TextUtils.isEmpty(currentPopType)) {
            switch (currentPopType) {
                case PopWindowUtil.LANGUAGE_POP:
                    languagesVMS = PopWindowUtil.updateSinglePopDatas(position, languagesVMS);
                    tvRegisterLanguage
                        .setText(languagesVMS.get(position).getValue());
                    break;
                case PopWindowUtil.TITLE_POP:
                    titleVMS = PopWindowUtil.updateSinglePopDatas(position, titleVMS);
                    tvRegisterTitle.setText(titleVMS.get(position).getValue());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //don't need to implement it yet.
    }

    @Override
    public void onDatePicker(String time) {
        tvRegisterDateOfBirth.setText(time);
        tvRegisterDateOfBirthWarning.setVisibility(View.GONE);
    }
}

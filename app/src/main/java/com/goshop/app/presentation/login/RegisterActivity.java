package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.widget.SingleChooseVM;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ToastUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements
    RegisterContract.View, ToastUtil.OnToastListener, PopWindowUtil.OnPopWindowDismissListener,
    PopWindowUtil.OnDatePickerDialogClickListener {

    @BindView(R.id.ctd_et_register_confirmation_password)
    CustomPasswordEditText etRegisterConfirmationPassword;

    @BindView(R.id.ctd_et_register_email)
    CustomAnimEditText etRegisterEmail;

    @BindView(R.id.ctd_et_register_firstname)
    CustomAnimEditText etRegisterFirstname;

    @BindView(R.id.ctd_et_register_lastname)
    CustomAnimEditText etRegisterLastname;

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

    private List<SingleChooseVM> languagesVMS;

    private List<SingleChooseVM> titleVMS;

    private ToastUtil toastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        languagesVMS = mPresenter.getLanguageChooses();
        titleVMS = mPresenter.getTitleChooses();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    public void inject() {
        textviewRightMenu.setText(getResources().getString(R.string.done));
        ivRegisterSms.setSelected(true);
        ivRegisterEmail.setSelected(true);
        ivSelectFemale.setSelected(true);
        tvRegisterDateOfBirthWarning.setVisibility(View.GONE);
        initPresenter();
        toastUtil = new ToastUtil(this, this);
        initRead();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.register);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    //TODO(helen)hard code need decide
    private void initRead() {
        SpannableString spannableString = new SpannableString(
            getResources().getString(R.string.register_tips));
        spannableString.setSpan(new UnderlineSpan(), 69, 83, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString
            .setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_main_pink)), 69,
                83, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 85, 105, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.MAGENTA), 85, 105,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 107, 120, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.MAGENTA), 107, 120,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

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
        }, 85, 105, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(RegisterActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        }, 107, 120, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvRegisterRead.setText(spannableString);
        tvRegisterRead.setMovementMethod(LinkMovementMethod.getInstance());
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
        //TODO wait for design
        Log.d("RegisterActivity", errorMessage);
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
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
                String firstName = etRegisterFirstname.getText();
                String lastName = etRegisterLastname.getText();
                String email = etRegisterEmail.getText();
                String password = etRegisterPassword.getText();
                String confirmPassword = etRegisterConfirmationPassword.getText();
                String title = tvRegisterTitle.getText().toString();
                String mobile = etRegisterMobile.getText();
                String birth = tvRegisterDateOfBirth.getText().toString();
                String language = tvRegisterLanguage.getText().toString();
                judgmentRegister(firstName, lastName, email, password, confirmPassword, title,
                    mobile, birth, language, ivRegisterEmail.isSelected(),
                    ivRegisterSms.isSelected());
                break;
            case R.id.tv_register_title:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.TITLE_POP;
                PopWindowUtil.showSingleChoosePop(tvRegisterLanguage,
                    getResources().getString(R.string.choose_title), titleVMS, this);
                break;
            case R.id.tv_register_language:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.LANGUAGE_POP;
                PopWindowUtil.showSingleChoosePop(tvRegisterLanguage,
                    getResources().getString(R.string.choose_language), languagesVMS, this);
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
    }

    private void judgmentRegister(String firstName, String lastName, String email, String password,
        String confirmPassword, String chooseTitle, String mobile, String birth,
        String language, boolean sendEmail, boolean sendSMS) {
        if (TextUtils.isEmpty(firstName)) {
            etRegisterFirstname.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            etRegisterLastname.setErrorMessage(getResources().getString(R.string.empty_error));
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
        String gender = ivSelectMale.isSelected() ? "1" : "2";
        mPresenter
            .registerRequest(firstName + lastName, email, password, chooseTitle, gender, birth,
                mobile, language, sendEmail, sendSMS);
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
                        .setText(languagesVMS.get(position).getContent());
                    break;
                case PopWindowUtil.TITLE_POP:
                    titleVMS = PopWindowUtil.updateSinglePopDatas(position, titleVMS);
                    tvRegisterTitle.setText(titleVMS.get(position).getContent());
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {

    }

    @Override
    public void onDatePicker(String time) {
        tvRegisterDateOfBirth.setText(time);
        tvRegisterDateOfBirthWarning.setVisibility(View.GONE);
    }
}

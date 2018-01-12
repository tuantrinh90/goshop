package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    @BindView(R.id.et_register_email)
    CustomEditText etRegisterEmail;

    @BindView(R.id.et_register_first_name)
    CustomEditText etRegisterFirstName;

    @BindView(R.id.et_register_last_name)
    CustomEditText etRegisterLastName;

    @BindView(R.id.et_register_mobile_number)
    CustomEditText etRegisterMobileNumber;

    @BindView(R.id.et_register_password)
    CustomEditText etRegisterPassword;

    @BindView(R.id.iv_first_name_delete)
    ImageView ivFirstNameDelete;

    @BindView(R.id.iv_last_name_delete)
    ImageView ivLastNameDelete;

    @BindView(R.id.iv_register_email_delete)
    ImageView ivRegisterEmailDelete;

    @BindView(R.id.iv_register_eye)
    ImageView ivRegisterEye;

    @BindView(R.id.iv_register_mobile_delete)
    ImageView ivRegisterMobileDelete;

    @BindView(R.id.iv_register_pwd_delete)
    ImageView ivRegisterPwdDelete;

    @BindView(R.id.ll_register_login)
    LinearLayout llRegisterLogin;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_btn_register)
    CustomTextView tvBtnRegister;

    @BindView(R.id.tv_register_email)
    CustomTextView tvRegisterEmail;

    @BindView(R.id.tv_register_first_name)
    CustomTextView tvRegisterFirstName;

    @BindView(R.id.tv_register_last_name)
    CustomTextView tvRegisterLastName;

    @BindView(R.id.tv_register_mobile)
    CustomTextView tvRegisterMobile;

    @BindView(R.id.tv_register_pwd)
    CustomTextView tvRegisterPwd;

    private boolean isMask = true;

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
        //TODO(helen):this is wait for design
        toolbar.setBackgroundColor(getResources().getColor(R.color.pinkishGrey));
        initPresenter();
        editActionListener();
        checkBoxActionListener();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void editActionListener() {
        EditTextUtil.deleteImageShowListener(etRegisterFirstName, ivFirstNameDelete);
        EditTextUtil.deleteImageShowListener(etRegisterLastName, ivLastNameDelete);
        EditTextUtil.deleteImageShowListener(etRegisterEmail, ivRegisterEmailDelete);
        EditTextUtil.deleteImageShowListener(etRegisterPassword, ivRegisterPwdDelete);
        EditTextUtil.deleteImageShowListener(etRegisterMobileNumber, ivRegisterMobileDelete);

        EditTextUtil.foucsChangedListener(etRegisterFirstName, tvRegisterFirstName);
        EditTextUtil.foucsChangedListener(etRegisterLastName, tvRegisterLastName);
        EditTextUtil.emailFoucsChangedListener(etRegisterEmail, tvRegisterEmail);
        EditTextUtil.passwordFoucsChangedListener(etRegisterPassword, tvRegisterPwd);
        EditTextUtil.mobileFoucsChangedListener(etRegisterMobileNumber, tvRegisterMobile);
    }

    private void checkBoxActionListener() {
        cbRegisterEmail.setOnCheckedChangeListener((view, isChecked) -> {
            EditTextUtil.eidtLoseFocus(cbRegisterEmail);
        });
        cbRegisterSms.setOnCheckedChangeListener((view, isChecked) -> {
            EditTextUtil.eidtLoseFocus(cbRegisterSms);
        });
    }

    @Override
    public void registerSuccess() {
        //TODO(helen)when register success
        showToast();
    }

    private void showToast() {
        //todo(helen) wait for design then will replase this hard code
        Toast toast = Toast.makeText(this, "Thanks for registering on GO SHOP", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toastUtil = ToastUtil.getInstance(this, this, toast);
        toastUtil.showToastCustomTime(ToastUtil.SHOW_TIME);
    }

    @Override
    public void showNetwordErrorMessage() {
        //TODO(helen)when net error
    }

    @Override
    public void showFaildMessage(String errorMessage) {
        //TODO(helen)when register failed
    }

    @OnClick({R.id.tv_btn_register, R.id.ll_register_login, R.id.imageview_left_menu, R.id
        .imageview_right_menu, R.id.iv_register_eye})
    public void onRegisterClick(View view) {
        switch (view.getId()) {
            case R.id.tv_btn_register:
                EditTextUtil.eidtLoseFocus(tvBtnRegister);
                //TODO(helen)wait for api
                //getInputDatas();
                //mPresenter.registerRequest(null);
                break;
            case R.id.ll_register_login:
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
            case R.id.iv_register_eye:
                isMask = !isMask;
                if (isMask) {
                    etRegisterPassword.setInputType(
                        InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    etRegisterPassword.setText(etRegisterPassword.getText().toString());
                } else {
                    etRegisterPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    etRegisterPassword.setText(etRegisterPassword.getText().toString());
                }
                etRegisterPassword.setSelection(etRegisterPassword.getText().length());

                break;
        }
    }

    private void startLoginScreen() {
        //TODO(helen) it will completed when code merge
    }

    private void getInputDatas() {
        //TODO(helen)wait for api
        String firstName = etRegisterFirstName.getText().toString();
        String lastName = etRegisterLastName.getText().toString();
        String email = etRegisterEmail.getText().toString();
        String password = etRegisterPassword.getText().toString();
        String mobileNo = etRegisterMobileNumber.getText().toString();
        boolean isSendEmail = cbRegisterEmail.isChecked();
        boolean isSendSms = cbRegisterSms.isChecked();
    }

    @Override
    public void onToastCancel() {
        finish();
    }
}

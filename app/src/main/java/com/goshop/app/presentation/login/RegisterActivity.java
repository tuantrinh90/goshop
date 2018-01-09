package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
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

    @BindView(R.id.ll_register_login)
    LinearLayout llRegisterLogin;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_btn_register)
    CustomTextView tvBtnRegister;

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
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void registerSuccess() {
        //TODO(helen)when register success
        showToast();
    }

    private void showToast() {
        Toast toast = Toast.makeText(this, "Thanks for registering on GO SHOP", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toastUtil = ToastUtil.getInstance(this, this, toast);
        toastUtil.showToastCustomTime(5000);
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
                KeyBoardUtils.hideKeyboard(this);
                //TODO(helen)wait for api
                getInputDatas();
                mPresenter.registerRequest(null);
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

    private void startLoginScreen() {
        //TODO(helen) it will completed when code merge
    }

    @Override
    public void onToastCancel() {
        finish();
    }
}

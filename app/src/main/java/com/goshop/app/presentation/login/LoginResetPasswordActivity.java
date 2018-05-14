package com.goshop.app.presentation.login;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginResetPasswordActivity extends BaseActivity<LoginResetPasswordContract
    .Presenter> implements LoginResetPasswordContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.ctd_et_reset_pwd)
    CustomAnimEditText ctdEtResetPwd;

    @BindView(R.id.tv_btn_reset_password_submit)
    RobotoMediumTextView tvBtnResetPasswordSubmit;

    private ToastUtil toastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        hideRightMenu();
        toastUtil = new ToastUtil(this, this);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login_reset_password;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.reset_password);
    }

    @Override
    public void resetPwdSuccess() {
        tvBtnResetPasswordSubmit.setClickable(true);
        showToast();
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        tvBtnResetPasswordSubmit.setClickable(true);
        PopWindowUtil.showRequestMessagePop(tvBtnResetPasswordSubmit, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        tvBtnResetPasswordSubmit.setClickable(true);
        PopWindowUtil.showRequestMessagePop(tvBtnResetPasswordSubmit, errorMessage);
    }

    private void showToast() {
        toastUtil.showResetToast();
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_reset_password_submit})
    public void onResetPwdClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.tv_btn_reset_password_submit:
                EditTextUtil.eidtLoseFocus(tvBtnResetPasswordSubmit);
                String email = ctdEtResetPwd.getText();
                if (!TextUtils.isEmpty(email) && ctdEtResetPwd.isEmail()) {
                    mPresenter.resetPasswordRequest(email);
                    tvBtnResetPasswordSubmit.setClickable(false);
                } else {
                    ctdEtResetPwd
                        .setErrorMessage(getResources().getString(R.string.format_email_warning));
                }

                break;
        }
    }

    @Override
    public void onToastCancel() {
        finish();
    }
}

package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/9.
 */

public class LoginResetPasswordActivity extends BaseActivity<LoginResetPasswordContract
    .Presenter> implements LoginResetPasswordContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.ctd_et_reset_pwd)
    CustomAnimEditText ctdEtResetPwd;

    @BindView(R.id.tv_btn_reset_password_submit)
    CustomBoldTextView tvBtnResetPasswordSubmit;

    private ToastUtil toastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login_reset_password;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.reset_password);
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initEditText();
        toastUtil = new ToastUtil(this, this);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initEditText() {
        ctdEtResetPwd.initInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        ctdEtResetPwd.initImeOptions(EditorInfo.IME_ACTION_DONE);
    }

    @Override
    public void resetPwdSuccess() {
        //TODO(helen)wait for api
        showToast();
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
                //TODO(helen)wait for api
                EditTextUtil.eidtLoseFocus(tvBtnResetPasswordSubmit);
                String email = ctdEtResetPwd.getText();
                if (!TextUtils.isEmpty(email)) {
                    mPresenter.resetPasswordRequest(null);
                }

                break;
        }
    }

    @Override
    public void onToastCancel() {
        finish();
    }
}

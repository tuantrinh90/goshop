package com.goshop.app.presentation.login;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldButton;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.ToastUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/9.
 */

public class LoginResetPasswordActivity extends BaseActivity<LoginResetPasswordContract
    .Presenter> implements LoginResetPasswordContract.View, ToastUtil.OnToastListener {

    @BindView(R.id.btn_reset_password_submit)
    CustomBoldButton btnResetPasswordSubmit;

    @BindView(R.id.et_reset_password_email)
    CustomEditText etResetPasswordEmail;

    @BindView(R.id.iv_reset_password_delete)
    ImageView ivResetPasswordDelete;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_reset_password_email)
    CustomTextView tvResetPasswordEmail;

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
        //TODO(helen):this is wait for design
        toolbar.setBackgroundColor(getResources().getColor(R.color.pinkishGrey));
        hideRightMenu();
        initPresenter();
        editActionListener();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void editActionListener() {
        EditTextUtil.deleteImageShowListener(etResetPasswordEmail, ivResetPasswordDelete);
        EditTextUtil.emailFoucsChangedListener(etResetPasswordEmail, tvResetPasswordEmail);
    }

    @Override
    public void resetPwdSuccess() {
        //TODO(helen)wait for api
        showToast();
    }

    private void showToast() {
        Toast toast = Toast.makeText(this, "Thanks for registering on GO SHOP", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toastUtil = ToastUtil.getInstance(this, this, toast);
        toastUtil.showToastCustomTime(3000);
    }

    @OnClick({R.id.imageview_left_menu, R.id.btn_reset_password_submit})
    public void onResetPwdClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                KeyBoardUtils.hideKeyboard(this);
                if (toastUtil != null) {
                    toastUtil.cancelToast();
                }
                finish();
                break;
            case R.id.btn_reset_password_submit:
                //TODO(helen)wait for api
                EditTextUtil.eidtLoseFocus(btnResetPasswordSubmit);
                String email = etResetPasswordEmail.getText().toString();
                //mPresenter.resetPasswordRequest(null);
                break;
        }
    }

    @Override
    public void onToastCancel() {
        finish();
    }
}

package com.goshop.app.presentation.login;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.utils.ScreenHelper;
import com.orhanobut.logger.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract
    .View {

    @BindView(R.id.et_login_email)
    CustomAnimEditText etLoginEmail;

    @BindView(R.id.et_login_password)
    CustomPasswordEditText etLoginPassword;

    @BindView(R.id.iv_login_logo)
    ImageView ivLoginLogo;

    @BindView(R.id.ll_login_top)
    LinearLayout llLoginTop;

    @BindView(R.id.tv_btn_login)
    RobotoMediumTextView tvBtnLogin;

    @BindView(R.id.tv_btn_login_facebook)
    RobotoMediumTextView tvBtnLoginFacebook;

    @BindView(R.id.tv_login_forgot_password)
    RobotoLightTextView tvLoginForgotPassword;

    @BindView(R.id.tv_register)
    RobotoRegularTextView tvRegister;

    private CallbackManager facebookCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        facebookCallbackManager = mPresenter.initFaceBook();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void inject() {
        hideRightMenu();
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.login);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_login, R.id.tv_login_forgot_password, R.id
        .tv_btn_login_facebook, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_login:
                break;
            case R.id.tv_login_forgot_password:
                startActivity(new Intent(this, ChangePasswordActivity.class));
                break;
            case R.id.tv_btn_login_facebook:
                //facebook sdk code
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays
                    .asList("public_profile", "email", "user_friends"));
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    @Override
    public void showLogin(UserInfo userInfo) {
        //TODO joyson temp code
        Logger.e("resposne:" + userInfo.getUsername());
    }

    @Override
    public void showNetwordErrorMessage() {

    }

    @Override
    public void showFaildMessage(String errorMessage) {

    }

    @Override
    public void fbLoginError() {
        Toast.makeText(this, ScreenHelper.getString(R.string.FB_Login_tips_error),
            Toast.LENGTH_SHORT).show();
    }
}

package com.goshop.app.presentation.login;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.FacebookLoginVm;
import com.goshop.app.utils.EncryptPasswordHandler;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PasswordEncoderUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.ScreenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class LoginActivity extends BaseDrawerActivity<LoginContract.Presenter> implements
    LoginContract.View, EncryptPasswordHandler.OnPasswordEncryptListener {

    public static final String EXTRA_REDIRECT_TYPE = "redirect_type";

    @BindView(R.id.rl_container)
    RelativeLayout rlContainer;

    @BindView(R.id.et_login_email)
    CustomAnimEditText etLoginEmail;

    @BindView(R.id.et_login_password)
    CustomPasswordEditText etLoginPassword;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.iv_login_logo)
    ImageView ivLoginLogo;

    @BindView(R.id.ll_login_top)
    LinearLayout llLoginTop;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_btn_login)
    RobotoMediumTextView tvBtnLogin;

    @BindView(R.id.tv_btn_login_facebook)
    RobotoMediumTextView tvBtnLoginFacebook;

    @BindView(R.id.tv_login_forgot_password)
    RobotoLightTextView tvLoginForgotPassword;

    @BindView(R.id.tv_register)
    RobotoRegularTextView tvRegister;

    @BindView(R.id.login_button)
    LoginButton loginButton;

    private CallbackManager callbackManager;

    private String email;

    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_HEAD_LOGIN);
        setContentView(getContentView());
        initData();
        initToolbar();
    }

    private void initData() {
        callbackManager = mPresenter.initFaceBook();
        loginButton.setReadPermissions(Arrays.asList("public_profile", "user_friends", "email"));
    }

    private void initToolbar() {
        hideRightMenu();
        imageViewLeftMenu.setImageResource(R.drawable.ic_menu);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login;
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
        return getResources().getString(R.string.login);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //todo need decide
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_login, R.id.tv_login_forgot_password, R.id
        .tv_btn_login_facebook, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                openDrawerLayout();
                break;
            case R.id.tv_btn_login:
                emailLogin();
                break;
            case R.id.tv_login_forgot_password:
                startActivity(new Intent(this, LoginResetPasswordActivity.class));
                break;
            case R.id.tv_btn_login_facebook:
                //todo do not delete please,this maybe use later
                //facebook sdk code
//                LoginManager.getInstance().logInWithReadPermissions(this, Arrays
//                    .asList("public_profile", "user_friends", "email"));
                // TODO: 2018/4/12  you can use this method generate HashKey for facebook
//                JToolUtils.generateHashKey(this);
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    private void emailLogin() {
        if (TextUtils.isEmpty(etLoginEmail.getText()) || !etLoginEmail.isEmail()) {
            etLoginEmail
                .setErrorMessage(getResources().getString(R.string.format_email_warning));
            return;
        }
        if (TextUtils.isEmpty(etLoginPassword.getText())) {
            etLoginPassword.setErrorMessage(getResources().getString(R.string.empty_error));
            return;
        }
        email = etLoginEmail.getText();
        password = etLoginPassword.getText();
        showLoadingBar();
        PasswordEncoderUtil.getEncryptPassword(new EncryptPasswordHandler(this), password);
    }

    @Override
    public void onPasswordEncrypted(String password) {
        this.password = password;
        loginRequest();
    }

    private void loginRequest() {
        mPresenter.loginRequest(email, password);
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rlContainer, errorMessage);
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rlContainer, errorMessage);
    }

    @Override
    public void fbLoginError() {
        Toast.makeText(this, ScreenHelper.getString(R.string.FB_Login_tips_error),
            Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(Response<LoginResponse> response) {
        if (response != null && response.getData() != null && response.getData()
            .getCustomer() != null && response.getData().getCustomer().getToken() != null) {
            GoShopApplication.cacheUserInfo(response.getData().getCustomer());
            goToHomePage();
        }
    }

    private void goToHomePage() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setFacebookLoginParams(FacebookLoginVm facebookVm) {
        Intent intent = new Intent(this, LoginComplementEmailActivity.class);
        intent.putExtra(LoginComplementEmailActivity.EXTRA_FACEBOOK_INFO, facebookVm);
        startActivity(intent);
        this.finish();
    }

}

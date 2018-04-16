package com.goshop.app.presentation.login;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.CustomPasswordEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.FacebookLoginVm;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PasswordEncoderUtil;
import com.goshop.app.utils.ScreenHelper;
import com.orhanobut.logger.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class LoginActivity extends BaseDrawerActivity<LoginContract.Presenter> implements
    LoginContract.View {

    public static final int MESSAGE_WHAT_ENCRYPTION = 0;

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
    //todo do not delete please,this maybe use later
   /* @BindView(R.id.login_button)
    LoginButton loginButton;*/

    private CallbackManager callbackManager;

    private EncryptPasswordHandler encryptPasswordHandler;

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
        encryptPasswordHandler = new EncryptPasswordHandler(this);
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
        //todo do not delete please,this maybe use later
        /*loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));*/
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
                showLoadingBar();
                emailLogin();
                break;
            case R.id.tv_login_forgot_password:
                startActivity(new Intent(this, LoginResetPasswordActivity.class));
                break;
            case R.id.tv_btn_login_facebook:
                //facebook sdk code
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays
                    .asList("public_profile", "user_friends", "email"));

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
        new Thread(() -> {
            String result = PasswordEncoderUtil.encryptPasswordWithSHA256Salt(password);
            Message msg = new Message();
            msg.obj = result;
            msg.what = MESSAGE_WHAT_ENCRYPTION;
            encryptPasswordHandler.sendMessage(msg);
        }).start();
    }

    private void registerLogin() {
        mPresenter.loginRequest(email, password);
    }

    private static class EncryptPasswordHandler extends Handler {

        private WeakReference<LoginActivity> activity;

        private EncryptPasswordHandler(LoginActivity startActivity) {
            activity = new WeakReference<LoginActivity>(startActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (activity.get() == null) {
                return;
            }
            if (MESSAGE_WHAT_ENCRYPTION == msg.what) {
                activity.get().password = (String) msg.obj;
                activity.get().registerLogin();
            }
        }
    }

    @Override
    public void showLogin(UserInfo userInfo) {
        //TODO joyson temp code
        Logger.e("resposne:" + userInfo.getUsername());
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {

    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        //TODO wait for design
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
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
            GoShopApplication.setLogin(true);
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
        intent.putExtra(LoginComplementEmailActivity.EXTRA_FACEBOOK_INFO,facebookVm);
        startActivity(intent);
//        mPresenter.facebookLoginRequest(email, fbId, token, name, gender);
    }


}

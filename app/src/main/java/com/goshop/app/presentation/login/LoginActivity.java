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
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.ScreenHelper;
import com.goshop.app.widget.adapter.MenuAdapter;
import com.orhanobut.logger.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract
    .View, MenuAdapter.OnSlideMenuItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

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

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

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

    //todo need decide
    private CallbackManager callbackManager;

    private int currentMenu;

    private boolean isLogin = false;

    private MenuAdapter menuAdapter;

    private String menuTag;

    private MenuUtil menuUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = mPresenter.initFaceBook();
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initMenuUtil();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        menuTag = getIntent().getStringExtra(MenuUtil.MENU_KEY);
        if (menuTag == null) {
            menuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(MenuUtil.MENU_VALUE)) {
                menuUtil.liftedDrawerLayout();
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                toolbar.setNavigationOnClickListener(v -> {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                    drawerLayout.openDrawer(Gravity.LEFT);
                });
            }
        }

        initMenuRecyclerview();

    }

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this, isLogin, drawerLayout);
    }

    private void initMenuRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);
        menuAdapter = new MenuAdapter(
            isLogin ? menuUtil.getLoginMenuModel() : menuUtil.getUnLoginMenuModel());
        recyclerViewMenu.setAdapter(menuAdapter);
        currentMenu = MenuUtil.UNLOGIN_LOGIN;
        menuAdapter.updateSelection(currentMenu);
        menuAdapter.setOnSlideMenuItemClickListener(this);
        menuAdapter.updateLoginState(isLogin);
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
    public void onHeaderUserClick(int position) {
        //todo this is empty
    }

    @Override
    public void onHeaderLoginClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }

    @Override
    public void onItemClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
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
                finish();
                break;
            case R.id.tv_btn_login:
                if (TextUtils.isEmpty(etLoginEmail.getText()) || !etLoginEmail.isEmail()) {
                    etLoginEmail
                        .setErrorMessage(getResources().getString(R.string.format_email_warning));
                    return;
                }
                if (TextUtils.isEmpty(etLoginPassword.getText())) {
                    etLoginPassword.setErrorMessage(getResources().getString(R.string.empty_error));
                    return;
                }
                Map<String, Object> params = new HashMap<>();
                params.put("website_id", "");
                params.put("store_id", "");
                params.put("email", etLoginEmail.getText());
                params.put("password", etLoginPassword.getText());
                mPresenter.loginRequest(params);
                break;
            case R.id.tv_login_forgot_password:
                startActivity(new Intent(this, ChangePasswordActivity.class));
                break;
            case R.id.tv_btn_login_facebook:
                //facebook sdk code
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays
                    .asList("public_profile", "user_friends", "email"));

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
        //TODO wait for design
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void fbLoginError() {
        Toast.makeText(this, ScreenHelper.getString(R.string.FB_Login_tips_error),
            Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, MainPageActivity.class));
        finish();
    }

    @Override
    public void setFacebookLoginParams(String email, String fbId, String token, String name,
        String gender) {
        Map<String, Object> params = new HashMap<>();
        params.put("website_id", "");
        params.put("store_id", "");
        params.put("email", email);
        params.put("fb_id", fbId);
        params.put("user_access_token", token);
        params.put("name", name);
        params.put("gender", gender);
        mPresenter.facebookLoginRequest(params);
    }


}

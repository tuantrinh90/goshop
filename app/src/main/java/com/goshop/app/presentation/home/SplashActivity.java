package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.utils.UserHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class SplashActivity extends BaseActivity<SplashContract.Presenter> implements
    SplashContract.View {

    public static final String NEXT_PAGE_TYPE_HOME = "home";

    public static final String NEXT_PAGE_TYPE_HOME_UN_LOGIN = "homeUnLogin";

    public static final String NEXT_PAGE_TYPE_LOGIN = "login";

    private String nextPageType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getUserInfo();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_splash;
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
        return null;
    }

    public void onDelayFinished() {
        switch (nextPageType) {
            case NEXT_PAGE_TYPE_HOME:
                goToHomePage();
                break;
            case NEXT_PAGE_TYPE_HOME_UN_LOGIN:
                goToHomePage();
                break;
            case NEXT_PAGE_TYPE_LOGIN:
                goToLoginPage();
                break;
        }
    }

    private void goToHomePage() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void checkLoginSuccess(UserData userData) {
        if (UserHelper.checkUserData(userData)) {
            nextPageType = NEXT_PAGE_TYPE_HOME;
            GoShopApplication.cacheUserInfo(userData);
        } else {
            nextPageType = NEXT_PAGE_TYPE_HOME_UN_LOGIN;
        }
        mPresenter.delayToJump();
    }

}

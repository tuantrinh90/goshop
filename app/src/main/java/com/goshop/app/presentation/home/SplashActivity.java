package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.presentation.model.UserDataVM;
import com.goshop.app.utils.UserHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class SplashActivity extends BaseActivity<SplashContract.Presenter> implements
    SplashContract.View {

    public static final int REQUEST_SUCCESS = 0;

    public static final int REQUEST_FAILURE = 1;

    public static final String NEXT_PAGE_TYPE_HOME = "home";

    public static final String NEXT_PAGE_TYPE_HOME_UN_LOGIN = "homeUnLogin";

    public static final String NEXT_PAGE_TYPE_LOGIN = "login";

    public static final int DELAY_TIME = 3000;

    private String nextPageType;

    private StartHandler mStartHandler;

    private StartRunnable mStartRunnable;

    private long mStartTimeLong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getLocalUserInfo();
        mStartHandler = new StartHandler(this);
        mStartTimeLong = System.currentTimeMillis();
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
    public void getLocalUserInfoSuccess(UserDataVM userData) {
        if (UserHelper.isLogin(userData)) {
            nextPageType = NEXT_PAGE_TYPE_HOME;
            mPresenter.getUserProfile();
        } else {
            nextPageType = NEXT_PAGE_TYPE_HOME;
            mPresenter.delayToJump();
        }
    }

    @Override
    public void getUserProfileSuccess(UserDataVM userDataVM) {
        mPresenter.updateUserInfo(userDataVM);
    }

    @Override
    public void showErrorMessage(String message) {
        mPresenter.delayToJump();
    }

    private static class StartHandler extends Handler {

        private WeakReference<SplashActivity> activity;

        private StartHandler(SplashActivity startActivity) {
            activity = new WeakReference<SplashActivity>(startActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (activity.get() == null) {
                return;
            }
            long deploy = System.currentTimeMillis() - activity.get().mStartTimeLong;
            if (deploy < DELAY_TIME) {
                activity.get().postDelayed(deploy);
            } else {
                activity.get().postHandler(msg.what, null);
            }
            super.handleMessage(msg);
        }
    }

    private void postDelayed(long deploy) {
        mStartRunnable = new StartRunnable(SplashActivity.this);
        mStartHandler.postDelayed(mStartRunnable, (DELAY_TIME - deploy));
    }

    private static class StartRunnable implements Runnable {

        WeakReference<SplashActivity> mActivity;

        public StartRunnable(SplashActivity start) {
            mActivity = new WeakReference<>(start);
        }

        @Override
        public void run() {
            if (mActivity.get() == null) return;

        }
    }

    public void postHandler(int code, Object obj) {
        if (mStartHandler != null) {
            Message msg = new Message();
            if (obj != null) {
                msg.obj = obj;
            }
            msg.what = code;
            mStartHandler.sendMessage(msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStartHandler.removeCallbacks(mStartRunnable);
    }
}

package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.login.LoginActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class SplashActivity extends BaseActivity<SplashContract.Presenter> implements
    SplashContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.delayToJump();
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

    public void onDelaySuccess() {
        goToSearchPage();
    }

    private void goToSearchPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

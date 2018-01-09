package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldButton;
import com.goshop.app.data.model.Weather;
import com.goshop.app.presentation.account.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class HomeActivity extends BaseActivity<HomeContract.Presenter> implements HomeContract
    .View {

    @BindView(R.id.tv_c)
    CustomBoldButton tvC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showWeather(Weather weather) {
        Toast.makeText(this, "wather:" + weather.getTemp1(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetwordErrorMessage() {
        Toast.makeText(this, "netword error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFaildMessage(String errorMessage) {
        Toast.makeText(this, "" + errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void inject() {
        //init Presenter  use Dagger
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @OnClick({R.id.tv_c, R.id.btn_click_login, R.id.tv_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_c:
                mPresenter.getWeather();
                break;
            case R.id.btn_click_login:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                break;
            case R.id.tv_text:
                break;
        }
    }
}

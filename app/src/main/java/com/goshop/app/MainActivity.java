package com.goshop.app;

import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldButton;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.data.model.Weather;
import com.goshop.app.presentation.home.DemoContract;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements DemoContract.View {

    @BindView(R.id.tv_c)
    CustomBoldButton tvC;
    @BindView(R.id.tv_text)
    CustomBoldTextView tvText;

    @Override
    public void showWeather(Weather weather) {

    }

    @Override
    public void showNetwordErrorMessage() {

    }

    @Override
    public void showFaildMessage(String errorMessage) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void inject() {
        //init Presenter  use Dagger
    }

    @Override
    public int getContentView() {
        return R.layout.activity_demo;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @OnClick(R.id.tv_c)
    public void onClick() {
    }
}

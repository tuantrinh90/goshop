package com.goshop.app.presentation.settings;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.utils.MenuUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class SettingsActivity extends BaseDrawerActivity<SettingsContract.Presenter> implements
    SettingsContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.switch_setting_email)
    Switch switchSettingEmail;

    @BindView(R.id.switch_setting_market)
    Switch switchSettingMarket;

    @BindView(R.id.switch_setting_notification)
    Switch switchSettingNotification;

    @BindView(R.id.switch_setting_sms)
    Switch switchSettingSms;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_setting_change_password)
    RobotoRegularTextView tvSettingChangePassword;

    @BindView(R.id.tv_setting_logout)
    RobotoRegularTextView tvSettingLogout;

    @BindView(R.id.view_brand_divider)
    View viewBrandDivider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_SETTINGS);
        setContentView(getContentView());
        initToolbar();
        initSwichsListener();
    }

    private void initToolbar() {
        hideRightMenu();
        imageViewLeftMenu.setImageResource(R.drawable.ic_menu);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_settings;
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
        return getResources().getString(R.string.settings);
    }

    private void initSwichsListener() {
        switchSettingEmail
            .setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
                //todo wait for api
            });
        switchSettingSms
            .setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
                //todo wait for api
            });
        switchSettingNotification
            .setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
                //todo wait for api
            });
        switchSettingMarket
            .setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
                //todo wait for api
            });
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_setting_change_password, R.id.tv_setting_logout})
    public void onClickSettings(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                openDrawerLayout();
                break;
            case R.id.tv_setting_change_password:
                startActivity(new Intent(this, ChangePasswordActivity.class));
                break;
            case R.id.tv_setting_logout:
                //todo wait for api
                mPresenter.settingsLogoutRequest(null);
                mPresenter.clearUserInfo();
                break;
        }
    }

    @Override
    public void logoutResult() {
        //todo wait for api
    }

    @Override
    public void userInfoClearedSucceed(Boolean response) {
        GoShopApplication.cacheUserInfo(null);
        goToHomePage();
    }

    private void goToHomePage() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        finish();
    }
}

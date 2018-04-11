package com.goshop.app.presentation.settings;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.widget.adapter.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
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

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

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
        hideLeftMenu();
        hideRightMenu();
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

    @OnClick({R.id.tv_setting_change_password, R.id.tv_setting_logout})
    public void onClickSettings(View view) {
        switch (view.getId()) {
            case R.id.tv_setting_change_password:
                startActivity(new Intent(this, ChangePasswordActivity.class));
                break;
            case R.id.tv_setting_logout:
                //todo wait for api
                mPresenter.settingsLogoutRequest(null);
                break;
        }
    }

    @Override
    public void logoutResult() {
        //todo wait for api
    }
}

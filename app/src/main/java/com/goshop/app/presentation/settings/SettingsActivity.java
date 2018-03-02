package com.goshop.app.presentation.settings;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.utils.SlideMenuUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

public class SettingsActivity extends BaseActivity<SettingsContract.Presenter> implements
    NavigationView
        .OnNavigationItemSelectedListener, SettingsContract.View {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

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
    CustomTextView tvSettingChangePassword;

    @BindView(R.id.tv_setting_logout)
    CustomTextView tvSettingLogout;

    @BindView(R.id.view_brand_divider)
    View viewBrandDivider;

    private boolean isLogin = true;

    private String menuTag;

    private SlideMenuUtil slideMenuUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        menuTag = getIntent().getStringExtra(MENU_KEY);
        if (menuTag == null) {
            slideMenuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> {
                finish();
            });
        } else {
            if (menuTag.equals(SlideMenuUtil.MENU_VALUE)) {
                slideMenuUtil.liftedDrawerLayout();
            }
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_settings;
    }

    @Override
    public void inject() {
        hideRightMenu();
        imageviewLeftMenu.setVisibility(View.GONE);
        initSlideMenuListenerUtil(R.id.slide_menu_setting);
        initPresenter();
        initSwichsListener();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.settings);
    }

    private void initSlideMenuListenerUtil(int currentMenuId) {
        slideMenuUtil = new SlideMenuUtil(this, currentMenuId, drawerLayout,
            navigationSlideMenu, isLogin, this);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        slideMenuUtil.setDrawerHasSelect(true);
        slideMenuUtil.setSelectMenuId(item.getItemId());
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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

package com.goshop.app.presentation.settings;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.UserDataVM;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.utils.UserHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class SettingsActivity extends BaseDrawerActivity<SettingsContract.Presenter> implements
    SettingsContract.View {

    @BindView(R.id.rl_container)
    RelativeLayout rlContainer;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.switch_setting_email)
    Switch switchSettingEmail;

    @BindView(R.id.switch_setting_sms)
    Switch switchSettingSms;

    @BindView(R.id.switch_setting_exclusive_offers)
    Switch switchSettingOffers;

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
        initSwichsListener();
        initView();
        mPresenter.getUserInfo();
    }

    private void initView() {
        initToolbar();
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
        switchSettingOffers
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
                if (UserHelper.isLogin()) {
                    startActivity(new Intent(this, ChangePasswordActivity.class));
                } else {
                    goToLoginPage();
                }
                break;
            case R.id.tv_setting_logout:
                if (UserHelper.isLogin()) {
                    mPresenter.settingsLogoutRequest();
                } else {
                    goToLoginPage();
                }
                break;
        }
    }

    private void goToLoginPage() {
        startActivity(new Intent(this, ChangePasswordActivity.class));

    }

    @Override
    public void logoutSuccess() {
        mPresenter.clearUserInfo();
        // TODO: 2018/4/20 fb logout need decide
        if (AccessToken.getCurrentAccessToken() != null) {
            LoginManager.getInstance().logOut();
        }
    }

    @Override
    public void userInfoClearedSucceed(Boolean response) {
        GoShopApplication.cacheUserInfo(null);
        goToHomePage();
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rlContainer, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(rlContainer, errorMessage);
    }

    @Override
    public void onUserInfoGetSuccess(UserDataVM response) {
        switchSettingEmail.setChecked(response.isEmailSubscribe());
        switchSettingSms.setChecked(response.isSmsSubscribe());
    }

    private void goToHomePage() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        finish();
    }
}

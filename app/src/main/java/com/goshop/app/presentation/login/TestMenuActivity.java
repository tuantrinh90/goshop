package com.goshop.app.presentation.login;

import com.crashlytics.android.Crashlytics;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.account.EditProfileActivity;
import com.goshop.app.presentation.account.MyAddressBookActivity;
import com.goshop.app.presentation.account.MyPointsActivity;
import com.goshop.app.presentation.checkout.CheckoutSelectAddressActivity;
import com.goshop.app.presentation.checkout.PaymentStatusActivity;
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
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

//todo(helen) this activity will delete when merge code
public class TestMenuActivity extends BaseActivity implements NavigationView
    .OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isLogin = true;

    private String menuTag;

    private SlideMenuUtil slideMenuUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        menuTag = getIntent().getStringExtra(MENU_KEY);
        if (menuTag == null) {
            slideMenuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(SlideMenuUtil.MENU_VALUE)) {
                slideMenuUtil.liftedDrawerLayout();
            }
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_test_menu;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initSlideMenuListenerUtil(R.id.slide_menu_others);
    }

    private void initSlideMenuListenerUtil(int currentMenuId) {
        slideMenuUtil = new SlideMenuUtil(this, currentMenuId, drawerLayout,
            navigationSlideMenu, isLogin, this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.other_page);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        slideMenuUtil.setDrawerHasSelect(true);
        slideMenuUtil.setSelectMenuId(item.getItemId());
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.btn_test_login, R.id.imageview_left_menu, R.id.btn_test_complement_email, R.id
        .btn_test_send_reset_pwd, R.id.btn_test_editprofile, R.id.btn_test_my_address, R.id
        .btn_test_my_points, R.id.btn_test_select_address, R.id.btn_test_paymentstatus})
    public void onMenuClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.btn_test_complement_email:
                startActivity(new Intent(this, LoginComplementEmailActivity.class));
                break;
            case R.id.btn_test_send_reset_pwd:
                startActivity(new Intent(this, LoginResetPasswordActivity.class));
                break;
            case R.id.btn_test_editprofile:
                startActivity(new Intent(this, EditProfileActivity.class));
                break;
            case R.id.btn_test_my_address:
                startActivity(new Intent(this, MyAddressBookActivity.class));
                break;
            case R.id.btn_test_my_points:
                startActivity(new Intent(this, MyPointsActivity.class));
                break;
            case R.id.btn_test_select_address:
                startActivity(new Intent(this, CheckoutSelectAddressActivity.class));
                break;
            case R.id.btn_test_paymentstatus:
                startActivity(new Intent(this, PaymentStatusActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}

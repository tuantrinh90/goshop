package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.presentation.goloyalty.MyRewardsActivity;
import com.goshop.app.presentation.myorder.MyOrdersActivity;
import com.goshop.app.presentation.shopping.AllReviewsActivity;
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

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

public class MyAccountLandingActivity extends BaseActivity implements NavigationView
    .OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.iv_my_account_thumb)
    ImageView ivMyAccountThumb;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_my_account_username)
    CustomBoldTextView tvMyAccountUsername;

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
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(SlideMenuUtil.MENU_VALUE)) {
                slideMenuUtil.liftedDrawerLayout();
            }
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_account_landing;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initSlideMenuListenerUtil(R.id.ll_slide_user_info);
    }

    private void initSlideMenuListenerUtil(int currentMenuId) {
        slideMenuUtil = new SlideMenuUtil(this, currentMenuId, drawerLayout,
            navigationSlideMenu, isLogin, this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_account);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        slideMenuUtil.setDrawerHasSelect(true);
        slideMenuUtil.setSelectMenuId(item.getItemId());
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.tv_my_account_edit, R.id.rl_account_wishlist, R.id.rl_account_orders, R.id
        .rl_account_reviews, R.id.rl_account_address, R.id.rl_account_rewards, R.id
        .rl_account_points, R.id.rl_account_egift})
    public void onAccountLandingClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_my_account_edit:
                intent = new Intent(this, EditProfileActivity.class);
                break;
            case R.id.rl_account_wishlist:
                intent = new Intent(this, MyWishlistActivity.class);
                break;
            case R.id.rl_account_orders:
                intent = new Intent(this, MyOrdersActivity.class);
                break;
            case R.id.rl_account_reviews:
                intent = new Intent(this, AllReviewsActivity.class);
                break;
            case R.id.rl_account_address:
                intent = new Intent(this, MyAddressBookActivity.class);
                break;
            case R.id.rl_account_rewards:
                intent = new Intent(this, MyRewardsActivity.class);
                break;
            case R.id.rl_account_points:
                intent = new Intent(this, MyPointsActivity.class);
                break;
            case R.id.rl_account_egift:
                intent = new Intent(this, MyEGiftCardsActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.goloyalty.MyRewardsActivity;
import com.goshop.app.presentation.myorder.MyOrdersActivity;
import com.goshop.app.presentation.shopping.AllReviewsActivity;
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
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAccountLandingActivity extends BaseActivity implements MenuAdapter
    .OnSlideMenuItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.iv_my_account_thumb)
    ImageView ivMyAccountThumb;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_my_account_username)
    RobotoMediumTextView tvMyAccountUsername;

    private int currentMenu;

    private boolean isLogin = true;

    private MenuAdapter menuAdapter;

    private String menuTag;

    private MenuUtil menuUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initMenuUtil();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        menuTag = getIntent().getStringExtra(MenuUtil.MENU_KEY);
        if (menuTag == null) {
            menuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(MenuUtil.MENU_VALUE)) {
                menuUtil.liftedDrawerLayout();
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                toolbar.setNavigationOnClickListener(v -> {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                    drawerLayout.openDrawer(Gravity.LEFT);
                });
            }
        }

        initMenuRecyclerview();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_account_landing;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_account);
    }

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this, isLogin, drawerLayout);
    }

    private void initMenuRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);
        menuAdapter = new MenuAdapter(
            isLogin ? menuUtil.getLoginMenuModel() : menuUtil.getUnLoginMenuModel());
        recyclerViewMenu.setAdapter(menuAdapter);
        currentMenu = MenuUtil.LOGIN_ACCOUNT;
        menuAdapter.updateSelection(currentMenu);
        menuAdapter.setOnSlideMenuItemClickListener(this);
        menuAdapter.updateLoginState(isLogin);
    }

    @Override
    public void onHeaderUserClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }

    @Override
    public void onHeaderLoginClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }

    @Override
    public void onItemClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
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

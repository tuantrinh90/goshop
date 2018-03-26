package com.goshop.app.presentation.goloyalty;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.account.MyPointsActivity;
import com.goshop.app.presentation.model.GoLoyaltyModel;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class GoLoyaltyActivity extends BaseActivity<GoLoyaltyContract.Presenter> implements
    MenuAdapter
        .OnSlideMenuItemClickListener, GoLoyaltyContract.View, GoLoyaltyAdapter
    .OnGoLoyaltyItemsClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.recyclerview_go_loyalty)
    RecyclerView recyclerviewGoLoyalty;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int currentMenu;

    private GoLoyaltyAdapter goLoyaltyAdapter;

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

        //todo wait for api
        mPresenter.goLoyaltyRequest(null);
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
        currentMenu = isLogin ? MenuUtil.LOGIN_MENU_GO_LOYALTY : MenuUtil.UNLOGIN_MENU_GO_LOYALTY;
        menuAdapter.updateSelection(currentMenu);
        menuAdapter.setOnSlideMenuItemClickListener(this);
        menuAdapter.updateLoginState(isLogin);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_go_loyalty;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initPresenter();
        initRecyclerView();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewGoLoyalty.setLayoutManager(layoutManager);
        goLoyaltyAdapter = new GoLoyaltyAdapter(new ArrayList<>());
        recyclerviewGoLoyalty.setAdapter(goLoyaltyAdapter);
        goLoyaltyAdapter.setOnGoLoyaltyItemsClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.go_loyalty);
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
    public void showGoLoyaltyResult(List<GoLoyaltyModel> goLoyaltyModels) {
        goLoyaltyAdapter.setUpdatas(goLoyaltyModels);
    }

    @Override
    public void onPointsItemClick() {
        startActivity(new Intent(this, MyPointsActivity.class));
    }

    @Override
    public void onDealItemClick() {
        startActivity(new Intent(this, RewardsDetailActivity.class));
    }

    @Override
    public void onViewAllClick() {
        startActivity(new Intent(this, AllDealsActivity.class));
    }
}

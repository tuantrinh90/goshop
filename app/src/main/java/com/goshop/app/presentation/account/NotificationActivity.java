package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.NotificationAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.NotificationVM;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.ScreenHelper;
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

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class NotificationActivity extends BaseActivity<NotificationContract.Presenter>
    implements NotificationContract.View, MenuAdapter
    .OnSlideMenuItemClickListener, NotificationAdapter.OnNotificationItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.recyclerview_notification)
    RecyclerView recyclerviewNotification;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int currentMenu;

    private boolean isLogin = true;

    private MenuAdapter menuAdapter;

    private String menuTag;

    private MenuUtil menuUtil;

    @Override
    public void notificationResult(List<NotificationVM> notificationVMS) {
        recyclerviewNotification.setLayoutManager(new LinearLayoutManager(this));
        NotificationAdapter notificationAdapter = new NotificationAdapter(notificationVMS);
        recyclerviewNotification.setAdapter(notificationAdapter);
        notificationAdapter.setOnNotificationItemClickListener(this::onNotificationItemClick);
    }

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
        mPresenter.notificationRequest(new HashMap<>());
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
        currentMenu = isLogin ? MenuUtil.LOGIN_MENU_NOTIFICATIONS : MenuUtil
            .UNLOGIN_MENU_NOTIFICATIONS;
        menuAdapter.updateSelection(currentMenu);
        menuAdapter.setOnSlideMenuItemClickListener(this);
        menuAdapter.updateLoginState(isLogin);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_notification;
    }

    @Override
    public void inject() {
        hideRightMenu();
        imageviewLeftMenu.setVisibility(View.GONE);
        initPresenter();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.home_drawlayout_notifications);
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

    @OnClick(R.id.imageview_left_menu)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onNotificationItemClick(int position) {
        startActivity(new Intent(this, WebContentActivity.class));
    }
}

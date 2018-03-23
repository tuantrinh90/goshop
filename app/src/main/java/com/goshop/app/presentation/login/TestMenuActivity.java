package com.goshop.app.presentation.login;

import com.crashlytics.android.Crashlytics;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.SlideMenuUtil;
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
import io.fabric.sdk.android.Fabric;

//todo(helen) this activity will delete when merge code
public class TestMenuActivity extends BaseActivity implements MenuAdapter
    .OnSlideMenuItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isLogin = true;

    private MenuAdapter menuAdapter;

    private String menuTag;

    private MenuUtil menuUtil;

    private SlideMenuUtil slideMenuUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0,
            0);
        toggle.syncState();
        //todo need decide
       /* menuTag = getIntent().getStringExtra(MENU_KEY);
        if (menuTag == null) {
            slideMenuUtil.disabledDrawerLayout();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        } else {
            if (menuTag.equals(SlideMenuUtil.MENU_VALUE)) {
                slideMenuUtil.liftedDrawerLayout();
            }
        }*/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            drawerLayout.openDrawer(Gravity.LEFT);
        });
    }

    @Override
    public int getContentView() {
        return R.layout.activity_test_menu;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initMenuUtil();
        initMenuRecyclerview();
    }

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this);
    }

    private void initMenuRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMenu.setLayoutManager(layoutManager);
        menuAdapter = new MenuAdapter(menuUtil.getMenuModel());
        recyclerViewMenu.setAdapter(menuAdapter);
        menuAdapter.updateSelection(MenuUtil.MENU_OTHER);
        menuAdapter.setOnSlideMenuItemClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.other_page);
    }
    //todo need decide

   /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        slideMenuUtil.setDrawerHasSelect(true);
        slideMenuUtil.setSelectMenuId(item.getItemId());
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }*/

    @OnClick({R.id.btn_test_login, R.id.btn_test_complement_email, R.id
        .btn_test_send_reset_pwd})
    public void onMenuClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btn_test_complement_email:
                startActivity(new Intent(this, LoginComplementEmailActivity.class));
                break;
            case R.id.btn_test_send_reset_pwd:
                startActivity(new Intent(this, LoginResetPasswordActivity.class));
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

    @Override
    public void onHeaderUserClick() {

    }

    @Override
    public void onHeaderLoginClick() {

    }

    @Override
    public void onItemClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);

    }
}

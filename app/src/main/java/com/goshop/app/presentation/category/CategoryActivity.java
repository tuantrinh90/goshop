package com.goshop.app.presentation.category;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;
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
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CategoryActivity extends BaseActivity<CategoryContract.Presenter> implements
    CategoryContract.View, CategoryLeftAdapter.CategoryLeftClickListener, CategoryRightAdapter
    .OnChildItemClickListener, MenuAdapter
    .OnSlideMenuItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.recycleview_category_left)
    RecyclerView recycleviewCategoryLeft;

    @BindView(R.id.recycleview_category_right)
    RecyclerView recycleviewCategoryRight;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int currentMenu;

    private boolean isLogin = true;

    private CategoryLeftAdapter leftAdapter;

    private MenuAdapter menuAdapter;

    private String menuTag;

    private MenuUtil menuUtil;

    private CategoryRightAdapter rightAdapter;

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
        mPresenter.getCategoryLeftMenu();
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
        currentMenu = isLogin ? MenuUtil.LOGIN_MENU_CATEGORIES : MenuUtil.UNLOGIN_MENU_CATEGORIES;
        menuAdapter.updateSelection(currentMenu);
        menuAdapter.setOnSlideMenuItemClickListener(this);
        menuAdapter.updateLoginState(isLogin);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_category;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initPresenter();
        initRecycleview();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecycleview() {
        LinearLayoutManager leftManager = new LinearLayoutManager(this);
        leftManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleviewCategoryLeft.setLayoutManager(leftManager);
        leftAdapter = new CategoryLeftAdapter(new ArrayList<>(), this);
        recycleviewCategoryLeft.setAdapter(leftAdapter);
        LinearLayoutManager rightManager = new LinearLayoutManager(this);
        rightManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleviewCategoryRight.setLayoutManager(rightManager);
        rightAdapter = new CategoryRightAdapter(new ArrayList<>(), this);
        recycleviewCategoryRight.setAdapter(rightAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.category);
    }

    @Override
    public void onHeaderUserClick(int position) {
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }

    @Override
    public void onHeaderLoginClick(int position) {
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
    public void showLeftMenu(List<CategoryLeftMenuVM> leftMenuVMS) {
        leftAdapter.setUpdateLeftCategorys(leftMenuVMS);
        if (leftMenuVMS.size() > 0) {
            leftAdapter.selectPosition(0);
            //TODO  wait for api
            mPresenter.categoryRightMenuRequest(null);
        }
    }

    @Override
    public void showRightMenu(List<CategoryRightMenuModel> rightMenuModels) {
        rightAdapter.setUpdateRightModels(rightMenuModels);
        recycleviewCategoryRight.smoothScrollToPosition(0);
    }

    @Override
    public void onLeftClick(CategoryLeftMenuVM leftMenuVM) {
        //TODO wait for api
        mPresenter.categoryRightMenuRequest(null);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onCategoryClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onChildItemClick(CategoryRightChildVM childVM) {
        Intent intent = new Intent(this, CategoryTreeDetailActivity.class);
        intent.putExtra(CategoryTreeDetailActivity.CATEGORY_DETAIL_TITLE, childVM.getTitle());
        startActivity(intent);
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

package com.goshop.app.presentation.category;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.widget.listener.OnCategoryItemClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CategoryActivity extends BaseDrawerActivity<CategoryContract.Presenter> implements
    CategoryContract.View, OnCategoryItemClickListener {

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

    private CategoryLeftAdapter leftAdapter;

    private CategoryRightAdapter rightAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_CATEGORY);
        setContentView(getContentView());
        initToolbar();
        initRecyclerView();
        mPresenter.getCategoryLeftMenu();
    }

    private void initToolbar() {
        hideLeftMenu();
        hideRightMenu();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_category;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
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

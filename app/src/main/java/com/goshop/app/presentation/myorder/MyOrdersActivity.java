package com.goshop.app.presentation.myorder;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.MyOrdersVM;
import com.goshop.app.utils.SlideMenuUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

public class MyOrdersActivity extends BaseActivity<MyOrdersContract.Presenter> implements
    MyOrdersContract.View, NavigationView.OnNavigationItemSelectedListener, MyOrdersAdapter
    .OnOrdersItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.recyclerview_my_orders)
    RecyclerView recyclerviewMyOrders;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isLogin = true;

    private String menuTag;

    private MyOrdersAdapter myOrdersAdapter;

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
        //todo wait for api
        mPresenter.myOrdersRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_orders;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        initSlideMenuListenerUtil(R.id.slide_menu_orders);
        hideRightMenu();
        initRecyclerView();
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_orders);
    }

    private void initSlideMenuListenerUtil(int currentMenuId) {
        slideMenuUtil = new SlideMenuUtil(this, currentMenuId, drawerLayout,
            navigationSlideMenu, isLogin, this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewMyOrders.setLayoutManager(layoutManager);
        myOrdersAdapter = new MyOrdersAdapter(new ArrayList<>());
        recyclerviewMyOrders.setAdapter(myOrdersAdapter);
        myOrdersAdapter.setOnOrdersItemClickListener(this::onOrdersItemClick);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void showMyOrdersResult(List<MyOrdersVM> myOrdersVMS) {
        myOrdersAdapter.setUpdateDatas(myOrdersVMS);
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

    @Override
    public void onOrdersItemClick() {
        startActivity(new Intent(this, OrderDetailActivity.class));
    }
}

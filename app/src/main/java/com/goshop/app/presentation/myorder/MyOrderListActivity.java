package com.goshop.app.presentation.myorder;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.MyOrderListAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.response.MyOrderDetailResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.utils.JToolUtils;
import com.goshop.app.utils.ScreenHelper;
import com.goshop.app.utils.SlideMenuUtil;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

import static com.goshop.app.utils.SlideMenuUtil.MENU_KEY;

public class MyOrderListActivity extends BaseActivity<MyOrderContract.Presenter> implements
    MyOrderContract.View, SwipeRefreshLayout.OnRefreshListener, NavigationView
    .OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.navigation_slide_menu)
    NavigationView navigationSlideMenu;

    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;

    @BindView(R.id.swipe_layout_myorder_list)
    SwipeRefreshLayout swipeLayoutMyorderList;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isFront;

    private boolean isLogin = true;

    private String menuTag;

    private SlideMenuUtil slideMenuUtil;

    @Override
    public void showOrderList(MyOrderListResponse response) {
        JToolUtils.printObject(response);
        initRecycler(response);
    }

    @Override
    public void showNetwordErrorMessage() {
        Toast.makeText(this, R.string.app_network_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFaildMessage(String errorMessage) {
        Toast.makeText(this, R.string.app_network_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSwipeLayout() {
        if (swipeLayoutMyorderList != null) {
            swipeLayoutMyorderList.setRefreshing(true);
        }
    }

    @Override
    public void closeSwipeLayout() {
        if (swipeLayoutMyorderList != null) {
            swipeLayoutMyorderList.setRefreshing(false);
        }
    }

    @Override
    public void showOrderDetail(MyOrderDetailResponse reponse) {
        //TODO joyson this is empty response ,no need write code
    }

    private void initRecycler(MyOrderListResponse response) {
        List<MyOrderListResponse.ResultsBean> results = response.getResults();
        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderList.setAdapter(new MyOrderListAdapter(results));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        mPresenter.getOrderList(new HashMap<>());
        swipeLayoutMyorderList.setOnRefreshListener(this);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_myorder_list;
    }

    @Override
    public void inject() {
        imageViewLeftMenu.setVisibility(View.GONE);
        hideRightMenu();
        initSlideMenuListenerUtil(R.id.slide_menu_orders);
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initSlideMenuListenerUtil(int currentMenuId) {
        slideMenuUtil = new SlideMenuUtil(this, currentMenuId, drawerLayout,
            navigationSlideMenu, isLogin, this);
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.my_orders_title);
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
    protected void onPause() {
        super.onPause();
        isFront = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
    }

    @OnClick({R.id.imageview_left_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onRefresh() {
        if (isFront) {
            mPresenter.getOrderList(new HashMap<>());
        }
    }
}

package com.goshop.app.presentation.myorder;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.presentation.model.MyOrdersVM;
import com.goshop.app.presentation.shopping.RatingActivity;
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

public class MyOrdersActivity extends BaseDrawerActivity<MyOrdersContract.Presenter> implements
    MyOrdersContract.View, MyOrdersAdapter.OnOrdersItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_menu)
    RecyclerView recyclerViewMenu;

    @BindView(R.id.recyclerview_my_orders)
    RecyclerView recyclerviewMyOrders;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private MyOrdersAdapter myOrdersAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_MY_ORDERS);
        setContentView(getContentView());
        initRecyclerView();
        initToolbar();
        //todo wait for api
        mPresenter.myOrdersRequest(null);
    }

    private void initToolbar() {
        hideLeftMenu();
        hideRightMenu();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_orders;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_orders);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewMyOrders.setLayoutManager(layoutManager);
        myOrdersAdapter = new MyOrdersAdapter(new ArrayList<>());
        recyclerviewMyOrders.setAdapter(myOrdersAdapter);
        myOrdersAdapter.setOnOrdersItemClickListener(this);
    }

    @Override
    public void showMyOrdersResult(List<MyOrdersVM> myOrdersVMS) {
        myOrdersAdapter.setUpdateDatas(myOrdersVMS);
    }

    @Override
    public void onOrdersItemClick() {
        startActivity(new Intent(this, OrderDetailActivity.class));
    }

    @Override
    public void onWriteReviewClick() {
        startActivity(new Intent(this, RatingActivity.class));
    }

    @Override
    public void onTrackClick() {

    }

    @Override
    public void onReturnClick() {
        startActivity(new Intent(this, ReturnOrderActivity.class));
    }
}

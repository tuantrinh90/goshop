package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.MyOrdersVM;
import com.goshop.app.presentation.shopping.RatingActivity;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyOrdersActivity extends BaseDrawerActivity<MyOrdersContract.Presenter> implements
    MyOrdersContract.View, MyOrdersAdapter.OnOrdersItemClickListener {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_my_orders)
    RecyclerView recyclerviewMyOrders;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fl_no_data)
    FrameLayout flNoData;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private MyOrdersAdapter myOrdersAdapter;

    private int page = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSwipRefreshLayout();
        mPresenter.getListOrder(page, false);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_orders;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
        setCurrentMenuType(MenuUtil.MENU_TYPE_MY_ORDERS);
        setContentView(getContentView());
        initRecyclerView();
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

    @OnClick({R.id.imageview_left_menu})
    public void onCategoryClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }
                break;
            case R.id.tv_shop_now:
                updateLayoutStatus(flNoData, false);
                startActivity(new Intent(this, MainPageActivity.class));
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                page = 1;
                mPresenter.getListOrder(page, false);
                break;
        }
    }

    @Override
    public void showMyOrdersResult(List<MyOrdersVM> myOrdersVMS) {
        if (myOrdersVMS.size() > 0) {
            myOrdersAdapter.setUpdateDatas(myOrdersVMS);
        } else {
            updateLayoutStatus(flNoData, true);
        }
    }

    @Override
    public void showNetError() {
        updateLayoutStatus(flConnectionBreak, true);
    }

    @Override
    public void showGetListFailedMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewMyOrders, errorMessage);
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

    private void initSwipRefreshLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.color_main_pink);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            page = 1;
            mPresenter.getListOrder(page, true);
        });
    }

    @Override
    public void stopRefresh() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}

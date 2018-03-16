package com.goshop.app.presentation.myorder;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.OrderDetailVM;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class OrderDetailActivity extends BaseActivity<OrderDetailContract.Presenter> implements
    OrderDetailContract.View {

    @BindView(R.id.recyclerview_order_detail)
    RecyclerView recyclerviewOrderDetail;

    @BindView(R.id.tv_order_detail_address)
    RobotoRegularTextView tvOrderDetailAddress;

    @BindView(R.id.tv_order_detail_cancel)
    RobotoRegularTextView tvOrderDetailCancel;

    @BindView(R.id.tv_order_detail_city)
    RobotoRegularTextView tvOrderDetailCity;

    @BindView(R.id.tv_order_detail_country)
    RobotoRegularTextView tvOrderDetailCountry;

    @BindView(R.id.tv_order_detail_method)
    RobotoRegularTextView tvOrderDetailMethod;

    @BindView(R.id.tv_order_detail_name)
    RobotoRegularTextView tvOrderDetailName;

    @BindView(R.id.tv_order_detail_order_number)
    RobotoRegularTextView tvOrderDetailOrderNumber;

    @BindView(R.id.tv_order_detail_order_placed)
    RobotoRegularTextView tvOrderDetailOrderPlaced;

    @BindView(R.id.tv_order_detail_order_status)
    RobotoRegularTextView tvOrderDetailOrderStatus;

    @BindView(R.id.tv_order_detail_tel)
    RobotoRegularTextView tvOrderDetailTel;

    private MyOrderProductAdapter myOrderProductAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.orderDetailRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initRecyclerView();
        initPresenter();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewOrderDetail.setLayoutManager(layoutManager);
        myOrderProductAdapter = new MyOrderProductAdapter(new ArrayList<>());
        recyclerviewOrderDetail.setAdapter(myOrderProductAdapter);
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
        return getResources().getString(R.string.order_detail);
    }

    @Override
    public void showOrderDetailResult(OrderDetailVM orderDetailVM) {
        myOrderProductAdapter.setUpdateDatas(orderDetailVM.getMyOrdersProductVMS());
        tvOrderDetailOrderNumber.setText(orderDetailVM.getOrderNumber());
        tvOrderDetailOrderStatus.setText(orderDetailVM.getOrderStatus());
        tvOrderDetailOrderPlaced.setText(orderDetailVM.getPlaceAt());
        tvOrderDetailName.setText(orderDetailVM.getShipName());
        tvOrderDetailAddress.setText(orderDetailVM.getShipAddress());
        tvOrderDetailCity.setText(orderDetailVM.getShipCity());
        tvOrderDetailCountry.setText(orderDetailVM.getShipCountry());
        tvOrderDetailTel.setText(orderDetailVM.getShipTel());
        tvOrderDetailMethod.setText(orderDetailVM.getMethod());
    }

    @OnClick({R.id.tv_order_detail_cancel, R.id.imageview_left_menu})
    public void onOrderDetailClick(View view) {
        switch (view.getId()) {
            case R.id.tv_order_detail_cancel:
                startActivity(new Intent(this, CancelOrderActivity.class));
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}

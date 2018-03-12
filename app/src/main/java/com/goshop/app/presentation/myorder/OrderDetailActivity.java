package com.goshop.app.presentation.myorder;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.OrderDetailVM;

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
    CustomTextView tvOrderDetailAddress;

    @BindView(R.id.tv_order_detail_cancel)
    CustomTextView tvOrderDetailCancel;

    @BindView(R.id.tv_order_detail_city)
    CustomTextView tvOrderDetailCity;

    @BindView(R.id.tv_order_detail_country)
    CustomTextView tvOrderDetailCountry;

    @BindView(R.id.tv_order_detail_method)
    CustomTextView tvOrderDetailMethod;

    @BindView(R.id.tv_order_detail_name)
    CustomTextView tvOrderDetailName;

    @BindView(R.id.tv_order_detail_order_number)
    CustomTextView tvOrderDetailOrderNumber;

    @BindView(R.id.tv_order_detail_order_placed)
    CustomTextView tvOrderDetailOrderPlaced;

    @BindView(R.id.tv_order_detail_order_status)
    CustomTextView tvOrderDetailOrderStatus;

    @BindView(R.id.tv_order_detail_tel)
    CustomTextView tvOrderDetailTel;

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
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}

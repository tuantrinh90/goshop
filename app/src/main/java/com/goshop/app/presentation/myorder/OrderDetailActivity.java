package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.presentation.model.OrderDetailVM;
import com.goshop.app.presentation.shopping.RatingActivity;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity<OrderDetailContract.Presenter> implements
    OrderDetailContract.View, MyOrderProductAdapter.OnOrderDetailItemClickListener {

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.fl_content)
    FrameLayout flContent;

    @BindView(R.id.recyclerview_order_detail)
    RecyclerView recyclerviewOrderDetail;

    @BindView(R.id.tv_net)
    RobotoRegularTextView tvNet;

    @BindView(R.id.tv_net_refresh)
    RobotoRegularTextView tvNetRefresh;

    @BindView(R.id.tv_order_detail_address)
    RobotoLightTextView tvOrderDetailAddress;

    @BindView(R.id.tv_order_detail_cancel)
    RobotoRegularTextView tvOrderDetailCancel;

    @BindView(R.id.tv_order_detail_city)
    RobotoLightTextView tvOrderDetailCity;

    @BindView(R.id.tv_order_detail_country)
    RobotoLightTextView tvOrderDetailCountry;

    @BindView(R.id.tv_order_detail_method)
    RobotoLightTextView tvOrderDetailMethod;

    @BindView(R.id.tv_order_detail_name)
    RobotoLightTextView tvOrderDetailName;

    @BindView(R.id.tv_order_detail_order_number)
    RobotoLightTextView tvOrderDetailOrderNumber;

    @BindView(R.id.tv_order_detail_order_placed)
    RobotoLightTextView tvOrderDetailOrderPlaced;

    @BindView(R.id.tv_order_detail_order_status)
    RobotoLightTextView tvOrderDetailOrderStatus;

    @BindView(R.id.tv_order_detail_tel)
    RobotoLightTextView tvOrderDetailTel;

    @BindView(R.id.tv_billing_subtotal_amount)
    RobotoLightTextView tvBillingSubtotalAmount;

    @BindView(R.id.ll_billing_subtotal)
    LinearLayout llBillingSubtotal;

    @BindView(R.id.tv_billing_shipping_amount)
    RobotoLightTextView tvBillingShippingAmount;

    @BindView(R.id.ll_billing_shipping)
    LinearLayout llBillingShipping;

    @BindView(R.id.tv_billing_discount_code)
    RobotoLightTextView tvBillingDiscountCode;

    @BindView(R.id.tv_billing_discount_amount)
    RobotoLightTextView tvBillingDiscountAmount;

    @BindView(R.id.ll_billing_discount)
    LinearLayout llBillingDiscount;

    @BindView(R.id.tv_billing_egift_code)
    RobotoLightTextView tvBillingEgiftCode;

    @BindView(R.id.tv_billing_egift_amount)
    RobotoLightTextView tvBillingEgiftAmount;

    @BindView(R.id.ll_billing_egift)
    LinearLayout llBillingEgift;

    @BindView(R.id.tv_billing_points_amount)
    RobotoLightTextView tvBillingPointsAmount;

    @BindView(R.id.tv_billing_points_code)
    RobotoLightTextView tvBillingPointsCode;

    @BindView(R.id.ll_billing_points)
    LinearLayout llBillingPoints;

    @BindView(R.id.tv_billing_total)
    RobotoMediumTextView tvBillingTotal;

    @BindView(R.id.ll_billing_total)
    LinearLayout llBillingTotal;

    private MyOrderProductAdapter myOrderProductAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getOrderDetail();
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
        myOrderProductAdapter.setOnOrderDetailItemClickListener(this);
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.order_detail);
    }

    @Override
    public void showOrderDetailResult(OrderDetailVM orderDetailVM) {
        updateLayoutStatus(flContent, true);
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

        BillingVM billingVM = orderDetailVM.getBillingVM();
        tvBillingSubtotalAmount.setText(billingVM.getBillingSubTotal());
        tvBillingShippingAmount.setText(billingVM.getBillingShipping());
        tvBillingDiscountAmount
            .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingDiscountAmount()));
        tvBillingEgiftAmount
            .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingEGiftAmount()));
        tvBillingPointsAmount
            .setText(NumberFormater.formaterOfferPrice(billingVM.getBillingPointsAmount()));
        tvBillingTotal.setText(billingVM.getBillingTotal());
        tvBillingDiscountCode.setText(billingVM.getBillingDiscountCode());
        tvBillingEgiftCode.setText(billingVM.getBillingEGiftCode());
        tvBillingPointsCode.setText(billingVM.getBillingPointsApplied());

        llBillingDiscount.setVisibility(
            TextUtils.isEmpty(billingVM.getBillingDiscountAmount()) ? View.GONE : View.VISIBLE);
        llBillingEgift
            .setVisibility(
                TextUtils.isEmpty(billingVM.getBillingEGiftAmount()) ? View.GONE : View.VISIBLE);
        llBillingPoints
            .setVisibility(
                TextUtils.isEmpty(billingVM.getBillingPointsAmount()) ? View.GONE : View.VISIBLE);
    }

    @Override
    public void showNetBreak() {
        updateLayoutStatus(flConnectionBreak, true);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewOrderDetail, errorMessage);
    }

    @OnClick({R.id.tv_order_detail_cancel, R.id.imageview_left_menu, R.id.tv_net_refresh})
    public void onOrderDetailClick(View view) {
        switch (view.getId()) {
            case R.id.tv_order_detail_cancel:
                startActivity(new Intent(this, CancelOrderActivity.class));
                break;
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                mPresenter.getOrderDetail();
                break;
        }
    }

    @Override
    public void onWriteReviewClick() {
        startActivity(new Intent(this, RatingActivity.class));
    }

    @Override
    public void onTrackClick() {
        startActivity(new Intent(this, ReturnOrderActivity.class));
    }

    @Override
    public void onReturnClick() {
        startActivity(new Intent(this, ReturnOrderActivity.class));
    }
}

//package com.goshop.app.presentation.myorder;
//
//import com.goshop.app.GoShopApplication;
//import com.goshop.app.R;
//import com.goshop.app.adapter.MyOrderDetailAdapter;
//import com.goshop.app.base.BaseActivity;
//import com.goshop.app.common.view.RobotoMediumTextView;
//import com.goshop.app.common.view.RobotoRegularTextView;
//import com.goshop.app.data.model.response.MyOrderDetailResponse;
//import com.goshop.app.data.model.response.MyOrderListResponse;
//import com.goshop.app.utils.ScreenHelper;
//import com.goshop.app.utils.ViewUtils;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import java.util.HashMap;
//import java.util.List;
//
//import butterknife.BindString;
//import butterknife.BindView;
//import butterknife.OnClick;
//import injection.components.DaggerPresenterComponent;
//import injection.modules.PresenterModule;
//
//public class MyOrderDetailActivity extends BaseActivity<MyOrderContract.Presenter> implements
//    MyOrderContract.View {
//
//    @BindString(R.string.my_orders_title_number)
//    String holderOrderNumber;
//
//    @BindString(R.string.my_orders_placed_at)
//    String holderOrderPlacedAt;
//
//    @BindString(R.string.my_orders_title_status)
//    String holderOrderStatus;
//
//    @BindView(R.id.imageview_left_menu)
//    ImageView imageviewLeftMenu;
//
//    @BindView(R.id.rv_order_list)
//    RecyclerView rvOrderList;
//
//    @BindView(R.id.tv_order_detail_address)
//    RobotoRegularTextView tvOrderDetailAddress;
//
//    @BindView(R.id.tv_order_detail_city_and_postcode)
//    RobotoRegularTextView tvOrderDetailCityAndPostcode;
//
//    @BindView(R.id.tv_order_detail_country)
//    RobotoRegularTextView tvOrderDetailCountry;
//
//    @BindView(R.id.tv_order_detail_discount)
//    RobotoRegularTextView tvOrderDetailDiscount;
//
//    @BindView(R.id.tv_order_detail_number)
//    RobotoRegularTextView tvOrderDetailNumber;
//
//    @BindView(R.id.tv_order_detail_pay_method)
//    RobotoRegularTextView tvOrderDetailPayMethod;
//
//    @BindView(R.id.tv_order_detail_person_name)
//    RobotoRegularTextView tvOrderDetailPersonName;
//
//    @BindView(R.id.tv_order_detail_rounding_amout)
//    RobotoRegularTextView tvOrderDetailRoundingAmout;
//
//    @BindView(R.id.tv_order_detail_shipping)
//    RobotoRegularTextView tvOrderDetailShipping;
//
//    @BindView(R.id.tv_order_detail_status)
//    RobotoRegularTextView tvOrderDetailStatus;
//
//    @BindView(R.id.tv_order_detail_sub_total)
//    RobotoRegularTextView tvOrderDetailSubTotal;
//
//    @BindView(R.id.tv_order_detail_tel)
//    RobotoRegularTextView tvOrderDetailTel;
//
//    @BindView(R.id.tv_order_detail_total)
//    RobotoMediumTextView tvOrderDetailTotal;
//
//    @BindView(R.id.tv_order_detail_track)
//    RobotoRegularTextView tvOrderDetailTrack;
//
//    @Override
//    public void showOrderList(MyOrderListResponse response) {
//        //TODO joyson this is empty response ,no need write code
//    }
//
//    @Override
//    public void showNetwordErrorMessage() {
//        Toast.makeText(this, R.string.app_network_error, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void showFaildMessage(String errorMessage) {
//        Toast.makeText(this, R.string.app_network_error, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void showSwipeLayout() {
//        //TODO joyson this is empty response ,no need write code
//    }
//
//    @Override
//    public void closeSwipeLayout() {
//        //TODO joyson this is empty response ,no need write code
//    }
//
//    @Override
//    public void showOrderDetail(MyOrderDetailResponse reponse) {
//        initRecycler(reponse);
//        initPageInfo(reponse);
//    }
//
//    private void initRecycler(MyOrderDetailResponse response) {
//        List<MyOrderDetailResponse.SubordersBean> suborders = response.getSuborders();
//        rvOrderList.setNestedScrollingEnabled(false);
//        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
//        rvOrderList.setAdapter(new MyOrderDetailAdapter(suborders));
//    }
//
//    @SuppressLint("SetTextI18n")
//    private void initPageInfo(MyOrderDetailResponse reponse) {
//        tvOrderDetailNumber.setText(holderOrderNumber + reponse.getOrderId());
//        tvOrderDetailStatus.setText(holderOrderStatus + reponse.getState());
//        tvOrderDetailTrack.setText(holderOrderPlacedAt + reponse.getDate());
//        tvOrderDetailPersonName.setText(reponse.getCustomerName());
//        tvOrderDetailAddress.setText(reponse.getShippingAddress().getRegion());
//        tvOrderDetailCityAndPostcode.setText(
//            reponse.getShippingAddress().getCity() + "," + reponse.getShippingAddress()
//                .getPostcode());
//        tvOrderDetailCountry.setText(reponse.getShippingAddress().getCountry());
//        tvOrderDetailTel.setText(reponse.getShippingAddress().getTelephone());
//        tvOrderDetailPayMethod.setText(reponse.getPaymentMethod());
//
//        tvOrderDetailSubTotal.setText(reponse.getSubtotal());
//        tvOrderDetailRoundingAmout.setText(reponse.getSubtotal());
//        tvOrderDetailShipping.setText(reponse.getShippingFee());
//        tvOrderDetailTotal.setText(reponse.getGrandTotal());
//    }
//
//    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_order_detail_cancel})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.imageview_left_menu:
//                finish();
//                break;
//            case R.id.tv_btn_order_detail_cancel:
//                startActivity(new Intent(this, CancelOrderActivity.class));
//                break;
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mPresenter.getOrderDetail(new HashMap<>());
//        ViewUtils.setBg(imageviewLeftMenu, R.drawable.ic_icon_back);
//    }
//
//    @Override
//    public int getContentView() {
//        return R.layout.activity_myorder_detail;
//    }
//
//    @Override
//    public void inject() {
//        DaggerPresenterComponent.builder()
//            .applicationComponent(GoShopApplication.getApplicationComponent())
//            .presenterModule(new PresenterModule(this))
//            .build()
//            .inject(this);
//    }
//
//    @Override
//    public String getScreenTitle() {
//        return ScreenHelper.getString(R.string.my_orders_title);
//    }
//
//}

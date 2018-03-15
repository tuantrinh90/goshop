package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.checkout.PaymentStatusActivity;
import com.goshop.app.presentation.model.ProductDetailModel;
import com.goshop.app.widget.adapter.WidgetPdpAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ProductDetailActivity extends BaseActivity<ProductDetailContract.Presenter>
    implements ProductDetailContract.View, WidgetPdpAdapter.OnProductDetailItemClickListener {

    @BindView(R.id.rcv_pdp_details)
    RecyclerView rcvPdpDetails;

    private WidgetPdpAdapter pdpAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo(helen) wait for api
        mPresenter.productDetailRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_product_detail;
    }

    @Override
    public void inject() {
        initPresenter();
        initRecyclerView();
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvPdpDetails.setLayoutManager(layoutManager);
        pdpAdapter = new WidgetPdpAdapter(new ArrayList<>());
        rcvPdpDetails.setAdapter(pdpAdapter);
        pdpAdapter.setOnProductDetailItemClickListener(this);
    }

    @OnClick({R.id.imageview_left_menu, R.id.imageview_right_menu,   R
        .id.tv_btn_add_to_cart, R.id.tv_btn_buy_now})
    public void onProductDetailClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.imageview_right_menu:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;

            case R.id.tv_btn_buy_now:
                startActivity(new Intent(this, PaymentStatusActivity.class));
                break;
            case R.id.tv_btn_add_to_cart:
                break;
        }
    }

    @Override
    public void productDetailRequestSuccess(List<ProductDetailModel> detailDatas) {
        //todo(helen)wait for complete
        pdpAdapter.setUpdateDatas(detailDatas);
    }

    @Override
    public void onCheckClick() {
        startActivity(new Intent(this, CheckoutActivity.class));
    }

    @Override
    public void onWriteAReviewClick() {
        startActivity(new Intent(this, RatingActivity.class));
    }

    @Override
    public void onMoreReviewClick() {
        startActivity(new Intent(this, AllReviewsActivity.class));
    }

    @Override
    public void onAskQuestionClick() {
        startActivity(new Intent(this, AllQAActivity.class));
    }

    @Override
    public void onMoreQuestionClick() {
        startActivity(new Intent(this, AllQAActivity.class));
    }
}

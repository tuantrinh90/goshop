package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.ProductItemVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;
import com.goshop.app.widget.WidgetListener.OnProductItemClickListener;
import com.goshop.app.widget.WidgetViewAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class PDPDetailActivity extends BaseActivity<PDPDetailContract.Presenter>
    implements PDPDetailContract.View , OnProductItemClickListener {

    @BindView(R.id.iv_pdp_detail_love)
    ImageView ivPdpDetailLove;

    @BindView(R.id.recyclerview_pdp_details)
    RecyclerView recyclerviewPdpDetails;

    @BindView(R.id.rl_pdp_detail_bottom)
    RelativeLayout rlPdpDetailBottom;

    @BindView(R.id.tv_btn_pdp_detail_buy)
    CustomTextView tvBtnPdpDetailBuy;

    @BindView(R.id.tv_btn_pdp_detail_cart)
    CustomTextView tvBtnPdpDetailCart;

    private WidgetViewAdapter widgetViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo(helen) wait for api
        mPresenter.pdpDetailRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_pdp_detail;
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
        recyclerviewPdpDetails.setLayoutManager(layoutManager);
        widgetViewAdapter = new WidgetViewAdapter(new ArrayList<>());
        recyclerviewPdpDetails.setAdapter(widgetViewAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.imageview_right_menu, R.id.imageview_right_cart, R
        .id.iv_pdp_detail_love, R.id.tv_btn_pdp_detail_buy, R.id
        .tv_btn_pdp_detail_cart})
    public void onPdpDetailClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.imageview_right_menu:
                break;
            case R.id.imageview_right_cart:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
            case R.id.tv_btn_pdp_detail_buy:
                break;
            case R.id.tv_btn_pdp_detail_cart:
                break;
            case R.id.iv_pdp_detail_love:
                break;
        }
    }

    @Override
    public void pdpDetailRequestSuccess(List<WidgetViewModel> detailDatas) {
        //todo(helen)wait for complete
        widgetViewAdapter.setOnProductItemClickListener(this);
        widgetViewAdapter.setUpdateDatas(detailDatas);
    }

    @Override
    public void onProductItemClick(ProductItemVM productItemVM) {
        //TODO(helen)wait for design
    }
}

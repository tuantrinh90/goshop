package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.ProductDetailModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/10.
 */

public class ProductDetailActivity extends BaseActivity<ProductDetailContract.Presenter>
    implements ProductDetailContract.View {

    @BindView(R.id.iv_pdp_love)
    ImageView ivPdpLove;

    @BindView(R.id.rcv_pdp_details)
    RecyclerView rcvPdpDetails;

    @BindView(R.id.tv_btn_pdp_add_to_cart)
    CustomTextView tvBtnPdpAddToCart;

    @BindView(R.id.tv_btn_pdp_buy_now)
    CustomTextView tvBtnPdpBuyNow;

    private ProductDetailAdapter detailAdapter;

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
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {
        initPresenter();
        initRecyclerView();
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
        detailAdapter = new ProductDetailAdapter(new ArrayList<>());
        rcvPdpDetails.setAdapter(detailAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.imageview_right_menu, R.id.imageview_right_menu_left})
    public void onPdpClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                break;
            case R.id.imageview_right_menu:
                break;
            case R.id.imageview_right_menu_left:
                break;
        }
    }

    @Override
    public void productDetailRequestSuccess(List<ProductDetailModel> detailDatas) {
        //todo(helen)wait for complete
        detailAdapter.updateDatas(detailDatas);
    }
}

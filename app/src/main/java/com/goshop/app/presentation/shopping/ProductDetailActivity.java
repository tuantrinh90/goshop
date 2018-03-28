package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomPagerCircleIndicator;
import com.goshop.app.presentation.checkout.PaymentStatusActivity;
import com.goshop.app.presentation.model.ProductDetailModel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ProductDetailActivity extends BaseActivity<ProductDetailContract.Presenter>
    implements ProductDetailContract.View, ProductDetailAdapter.OnProductDetailItemClickListener,
    PdpBannerAdapter.OnPdpBannerClickListener {

    @BindView(R.id.appbarlayout_product_detail)
    AppBarLayout appBarLayoutProductDetail;

    @BindView(R.id.indicator_product_detail_top)
    CustomPagerCircleIndicator circleIndicator;

    @BindView(R.id.rcv_pdp_details)
    RecyclerView rcvPdpDetails;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewpager_product_detail_top)
    ViewPager viewPager;

    @BindView(R.id.view_pdp_divider)
    View viewPdpDivider;

    private PdpBannerAdapter bannerAdapter;

    private ProductDetailAdapter pdpAdapter;

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
        appBarLayoutActionListener();
        initPageAdapter();
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
        pdpAdapter = new ProductDetailAdapter(this, new ArrayList<>());
        rcvPdpDetails.setAdapter(pdpAdapter);
    }

    private void appBarLayoutActionListener() {
        appBarLayoutProductDetail
            .addOnOffsetChangedListener((AppBarLayout appBarLayout, int verticalOffset) -> {
                viewPdpDivider.setVisibility(Math.abs(verticalOffset) >= appBarLayout
                    .getTotalScrollRange() ? View.VISIBLE : View.GONE);
            });
    }

    private void initPageAdapter() {
        bannerAdapter = new PdpBannerAdapter(new ArrayList<String>(), this::onBannerClick);
        viewPager
            .setAdapter(bannerAdapter);

    }

    @OnClick({R.id.imageview_left_menu, R.id.imageview_right_menu, R
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
    public void productBannerResult(List<String> imageUrls) {
        bannerAdapter.setImageUrls(imageUrls);
        circleIndicator.setViewPager(viewPager);
    }

    @Override
    public void onBannerClick() {
        startActivity(new Intent(this, PDPDetailImagesActivity.class));
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

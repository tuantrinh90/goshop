package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.data.model.PromotionSkuModel;
import com.goshop.app.data.model.SkuBannerVM;
import com.goshop.app.data.model.SkuFilterWithDataVM;
import com.goshop.app.presentation.search.FilterMenuAdapter;
import com.goshop.app.utils.PageIntentUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class PromotionSkuActivity extends BaseActivity<PromotionSkuContract.Presenter> implements
    PromotionSkuContract.View, PromotionSkuAdapter.OnPromotionSkuItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.iv_btn_filter)
    ImageView ivBtnFilter;

    @BindView(R.id.iv_sort_arrow)
    ImageView ivSortArrow;

    @BindView(R.id.ll_filter_menu)
    LinearLayout llFilterMenu;

    @BindView(R.id.ll_sort_filter_sku)
    LinearLayout llSortFilterSku;

    @BindView(R.id.recyclerview_filter)
    RecyclerView recyclerviewFilter;

    @BindView(R.id.recyclerview_sku)
    RecyclerView recyclerviewSku;

    @BindView(R.id.rl_drawer_filter)
    RelativeLayout rlDrawerFilter;

    @BindView(R.id.tv_btn_filter_clear)
    RobotoRegularTextView tvBtnFilterClear;

    @BindView(R.id.tv_btn_filter_done)
    RobotoRegularTextView tvBtnFilterDone;

    @BindView(R.id.tv_btn_sort)
    RobotoLightTextView tvBtnSort;

    @BindView(R.id.tv_filter_menu_top)
    RobotoRegularTextView tvFilterMenuTop;

    private String intentUrl = "";

    private FilterMenuAdapter menuAdapter;

    private PromotionSkuAdapter skuAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.promotionSkuRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_promotion_sku;
    }

    @Override
    public void inject() {
        hideRightMenu();
        llSortFilterSku.setVisibility(View.GONE);
        initPresenter();
        initRecyclerView();
        initFilterMenuRecyclerView();
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            intentUrl = intent.getStringExtra(PageIntentUtils.PROMOTION_BANNER_URL);
        }
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
        recyclerviewSku.setLayoutManager(layoutManager);
        skuAdapter = new PromotionSkuAdapter(new ArrayList<>());
        recyclerviewSku.setAdapter(skuAdapter);
        skuAdapter.setOnPromotionSkuItemClickListener(this);
    }

    private void initFilterMenuRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewFilter.setLayoutManager(layoutManager);
        menuAdapter = new FilterMenuAdapter(new ArrayList<>());
        recyclerviewFilter.setAdapter(menuAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.payday_treat);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void showPromotionResult(List<PromotionSkuModel> skuModels) {
        for (PromotionSkuModel skuModel : skuModels) {
            if (skuModel instanceof SkuFilterWithDataVM) {
                menuAdapter.updateDatas(((SkuFilterWithDataVM) skuModel).getFilterMenuModels());
            }
            if(skuModel instanceof SkuBannerVM) {
                ((SkuBannerVM) skuModel).setBannerUrl(intentUrl);
            }
        }
        skuAdapter.setUpdateDatas(skuModels);
    }

    @Override
    public void onFilterDrawerClick() {
        drawerLayout.openDrawer(GravityCompat.END);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_filter_clear, R.id.tv_btn_filter_done})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
            case R.id.tv_btn_filter_clear:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
            case R.id.tv_btn_filter_done:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
        }
    }
}

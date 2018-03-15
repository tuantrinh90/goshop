package com.goshop.app.presentation.home;

import com.bumptech.glide.Glide;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.BrandsDetailVM;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.search.FilterMenuAdapter;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.adapter.WidgetProductGridVerticalAdapter;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
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

public class BrandsDetailActivity extends BaseActivity<BrandsDetailContract.Presenter> implements
    BrandsDetailContract.View, OnProductItemClickListener, PopWindowUtil
    .OnPopWindowDismissListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.iv_brands_detail_logo)
    ImageView ivBrandsDetailLogo;

    @BindView(R.id.iv_btn_filter)
    ImageView ivBtnFilter;

    @BindView(R.id.iv_sort_arrow)
    ImageView ivSortArrow;

    @BindView(R.id.ll_filter_menu)
    LinearLayout llFilterMenu;

    @BindView(R.id.recyclerview_details)
    RecyclerView recyclerviewDetails;

    @BindView(R.id.recyclerview_filter)
    RecyclerView recyclerviewFilter;

    @BindView(R.id.rl_drawer_filter)
    RelativeLayout rlDrawerFilter;

    @BindView(R.id.tv_brands_detail_summary)
    CustomTextView tvBrandsDetailSummary;

    @BindView(R.id.tv_btn_filter_clear)
    CustomTextView tvBtnFilterClear;

    @BindView(R.id.tv_btn_filter_done)
    CustomTextView tvBtnFilterDone;

    @BindView(R.id.tv_btn_sort)
    CustomTextView tvBtnSort;

    private WidgetProductGridVerticalAdapter gridVerticalAdapter;

    private FilterMenuAdapter menuAdapter;

    private List<SortVM> sortVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.brandsDetailRequest(null);
        mPresenter.filterMenuRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_brands_detail;
    }

    @Override
    public void inject() {
        hideRightMenu();
        sortVMS = new ArrayList<>();
        tvBtnSort.setSelected(false);
        ivSortArrow.setSelected(false);
        initPresenter();
        initRecyclerView();
        initFilterMenuRecyclerView();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerviewDetails.setLayoutManager(layoutManager);
        gridVerticalAdapter = new WidgetProductGridVerticalAdapter(new ArrayList<>());
        gridVerticalAdapter.setOnProductItemClickListener(this);
        recyclerviewDetails.setAdapter(gridVerticalAdapter);
    }

    private void initFilterMenuRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewFilter.setLayoutManager(layoutManager);
        menuAdapter = new FilterMenuAdapter(new ArrayList<>());
        recyclerviewFilter.setAdapter(menuAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.brands);
    }

    @OnClick({R.id.imageview_left_menu, R.id.iv_sort_arrow, R.id.tv_btn_sort, R.id.iv_btn_filter,
        R.id.tv_btn_filter_clear, R.id.tv_btn_filter_done})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.iv_sort_arrow:
            case R.id.tv_btn_sort:
                ivSortArrow.setSelected(!ivSortArrow.isSelected());
                tvBtnSort.setSelected(!tvBtnSort.isSelected());
                if (tvBtnSort.isSelected()) {
                    PopWindowUtil.showsSortListPop(tvBtnSort, sortVMS, this);
                }
                break;
            case R.id.iv_btn_filter:
                drawerLayout.openDrawer(GravityCompat.END);
                break;

            case R.id.tv_btn_filter_clear:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
            case R.id.tv_btn_filter_done:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
        }
    }

    @Override
    public void brandsDetailResult(BrandsDetailVM brandsDetailVM) {
        sortVMS = brandsDetailVM.getSortVMS();
        //todo wait for api
        sortVMS.get(0).setSelect(true);
        tvBtnSort.setText(sortVMS.get(0).getTitle());

        Glide.with(this).load(brandsDetailVM.getLogoUrl()).asBitmap()
            .error(R.drawable.ic_brands_detail_logo)
            .into(ivBrandsDetailLogo);
        tvBrandsDetailSummary.setText(brandsDetailVM.getLogoSummary());
        gridVerticalAdapter.setUpdateDatas(brandsDetailVM.getFilterProductsVMS());
    }

    @Override
    public void showFilterMenu(List<FilterMenuModel> filterMenuModels) {
        menuAdapter.updateDatas(filterMenuModels);
    }

    @Override
    public void onProductItemClick(ProductsVM productItemVM) {
        startActivity(new Intent(this, ProductDetailActivity.class));
    }

    @Override
    public void onPopItemClick(int position) {
        sortVMS.get(position).setSelect(true);
        tvBtnSort.setText(sortVMS.get(position).getTitle());
    }

    @Override
    public void onDismiss() {
        ivSortArrow.setSelected(false);
        tvBtnSort.setSelected(false);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }
}

package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.BrandsDetailModel;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.widget.listener.OnFilterMenuClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class BrandsDetailActivity extends BaseActivity<BrandsDetailContract.Presenter> implements
    BrandsDetailContract.View, OnProductItemClickListener, OnFilterMenuClickListener {

    @BindView(R.id.recyclerview_details)
    RecyclerView recyclerviewDetails;

    private BrandsDetailAdapter detailAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.brandsDetailRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_brands_detail;
    }

    @Override
    public void inject() {
        hideRightMenu();
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
        recyclerviewDetails.setLayoutManager(layoutManager);
        detailAdapter = new BrandsDetailAdapter(new ArrayList<>());
        recyclerviewDetails.setAdapter(detailAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.brands);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onClick() {
        finish();
    }

    @Override
    public void brandsDetailResult(List<BrandsDetailModel> brandsDetailModels) {
        detailAdapter.setUpdateDatas(brandsDetailModels);
        detailAdapter.setOnProductItemClickListener(this);
    }

    @Override
    public void onProductItemClick(ProductsVM productItemVM) {

    }

    @Override
    public void onFilterClick() {

    }

    @Override
    public void onSortClick() {

    }
}

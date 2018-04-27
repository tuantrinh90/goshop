package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.irecyclerview.IRecyclerView;
import com.goshop.app.common.view.irecyclerview.OnLoadMoreListener;
import com.goshop.app.common.view.irecyclerview.widget.footer.LoadMoreFooterView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.model.MyEGiftModel;
import com.goshop.app.utils.PopWindowUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyEGiftCardsActivity extends BaseActivity<MyEGiftCardContract.Presenter> implements
    MyEGiftCardContract.View, MyEGiftCardsAdapter.OnActiveCardClickListener, SwipeRefreshLayout
    .OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.recyclerview_my_egift)
    IRecyclerView recyclerviewMyEgift;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private MyEGiftCardsAdapter cardsAdapter;

    private LoadMoreFooterView loadMoreFooterView;

    private PaginationData pagination;

    private List<MyEGiftModel> eGiftModels;

    private boolean isCanLoadMore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.getEGiftCardDetails(1, true);
    }

    private void initView() {
        hideRightMenu();
        initRecyclerView();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_egiftcards;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        eGiftModels = new ArrayList<>();
        swipeRefresh.setColorSchemeResources(R.color.color_main_pink);
        swipeRefresh.setOnRefreshListener(this);
        recyclerviewMyEgift.setLayoutManager(new LinearLayoutManager(this));
        cardsAdapter = new MyEGiftCardsAdapter(eGiftModels);
        cardsAdapter.setOnActiveCardClickListener(this);
        recyclerviewMyEgift.setIAdapter(cardsAdapter);
        recyclerviewMyEgift.setOnLoadMoreListener(this);
        recyclerviewMyEgift.setHasFixedSize(true);
        loadMoreFooterView = (LoadMoreFooterView) recyclerviewMyEgift.getLoadMoreFooterView();
        loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override
    public void getEGiftCardSuccess(List<MyEGiftModel> eGiftModels, PaginationData pagination) {
        // TODO: 2018/4/26  setCurrentPage(1) is hard code
        pagination.setCurrentPage(1);
        this.pagination = pagination;
        isCanLoadMore = eGiftModels.size() >= Const.LIMIT;
        if (this.pagination.getCurrentPage() == 1) {
            this.eGiftModels.clear();
        }
        this.eGiftModels.addAll(eGiftModels);
        swipeRefresh.setRefreshing(false);
        if (this.pagination.getCurrentPage() == this.pagination.getTotalPages()) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        }
        cardsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        swipeRefresh.setRefreshing(true);
        mPresenter.getEGiftCardDetails(1, false);
    }

    @Override
    public void onLoadMore() {
        if (loadMoreFooterView.canLoadMore() && isCanLoadMore) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
            mPresenter.getEGiftCardDetails(pagination.getCurrentPage() + 1, false);
        }
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_egift_cards);
    }

    @Override
    public void activeSuccess(List<MyEGiftModel> eGiftModels, PaginationData pagination) {
        // TODO: 2018/4/26  setCurrentPage(1) is hard code
        pagination.setCurrentPage(1);
        this.pagination = pagination;
        if (this.pagination.getCurrentPage() == 1) {
            eGiftModels.clear();
        }
        this.eGiftModels.addAll(eGiftModels);
        swipeRefresh.setRefreshing(false);
        if (this.pagination.getCurrentPage() == this.pagination.getTotalPages()) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        }
        cardsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewMyEgift, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewMyEgift, errorMessage);
    }

    @OnClick({R.id.imageview_left_menu})
    public void OnMyGiftClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onActivieClick(String code) {
        mPresenter.eGiftCardsRequest(code, 1);
    }

    @Override
    public void onEmptyClick() {
        //todo hard code wait for design
        Toast.makeText(this, "Please input Unique Code!", Toast.LENGTH_SHORT).show();
    }

}

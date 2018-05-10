package com.goshop.app.presentation.home;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.irecyclerview.IRecyclerView;
import com.goshop.app.common.view.irecyclerview.OnLoadMoreListener;
import com.goshop.app.common.view.irecyclerview.widget.footer.LoadMoreFooterView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.model.BrandsListVM;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BrandsFragment extends BaseFragment<BrandsContract.Presenter> implements
    BrandsContract.View, BrandsAdapter.OnBrandsItemClickListener, SwipeRefreshLayout
    .OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.recyclerview_brands)
    IRecyclerView recyclerviewBrands;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private BrandsAdapter adapter;

    private LoadMoreFooterView loadMoreFooterView;

    private PaginationData pagination;

    private List<BrandsListVM> brandsVMS;

    private boolean isCanLoadMore;

    public static BrandsFragment getInstance() {
        return new BrandsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.brandsRequest(1, true);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_brands;
    }

    public void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        brandsVMS = new ArrayList<>();
        swipeRefresh.setColorSchemeResources(R.color.color_main_pink);
        swipeRefresh.setOnRefreshListener(this);
        recyclerviewBrands.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new BrandsAdapter(brandsVMS, this);
        recyclerviewBrands.setIAdapter(adapter);
        recyclerviewBrands.setOnLoadMoreListener(this);
        recyclerviewBrands.setHasFixedSize(true);
        loadMoreFooterView = (LoadMoreFooterView) recyclerviewBrands.getLoadMoreFooterView();
        loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
    }

    @Override
    public void onBandRequestSuccess(List<BrandsListVM> brandsVMS, PaginationData pagination) {
        // TODO: 2018/4/26  setCurrentPage(1) is hard code
        pagination.setCurrentPage(1);
        this.pagination = pagination;
        isCanLoadMore = brandsVMS.size() >= Const.LIMIT;
        if (pagination.getCurrentPage() == 1) {
            this.brandsVMS.clear();
        }
        this.brandsVMS.addAll(brandsVMS);
        swipeRefresh.setRefreshing(false);
        if (pagination.getCurrentPage() == pagination.getTotalPages()) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewBrands, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String message) {
        PopWindowUtil.showRequestMessagePop(recyclerviewBrands, message);
    }

    @Override
    public void onBrandsItemClick(BrandsListVM brandsVM) {
        Intent intent = new Intent(getActivity(), BrandsDetailActivity.class);
        intent.putExtra(BrandsDetailActivity.EXTRA_BRAND_ID, brandsVM.getId());
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        swipeRefresh.setRefreshing(true);
        mPresenter.brandsRequest(1, false);
    }

    @Override
    public void onLoadMore() {
        if (loadMoreFooterView.canLoadMore() && isCanLoadMore) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
            mPresenter.brandsRequest(pagination.getCurrentPage() + 1, false);
        }
    }
}

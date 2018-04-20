package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.irecyclerview.IRecyclerView;
import com.goshop.app.common.view.irecyclerview.OnLoadMoreListener;
import com.goshop.app.common.view.irecyclerview.widget.footer.LoadMoreFooterView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.model.PointsModel;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyPointsActivity extends BaseActivity<MyPointsContract.Presenter> implements
    MyPointsContract.View, OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerview_points)
    IRecyclerView recyclerviewPoints;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private MyPointsAdapter pointsAdapter;

    private LoadMoreFooterView loadMoreFooterView;

    private PaginationData pagination;

    private List<PointsModel> pointsModels;

    private boolean isCanLoadMore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.getGoShopPointsDetails(1, true);
    }

    private void initView() {
        hideRightMenu();
        initRecyclerview();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_points;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_point);
    }

    private void initRecyclerview() {
        pointsModels = new ArrayList<>();
        swipeRefresh.setColorSchemeResources(R.color.color_main_pink);
        swipeRefresh.setOnRefreshListener(this);
        pointsAdapter = new MyPointsAdapter(pointsModels);
        recyclerviewPoints.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewPoints.setIAdapter(pointsAdapter);
        recyclerviewPoints.setOnLoadMoreListener(this);
        recyclerviewPoints.setHasFixedSize(true);
        loadMoreFooterView = (LoadMoreFooterView) recyclerviewPoints.getLoadMoreFooterView();
        loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override
    public void getPointDetailsSuccess(List<PointsModel> pointsModels, PaginationData pagination) {
        this.pagination = pagination;
        isCanLoadMore = pointsModels.size() >= Const.LIMIT;
        if (pagination.getCurrentPage() == 1) {
            this.pointsModels.clear();
        }
        this.pointsModels.addAll(pointsModels);
        swipeRefresh.setRefreshing(false);
        if (pagination.getCurrentPage() == pagination.getTotalPages()) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        }
        pointsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore() {
        if (loadMoreFooterView.canLoadMore() && isCanLoadMore) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
            mPresenter.getGoShopPointsDetails(pagination.getCurrentPage() + 1, false);
        }
    }

    @Override
    public void onRefresh() {
        swipeRefresh.setRefreshing(true);
        mPresenter.getGoShopPointsDetails(1, false);
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        swipeRefresh.setRefreshing(false);
        PopWindowUtil.showRequestMessagePop(recyclerviewPoints, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        swipeRefresh.setRefreshing(false);
        PopWindowUtil.showRequestMessagePop(recyclerviewPoints, errorMessage);
    }

    @OnClick(R.id.imageview_left_menu)
    public void onViewClicked() {
        this.finish();
    }
}

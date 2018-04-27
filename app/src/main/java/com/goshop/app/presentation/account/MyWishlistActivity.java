package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.irecyclerview.IRecyclerView;
import com.goshop.app.common.view.irecyclerview.OnLoadMoreListener;
import com.goshop.app.common.view.irecyclerview.widget.footer.LoadMoreFooterView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.WishlistVM;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyWishlistActivity extends BaseDrawerActivity<MyWishlistContract.Presenter> implements
    MyWishlistContract.View,
    OnItemMenuClickListener, PopWindowUtil.OnWishlistDeleteListener, SwipeRefreshLayout
    .OnRefreshListener, OnLoadMoreListener, MyWishlistAdapter.OnWishListItemClickListener {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_wishlist)
    IRecyclerView recyclerviewWishlist;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fl_no_data)
    FrameLayout flNoData;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private MyWishlistAdapter wishlistAdapter;

    private List<WishlistVM> wishlistVMS;

    private LoadMoreFooterView loadMoreFooterView;

    private PaginationData pagination;

    private boolean isCanLoadMore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        mPresenter.getWishlistItems(1, true);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_wishlist;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
        setCurrentMenuType(MenuUtil.MENU_TYPE_MY_WISHLIST);
        setContentView(getContentView());
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        wishlistVMS = new ArrayList<>();
        swipeRefresh.setColorSchemeResources(R.color.color_main_pink);
        swipeRefresh.setOnRefreshListener(this);
        wishlistAdapter = new MyWishlistAdapter(wishlistVMS);
        wishlistAdapter.setOnItemMenuClickListener(this);
        wishlistAdapter.setOnWishListItemClickListener(this);
        recyclerviewWishlist.setIAdapter(wishlistAdapter);
        recyclerviewWishlist.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewWishlist.setOnLoadMoreListener(this);
        recyclerviewWishlist.setHasFixedSize(true);
        loadMoreFooterView = (LoadMoreFooterView) recyclerviewWishlist.getLoadMoreFooterView();
        loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_wishlist);
    }

    @Override
    public void showWishlistItems(List<WishlistVM> wishlistVMS, PaginationData pagination) {
        // TODO: 2018/4/26  setCurrentPage(1) is hard code
        pagination.setCurrentPage(1);
        this.pagination = pagination;
        isCanLoadMore = wishlistVMS.size() >= Const.LIMIT;
        if (this.pagination.getCurrentPage() == 1) {
            this.wishlistVMS.clear();
            if (wishlistVMS.size() <= 0) {
                updateLayoutStatus(flConnectionBreak, false);
                updateLayoutStatus(recyclerviewWishlist, false);
                updateLayoutStatus(flNoData, true);
                return;
            }
        }
        this.wishlistVMS.addAll(wishlistVMS);
        swipeRefresh.setRefreshing(false);
        if (this.pagination.getCurrentPage() == this.pagination.getTotalPages()) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        }
        wishlistAdapter.notifyDataSetChanged();

    }

    @Override
    public void onRefresh() {
        swipeRefresh.setRefreshing(true);
        mPresenter.getWishlistItems(1, false);
    }

    @Override
    public void onLoadMore() {
        if (loadMoreFooterView.canLoadMore() && isCanLoadMore) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
            mPresenter.getWishlistItems(pagination.getCurrentPage() + 1, false);
        }
    }

    @Override
    public void deleteSuccess(List<WishlistVM> wishlistVMS) {
        this.wishlistVMS.clear();
        this.wishlistVMS.addAll(wishlistVMS);
        wishlistAdapter.notifyDataSetChanged();

    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewWishlist, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewWishlist, errorMessage);
        updateLayoutStatus(recyclerviewWishlist, false);
        updateLayoutStatus(flNoData, false);
        updateLayoutStatus(flConnectionBreak, true);
    }

    @Override
    public void onItemMenuClick(View parentView, Object object) {
        PopWindowUtil.showWishlistMenuPop(parentView, this, (WishlistVM) object);
    }

    @Override
    public void onWishlistDelete(WishlistVM wishlistVM) {
        mPresenter.wishlistDeleteRequest(wishlistVM.getSku());
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_add_now, R.id.tv_net_refresh})
    public void onCategoryClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }
                break;
            case R.id.tv_add_now:
                updateLayoutStatus(flNoData, false);
                startActivity(new Intent(this, MainPageActivity.class));
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                mPresenter.getWishlistItems(1, true);
                break;
        }
    }

    @Override
    public void onWishListClick(WishlistVM wishlistVM) {
        startActivity(new Intent(this, ProductDetailActivity.class));
    }
}

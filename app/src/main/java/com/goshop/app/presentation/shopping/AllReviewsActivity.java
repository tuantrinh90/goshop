package com.goshop.app.presentation.shopping;

import com.bumptech.glide.Glide;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.AllReviewsVM;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class AllReviewsActivity extends BaseActivity<AllReviewsContract.Presenter> implements
    AllReviewsContract.View {

    @BindView(R.id.scrollview_all_reviews)
    NestedScrollView scrollviewAllReviews;

    @BindView(R.id.iv_all_reviews_thumb)
    ImageView ivAllReviewsThumb;

    @BindView(R.id.ratingbar_write_review)
    RatingBar ratingbarWriteReview;

    @BindView(R.id.recyclerview_all_reviews)
    RecyclerView recyclerviewAllReviews;

    @BindView(R.id.tv_reviews_amount)
    RobotoRegularTextView tvReviewsAmount;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private AllReviewsItemAdapter reviewsItemAdapter;

    private int page = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scrollviewAllReviews.setVisibility(View.INVISIBLE);
        //todo wait for api
        mPresenter.getProductRatingReviews(page, false);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_all_reviews;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initRecyclerView();
        initSwipRefreshLayout();
    }

    private void initSwipRefreshLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.color_main_pink);
        swipeRefreshLayout.setOnRefreshListener(()->{
            page = 1;
            mPresenter.getProductRatingReviews(page, true);});
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
        recyclerviewAllReviews.setLayoutManager(layoutManager);
        reviewsItemAdapter = new AllReviewsItemAdapter(new ArrayList<>());
        recyclerviewAllReviews.setAdapter(reviewsItemAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.all_reviews);
    }

    @Override
    public void showAllReviewsResult(AllReviewsVM allReviewsVM) {
        Glide.with(this).load(allReviewsVM.getThumb()).asBitmap()
            .error(allReviewsVM.getThumbDefault())
            .into(ivAllReviewsThumb);
        ratingbarWriteReview.setRating(allReviewsVM.getStep());
        tvReviewsAmount.setText(allReviewsVM.getAmount());
        reviewsItemAdapter.setUpdateDatas(allReviewsVM.getReviewsVMS());
    }

    @Override
    public void hideDataLayout() {
        scrollviewAllReviews.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showRequestFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewAllReviews, errorMessage);
        updateLayoutStatus(flConnectionBreak,true);
    }

    @Override
    public void showNetWorkError(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewAllReviews, errorMessage);
        updateLayoutStatus(flConnectionBreak,true);
    }

    @Override
    public void showDataLayout() {
        scrollviewAllReviews.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopRefresh() {
        if(swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_net_refresh})
    public void onAllReviewsClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                page = 1;
                mPresenter.getProductRatingReviews(page, false);
                break;
        }
    }
}

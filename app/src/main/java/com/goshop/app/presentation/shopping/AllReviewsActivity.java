package com.goshop.app.presentation.shopping;

import com.bumptech.glide.Glide;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.AllReviewsVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class AllReviewsActivity extends BaseActivity<AllReviewsContract.Presenter> implements
    AllReviewsContract.View {

    @BindView(R.id.iv_all_reviews_thumb)
    ImageView ivAllReviewsThumb;

    @BindView(R.id.ratingbar_write_review)
    RatingBar ratingbarWriteReview;

    @BindView(R.id.recyclerview_all_reviews)
    RecyclerView recyclerviewAllReviews;

    @BindView(R.id.tv_reviews_amount)
    RobotoRegularTextView tvReviewsAmount;

    private AllReviewsItemAdapter reviewsItemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.allReviewsRequest(null);
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

    @OnClick({R.id.imageview_left_menu})
    public void onAllReviewsClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}

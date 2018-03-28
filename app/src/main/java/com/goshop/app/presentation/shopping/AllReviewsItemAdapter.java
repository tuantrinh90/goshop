package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.widget.ReviewsVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllReviewsItemAdapter extends RecyclerView.Adapter {

    List<ReviewsVM> reviewsVMS;

    public AllReviewsItemAdapter(
        List<ReviewsVM> reviewsVMS) {
        this.reviewsVMS = reviewsVMS;
    }

    public void setUpdateDatas(List<ReviewsVM> reviewsVMS) {
        this.reviewsVMS.clear();
        this.reviewsVMS = reviewsVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_all_reviews, parent, false);
        return new ReviewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ReviewsItemViewHolder) holder).bindingData(reviewsVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return reviewsVMS.size();
    }

    class ReviewsItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ratingbar_item_reviews)
        RatingBar ratingBar;

        @BindView(R.id.tv_reviews_date)
        RobotoLightTextView tvReviewsDate;

        @BindView(R.id.tv_reviews_detail)
        RobotoLightTextView tvReviewsDetail;

        @BindView(R.id.tv_reviews_title)
        RobotoMediumTextView tvReviewsTitle;

        @BindView(R.id.tv_reviews_user_name)
        RobotoLightTextView tvReviewsUserName;

        public ReviewsItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ReviewsVM reviewsVM) {
            ratingBar.setRating(reviewsVM.getStarStep());
            tvReviewsTitle.setText(reviewsVM.getTitle());
            tvReviewsDetail.setText(reviewsVM.getDetails());
            tvReviewsUserName.setText(reviewsVM.getUserName());
            tvReviewsDate.setText(reviewsVM.getReviewDate());
        }
    }
}

package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.ReviewsVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PDPReviewsItemAdapter extends RecyclerView.Adapter {

    List<ReviewsVM> reviewsVMS;

    public PDPReviewsItemAdapter(
        List<ReviewsVM> reviewsVMS) {
        this.reviewsVMS = reviewsVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reviews, parent,false);
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
        CustomTextView tvReviewsDate;

        @BindView(R.id.tv_reviews_detail)
        CustomTextView tvReviewsDetail;

        @BindView(R.id.tv_reviews_title)
        CustomBoldTextView tvReviewsTitle;

        @BindView(R.id.tv_reviews_user_name)
        CustomTextView tvReviewsUserName;

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

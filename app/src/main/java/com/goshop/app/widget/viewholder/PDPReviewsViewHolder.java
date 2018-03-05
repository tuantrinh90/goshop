package com.goshop.app.widget.viewholder;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.WidgetPDPReviewsVM;
import com.goshop.app.widget.adapter.PDPReviewsItemAdapter;
import com.goshop.app.widget.listener.OnReviewsViewMoreClickListener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PDPReviewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ratingbar_reviews_top)
    RatingBar ratingBar;

    @BindView(R.id.recyclerview_reviews)
    RecyclerView recyclerView;

    @BindView(R.id.tv_btn_add_more)
    CustomBoldTextView tvBtnAddMore;

    @BindView(R.id.tv_btn_review_top)
    CustomTextView tvBtnReviewTop;

    @BindView(R.id.tv_reviews_total_count)
    CustomBoldTextView tvReviewsTotalCount;

    public PDPReviewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(WidgetPDPReviewsVM pdpReviewsVM,
        OnReviewsViewMoreClickListener onReviewsViewMoreClickListener) {
        tvReviewsTotalCount.setText(pdpReviewsVM.getReviewsCounts());
        ratingBar.setRating(pdpReviewsVM.getTotalStarStep());
        tvBtnAddMore.setOnClickListener(v -> {
            onReviewsViewMoreClickListener.onReviewsMoreClick();
        });

        LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        PDPReviewsItemAdapter detailAdapter = new PDPReviewsItemAdapter(
            pdpReviewsVM.getReviewsVMS());
        recyclerView.setAdapter(detailAdapter);
    }
}

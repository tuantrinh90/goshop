package com.goshop.app.widget.listener;

public interface OnProductDetailItemClickListener {

    void onWriteAReviewClick();

    void onMoreReviewClick();

    void onAskQuestionClick();

    void onMoreQuestionClick();

    void onWishlistSelect(boolean isSelect);

    void onDeliveryCheckClick(String zipcode);
}

package com.goshop.app.widget.listener;

import android.view.View;

public interface OnProductDetailItemClickListener {

    void onWriteAReviewClick();

    void onMoreReviewClick();

    void onAskQuestionClick();

    void onMoreQuestionClick();

    void onWishlistSelect(boolean isSelect);

    void onDeliveryCheckClick(String zipcode);

    void onProductColorClick(View parentView, String name);

    void onProductSizeClick(View parentView, String name);

    void setAddCartQty(String qty);
}

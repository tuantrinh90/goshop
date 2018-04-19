package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.AllReviewsVM;

public class AllReviewsContract {

    interface View extends BaseView {

        void showAllReviewsResult(AllReviewsVM allReviewsVM);

        void hideDataLayout();

        void showRequestFailed(String errorMessage);

        void showNetWorkError(String errorMessage);

        void showDataLayout();

        void stopRefresh();
    }

    public interface Presenter extends BasePresenter<View> {

        void getProductRatingReviews(int page, boolean isRefresh);
    }

}

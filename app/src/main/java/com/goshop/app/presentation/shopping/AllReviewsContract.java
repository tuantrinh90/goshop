package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.AllReviewsVM;

import java.util.Map;

public class AllReviewsContract {

    interface View extends BaseView {

        void showAllReviewsResult(AllReviewsVM allReviewsVM);
    }

    public interface Presenter extends BasePresenter<View> {

        void allReviewsRequest(Map<String, Object> params);
    }

}

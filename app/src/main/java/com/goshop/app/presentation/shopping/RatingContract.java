package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

public class RatingContract {

    interface View extends BaseView{

        void writeReviewSuccess();

        void writeReviewFailed(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void writeReviewRequest(String title, String content, float rating);
    }
}

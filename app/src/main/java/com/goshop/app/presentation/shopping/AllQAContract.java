package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.QuestionAnswerVM;

public class AllQAContract {

    interface View extends BaseView {

        void showRequestSuccess(QuestionAnswerVM questionAnswerVM);

        void showRequestFailed(String errorMessage);

        void showNetError(String errorMessage);

        void hideDataLayout();

        void showSubmitSuccess(String successMessage);

        void stopRefresh();
    }

    public interface Presenter extends BasePresenter<View> {

        void listProductQA(int page, boolean isRefresh);

        void submitQuestions(String question);

    }

}

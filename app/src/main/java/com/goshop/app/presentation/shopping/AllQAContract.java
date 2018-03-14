package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.QuestionAnswerVM;

import java.util.Map;

public class AllQAContract {

    interface View extends BaseView {

        void showAllQAResult(QuestionAnswerVM questionAnswerVM);
    }

    public interface Presenter extends BasePresenter<View> {

        void allQARequest(Map<String, Object> params);
    }

}

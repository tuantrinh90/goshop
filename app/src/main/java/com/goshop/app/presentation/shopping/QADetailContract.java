package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.QuestionAnswerDataVM;

import java.util.List;
import java.util.Map;

public class QADetailContract {

    interface View extends BaseView{
        void showQADetail(List<QuestionAnswerDataVM> dataVMS);
    }

    public interface Presenter extends BasePresenter<View>{
        void qaDetailRequest(Map<String, Object> params);
    }
}

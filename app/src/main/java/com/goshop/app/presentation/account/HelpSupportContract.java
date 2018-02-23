package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.HelpSupportModel;

import java.util.List;
import java.util.Map;



public class HelpSupportContract {

    interface View extends BaseView {

        void showResult(List<HelpSupportModel> helpSupportModels);

        void startFAQ();

        void startContactUs();

        void startTermsAndConditions();

    }

    public interface Presenter extends BasePresenter<View> {

        void helpSupportRequest(Map<String, Object> params);
    }

}

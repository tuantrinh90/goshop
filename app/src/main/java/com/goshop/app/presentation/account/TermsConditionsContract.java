package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.TermsConditionsVM;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/1/29.
 */

public class TermsConditionsContract {

    interface View extends BaseView {

        void showResult(List<TermsConditionsVM> termsConditionsVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void termsConditionsRequest(Map<String, Object> params);
    }

}

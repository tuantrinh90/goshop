package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.FAQVM;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/1/29.
 */

public class FAQContract {

    interface View extends BaseView {

        void showResult(List<FAQVM> faqvms);
    }

    public interface Presenter extends BasePresenter<View> {

        void faqRequest(Map<String, Object> params);
    }

}

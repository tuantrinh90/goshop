package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
public class WebContentContract {

    interface View extends BaseView {

        void requestResult(String url);
    }

    public interface Presenter extends BasePresenter<View> {

        void getEcmcContent();

        void getContactUsContent();
    }

}

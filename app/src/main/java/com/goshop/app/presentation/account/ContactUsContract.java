package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ContactUsVM;

import java.util.Map;

/**
 * Created by helen on 2018/1/30.
 */

public class ContactUsContract {

    interface View extends BaseView {

        void showContactInfo(ContactUsVM contactUsVM);

        void requestResult();
    }

    public interface Presenter extends BasePresenter<View> {

        void getContactInfo();

        void contactMessageRequest(Map<String, Object> params);
    }
}

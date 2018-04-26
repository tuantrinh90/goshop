package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ContactUsVM;

import java.util.Map;

public class ContactUsContract {

    interface View extends BaseView {

        void showContactInfo(ContactUsVM contactUsVM);

        void requestResult();

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void getContactInfo();

        void contactMessageRequest(String name, String email, String mobile, String productHanding,
            String details);

    }
}

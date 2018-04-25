package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ContactUsVM;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class ContactUsPresenter extends RxPresenter<ContactUsContract.View> implements
    ContactUsContract.Presenter {

    AccountRepository accountRepository;

    public ContactUsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getContactInfo() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getContactInfo().subscribeWith(
            new DisposableObserver<ContactUsResponse>() {
                @Override
                public void onNext(ContactUsResponse contactUsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showContactInfo(getMockInfo());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void contactMessageRequest(String name, String email, String mobile,
        String productHanding, String details) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        params.put(Const.REQUEST_PARAM_NAME, name);
        params.put(Const.REQUEST_PARAM_EMAIL, email);
        params.put(Const.REQUEST_PARAM_MOBILE_NUMBER, mobile);
        params.put(Const.REQUEST_PARAM_PRODUCT_HANDLING, productHanding);
        params.put(Const.REQUEST_PARAM_DETAILS, details);
        addSubscrebe(accountRepository.contactMessageRequest(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response contactUsResponse) {
                    mView.hideLoadingBar();
                    mView.requestResult();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        ServiceApiFail serviceApiFail = (ServiceApiFail) throwable;
                        mView.showServiceErrorMessage(serviceApiFail.getErrorMessage());
                    } else {
                        mView.showNetworkErrorMessage(throwable.getMessage());
                    }
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }

    //TODO  this is mock data
    @SuppressWarnings("UnnecessaryLocalVariable")
    private ContactUsVM getMockInfo() {
        ContactUsVM contactUsVM = new ContactUsVM("wecare@goshop.com.my", "1800820088");
        return contactUsVM;
    }
}

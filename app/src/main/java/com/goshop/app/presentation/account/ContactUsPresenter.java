package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ContactUsVM;

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
    public void contactMessageRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.contactMessageRequest(params).subscribeWith(
            new DisposableObserver<ContactUsResponse>() {
                @Override
                public void onNext(ContactUsResponse contactUsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.requestResult();
                }

                @Override
                public void onComplete() {

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

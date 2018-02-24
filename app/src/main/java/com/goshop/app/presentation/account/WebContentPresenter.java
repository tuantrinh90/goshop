package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.GetWebContentReponse;
import com.goshop.app.domian.AccountRepository;

import io.reactivex.observers.DisposableObserver;

public class WebContentPresenter extends RxPresenter<WebContentContract.View> implements
    WebContentContract
    .Presenter {

    AccountRepository accountRepository;

    public WebContentPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getEcmcContent() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getEcmcContent().subscribeWith(
            new DisposableObserver<GetWebContentReponse>() {
                @Override
                public void onNext(GetWebContentReponse getWebContentReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO wait for api
                    mView.requestResult("https://app.zeplin.io/welcome");
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getContactUsContent() {
        mView.showLoadingBar();
        //TODO wait for api
        addSubscrebe(accountRepository.getContactContent().subscribeWith(
            new DisposableObserver<GetWebContentReponse>() {
                @Override
                public void onNext(GetWebContentReponse getWebContentReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO wait for api
                    mView.requestResult("https://app.zeplin.io/welcome");
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

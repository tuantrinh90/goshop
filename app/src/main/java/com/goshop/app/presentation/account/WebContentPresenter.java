package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.GetWebContentReponse;
import com.goshop.app.domian.AccountRepository;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/29.
 */

public class WebContentPresenter extends RxPresenter<WebContentContract.View> implements WebContentContract
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
                    //TODO(helen)wait for api
                    mView.requestResult("https://www.baidu.com/");
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getContactUsContent() {
        mView.showLoadingBar();
        //TODO(helen)wait for api
        addSubscrebe(accountRepository.getContactContent().subscribeWith(
            new DisposableObserver<GetWebContentReponse>() {
                @Override
                public void onNext(GetWebContentReponse getWebContentReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen)wait for api
                    mView.requestResult("https://www.baidu.com/");
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

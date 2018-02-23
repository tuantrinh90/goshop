package com.goshop.app.presentation.login;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class LoginSendConfirmationLinkPresenter extends
    RxPresenter<LoginSendConfirmationLinkContract.View> implements
    LoginSendConfirmationLinkContract.Presenter {

    AccountRepository accountRepository;

    public LoginSendConfirmationLinkPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void sendConfirmationLinkRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.sendConfirmationLinkRequest(params).subscribeWith(
            new DisposableObserver<SendConfirmationLinkReponse>() {
                @Override
                public void onNext(SendConfirmationLinkReponse sendConfirmationLinkReponse) {
                    mView.hideLoadingBar();
                    //Todo(helen)wait for api
                    mView.sendConfirmationLinkSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //Todo(helen)wait for api
                    mView.sendConfirmationLinkSuccess();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

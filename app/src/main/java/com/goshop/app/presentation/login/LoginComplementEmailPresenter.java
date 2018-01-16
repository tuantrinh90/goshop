package com.goshop.app.presentation.login;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by img on 2018/1/9.
 */

public class LoginComplementEmailPresenter extends RxPresenter<LoginComplementEmailContract.View>
    implements LoginComplementEmailContract.Presenter {

    AccountRepository accountRepository;

    public LoginComplementEmailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void complementEmailRequest(Map<String, Object> params) {

        mView.showLoadingBar();
        addSubscrebe(accountRepository.complementEmailRequest(params).subscribeWith(
            new DisposableObserver<ComplementEmailReponse>() {
                @Override
                public void onNext(ComplementEmailReponse complementEmailReponse) {
                    mView.hideLoadingBar();
                    //TODO(helen)wait for api
                    mView.complementEmailSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen)wait for api
                    mView.complementEmailSuccess();
                }

                @Override
                public void onComplete() {

                }
            }));

    }
}
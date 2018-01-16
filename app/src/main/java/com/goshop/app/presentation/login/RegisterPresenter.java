package com.goshop.app.presentation.login;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/8.
 */

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements
    RegisterContract.Presenter {

    AccountRepository accountRepository;

    @Inject
    public RegisterPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.registerRequest(params).subscribeWith(
            new DisposableObserver<UserInfo>() {
                @Override
                public void onNext(UserInfo userInfo) {
                    mView.hideLoadingBar();
                    mView.registerSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen)wait for api
                    mView.registerSuccess();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

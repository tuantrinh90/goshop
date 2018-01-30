package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.PasswordReponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/26.
 */

public class ChangePasswordPresenter extends RxPresenter<ChangePasswordContract.View> implements
    ChangePasswordContract.Presenter {

    AccountRepository accountRepository;

    public ChangePasswordPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void changePasswordRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.changePasswordRequest(params).subscribeWith(
            new DisposableObserver<PasswordReponse>() {
                @Override
                public void onNext(PasswordReponse passwordReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //todo(helen) wait for api
                    mView.changeResult();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

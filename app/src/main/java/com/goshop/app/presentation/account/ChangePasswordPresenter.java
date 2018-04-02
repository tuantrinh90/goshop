package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.PasswordResponse;
import com.goshop.app.data.model.response.ChangePasswordResponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

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
            new DisposableObserver<ChangePasswordResponse>() {
                @Override
                public void onNext(ChangePasswordResponse passwordResponse) {
                    mView.hideLoadingBar();
                    mView.success();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.failed(throwable.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

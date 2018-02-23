package com.goshop.app.presentation.login;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class LoginResetPasswordPresenter extends RxPresenter<LoginResetPasswordContract.View>
    implements LoginResetPasswordContract.Presenter {

    AccountRepository accountRepository;

    public LoginResetPasswordPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void resetPasswordRequest(Map<String, Object> params) {

        mView.showLoadingBar();
        addSubscrebe(accountRepository.resetPasswordRequest(params).subscribeWith(
            new DisposableObserver<ResetPasswordReponse>() {
                @Override
                public void onNext(ResetPasswordReponse resetPasswordReponse) {
                    mView.hideLoadingBar();
                    //TODO(helen)wait for api
                    mView.resetPwdSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen)wait for api
                    mView.resetPwdSuccess();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

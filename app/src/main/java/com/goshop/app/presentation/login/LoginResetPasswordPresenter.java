package com.goshop.app.presentation.login;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.ResetPasswordResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class LoginResetPasswordPresenter extends RxPresenter<LoginResetPasswordContract.View>
    implements LoginResetPasswordContract.Presenter {

    AccountRepository accountRepository;

    public LoginResetPasswordPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void resetPasswordRequest(String email) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_EMAIL, email);
        addSubscrebe(accountRepository.resetPasswordRequest(params).subscribeWith(
            new DisposableObserver<Response<ResetPasswordResponse>>() {
                @Override
                public void onNext(Response<ResetPasswordResponse> response) {
                    mView.hideLoadingBar();
                    mView.resetPwdSuccess();
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

                }
            }));
    }
}

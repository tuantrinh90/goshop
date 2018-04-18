package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class ChangePasswordPresenter extends RxPresenter<ChangePasswordContract.View> implements
    ChangePasswordContract.Presenter {

    AccountRepository accountRepository;

    public ChangePasswordPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void changePasswordRequest(int customerId, String currentPassword,
        String newPassword) {
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_CUSTOMER_ID, customerId);
        params.put(Const.PARAMS_OLD_PASSWORD, currentPassword);
        params.put(Const.PARAMS_NEW_PASSWORD, newPassword);
        addSubscrebe(accountRepository.changePasswordRequest(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response passwordResponse) {
                    mView.hideLoadingBar();
                    mView.onChangePasswordSuccess();
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
                    mView.hideLoadingBar();
                }
            }));
    }
}

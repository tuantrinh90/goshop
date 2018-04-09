package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.ChangePasswordResponse;
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
    public void changePasswordRequest(String customerId, String currentPassword,
        String newPassword) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_CUSTOMER_ID, "");
        params.put(Const.PARAMS_OLD_PASSWORD, currentPassword);
        params.put(Const.PARAMS_NEW_PASSWORD, newPassword);
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

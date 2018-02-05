package com.goshop.app.presentation.checkout;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.domian.AccountRepository;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2018/1/6.
 */

public class CheckoutPresenter extends RxPresenter<CheckoutContract.View> implements CheckoutContract.Presenter{
    AccountRepository accountRepository;

    @Inject
    public CheckoutPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getCheckout(String sessionKey) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.checkoutRequest(sessionKey).subscribeWith(
            new DisposableObserver<CheckoutResponse>() {
                @Override
                public void onNext(CheckoutResponse checkoutResponse) {
                    mView.hideLoadingBar();
                    mView.showCheckout(checkoutResponse);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

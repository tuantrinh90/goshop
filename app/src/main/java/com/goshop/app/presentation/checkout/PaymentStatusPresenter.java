package com.goshop.app.presentation.checkout;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.PaymentStatusVM;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class PaymentStatusPresenter extends RxPresenter<PaymentStatusContract.View> implements
    PaymentStatusContract.Presenter {

    private AccountRepository accountRepository;

    public PaymentStatusPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void paymentStatusRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.paymentStatusRequest(params).subscribeWith(
            new DisposableObserver<PaymentStatusResponse>() {
                @Override
                public void onNext(PaymentStatusResponse paymentStatusResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen) this is need decide
                    mView.showSuccessLayout(getSuccessStatus());
//                    mView.showFailedLayout(getFailedStatus());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO(helen)this is mock data
    private PaymentStatusVM getSuccessStatus() {
        return new PaymentStatusVM("", "1234567890", "", true);
    }

    //TODO(helen)this is mock data
    private PaymentStatusVM getFailedStatus() {
        return new PaymentStatusVM("wecare@goshop.com.my", "", "1800-82-0088", false);
    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.MyEGiftCardMapper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyEGiftCardPresenter extends RxPresenter<MyEGiftCardContract.View> implements
    MyEGiftCardContract.Presenter {

    private AccountRepository accountRepository;

    public MyEGiftCardPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void eGiftCardsRequest(String uniqueCode) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_EGIFT_CARD, uniqueCode);
        addSubscrebe(accountRepository.eGiftCardsRequest(params).subscribeWith(
            new DisposableObserver<Response<MyEGiftResponse>>() {
                @Override
                public void onNext(Response<MyEGiftResponse> response) {
                    mView.hideLoadingBar();
                    mView.activeSuccess();
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

    @Override
    public void getEGiftCardDetails() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getEGiftCardDetails().subscribeWith(
            new DisposableObserver<Response<MyEGiftResponse>>() {
                @Override
                public void onNext(Response<MyEGiftResponse> response) {
                    mView.hideLoadingBar();
                    mView.getEGiftCardSuccess(MyEGiftCardMapper.transform(response));
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

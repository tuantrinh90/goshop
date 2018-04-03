package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.MyEGiftCardMapper;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyEGiftCardPresenter extends RxPresenter<MyEGiftCardContract.View> implements
    MyEGiftCardContract.Presenter {

    private AccountRepository accountRepository;

    public MyEGiftCardPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void eGiftCardsRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.eGiftCardsRequest(params).subscribeWith(
            new DisposableObserver<MyEGiftResponse>() {
                @Override
                public void onNext(MyEGiftResponse myEGiftResponse) {
                    mView.hideLoadingBar();
                    mView.activeSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.activeFailed(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getEGiftCardDetails() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getEGiftCardDetails().subscribeWith(
            new DisposableObserver<MyEGiftResponse>() {
                @Override
                public void onNext(MyEGiftResponse myEGiftResponse) {
                    mView.hideLoadingBar();
                    mView.getEGiftCardSuccess(MyEGiftCardMapper.transform(myEGiftResponse));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.getEGiftCardFailed(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

}

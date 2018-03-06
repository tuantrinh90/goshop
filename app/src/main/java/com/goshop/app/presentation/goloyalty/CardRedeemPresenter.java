package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.CardRedeemVM;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class CardRedeemPresenter extends RxPresenter<CardRedeemContract.View> implements
    CardRedeemContract.Presenter {

    private AccountRepository accountRepository;

    public CardRedeemPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void cardRedeemRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.cardRedeemRequest(params).subscribeWith(
            new DisposableObserver<CardRedeemResponse>() {
                @Override
                public void onNext(CardRedeemResponse cardRedeemResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showRedeemResult(getMockCardData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void swipeRedeemRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.swipeRedeemRequest(params).subscribeWith(
            new DisposableObserver<CardRedeemResponse>() {
                @Override
                public void onNext(CardRedeemResponse cardRedeemResponse) {
                    mView.hideLoadingBar();
                    mView.swipeRedeemSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.swipeRedeemSuccess();
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    private CardRedeemVM getMockCardData() {
        return new CardRedeemVM("", R.drawable.ic_sbk, "Starbucks(Merchant)",
            "Buy 1 cup and get 1 cup", "12 Jan 2017 - 14 Jan 2017", "Kuala Lumpor");
    }
}

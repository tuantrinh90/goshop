package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.RewardsMapper;
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
    public void swipeRedeemRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.swipeRedeemRequest(params).subscribeWith(
            new DisposableObserver<Response<CardRedeemResponse>>() {
                @Override
                public void onNext(Response<CardRedeemResponse> cardRedeemResponse) {
                    mView.hideLoadingBar();
                    mView
                        .swipeRedeemSuccess(RewardsMapper.transformSwipeRedeem(cardRedeemResponse));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.swipeRedeemFailed(e.getMessage());
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }

    @Override
    public CardRedeemVM getMockData() {
        return new CardRedeemVM("", R.drawable.ic_coffee, "Starbucks(Merchant)",
            "Buy 1 cup and get 1 cup", "12 Jan 2017 - 14 Jan 2017", "Kuala Lumpor");
    }

}

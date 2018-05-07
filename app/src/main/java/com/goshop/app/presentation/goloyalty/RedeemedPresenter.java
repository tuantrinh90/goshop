package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyRewardsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class RedeemedPresenter extends RxPresenter<RedeemedContract.View> implements
    RedeemedContract.Presenter {

    private AccountRepository accountRepository;

    public RedeemedPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void redeemedRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.redeemedRequest(params).subscribeWith(
            new DisposableObserver<MyRewardsResponse>() {
                @Override
                public void onNext(MyRewardsResponse myRewardsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showRedeemedResult(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private List<GoLoyaltyDealsVM> getMockDatas() {
        GoLoyaltyDealsVM dealsVM = new GoLoyaltyDealsVM("", R.drawable.ic_deals,
            "Starbucks(Merchant)",
            "Buy 1 cup and get 1 cup", "12 Jan 2017 - 14 Jan 2017", "Kuala Lumpor");
        List<GoLoyaltyDealsVM> dealsVMS = new ArrayList<>();
        dealsVMS.add(dealsVM);
        dealsVMS.add(dealsVM);
        dealsVMS.add(dealsVM);
        return dealsVMS;
    }
}

package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.GoLoyaltyResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.presentation.model.GoLoyaltyDetailsVM;
import com.goshop.app.presentation.model.GoLoyaltyModel;
import com.goshop.app.presentation.model.GoLoyaltyTopVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class GoLoyaltyPresenter extends RxPresenter<GoLoyaltyContract.View> implements
    GoLoyaltyContract.Presenter {

    private AccountRepository accountRepository;

    public GoLoyaltyPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void goLoyaltyRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.goLoyaltyRequest(params).subscribeWith(
            new DisposableObserver<GoLoyaltyResponse>() {
                @Override
                public void onNext(GoLoyaltyResponse goLoyaltyResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showGoLoyaltyResult(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private List<GoLoyaltyModel> getMockDatas() {
        List<GoLoyaltyModel> goLoyaltyModels = new ArrayList<>();
        goLoyaltyModels.add(
            new GoLoyaltyTopVM("", R.drawable.ic_icon_user_default, "User Name", "1234567890",
                "1100"));
        GoLoyaltyDealsVM dealsVM = new GoLoyaltyDealsVM("", R.drawable.ic_deals, "Starbucks(Merchant)",
            "Buy 1 cup and get 1 cup", "12 Jan 2017 - 14 Jan 2017", "Kuala Lumpor");
        List<GoLoyaltyDealsVM> dealsVMS = new ArrayList<>();
        dealsVMS.add(dealsVM);
        dealsVMS.add(dealsVM);
        dealsVMS.add(dealsVM);
        goLoyaltyModels.add(new GoLoyaltyDetailsVM("Deals", dealsVMS));
        return goLoyaltyModels;
    }
}

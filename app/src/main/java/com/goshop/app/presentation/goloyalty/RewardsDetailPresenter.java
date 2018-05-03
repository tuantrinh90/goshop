package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyRewardsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.RewardsMapper;
import com.goshop.app.presentation.model.RewardsDetailVM;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class RewardsDetailPresenter extends RxPresenter<RewardsDetailContract.View> implements
    RewardsDetailContract.Presenter {

    private AccountRepository accountRepository;

    public RewardsDetailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void rewardsDetailRequest(Map<String, Object> params) {
        Log.d("jay", "rewardsDetailRequest: ");
        mView.showLoadingBar();
        addSubscrebe(accountRepository.rewardsDetailRequest(params).subscribeWith(
            new DisposableObserver<Response<MyRewardsResponse>>() {
                @Override
                public void onNext(Response<MyRewardsResponse> myRewardsResponse) {
                    Log.d("jay", "onNext: "+myRewardsResponse.getData().getDeal().getDealLocationResponses().size());
                    mView.hideLoadingBar();
                    mView.showRewardsDetails(RewardsMapper.transformDealDetail(myRewardsResponse));
                }

                @Override
                public void onError(Throwable e) {
                    Log.d("jay", "onError: "+e.getMessage());
                    mView.hideLoadingBar();
                    mView.showError(e.getMessage());
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }

    //todo wait for api
    private RewardsDetailVM getMockData() {
        List<String> terms = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            terms.add("Voucher information information");
        }
        return new RewardsDetailVM("Merchant Name", "", R.drawable.ic_sbk, "Promotion Title",
            "12 Jan 2017 - 14 Jan 2017", "12 Locations", "15 days Left!!", "",
            R.drawable.ic_coffee, "Promo Detail",
            "Voucher information information information information information information " +
                "information information Voucher information information information information " +
                "information information information informationVo " +
                "faefagadsgfa agere jdajfjafjalkdl lkjluh", "Promo Terms and Conditions",
            terms);
    }


}

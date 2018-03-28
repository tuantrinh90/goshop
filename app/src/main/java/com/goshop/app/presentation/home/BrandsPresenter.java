package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.BrandsVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class BrandsPresenter extends RxPresenter<BrandsContract.View> implements
    BrandsContract.Presenter {

    private AccountRepository accountRepository;

    public BrandsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void brandsRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.brandsRequest(params)
            .subscribeWith(new DisposableObserver<BrandsResponse>() {
                @Override
                public void onNext(BrandsResponse brandsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    //todo wait for api
                    mView.showResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO this is mock data ,will delete
    private List<BrandsVM> getMockData() {
        List<BrandsVM> brandsVMS = new ArrayList<>();
        BrandsVM brandsVM = new BrandsVM();
        brandsVMS.add(brandsVM);
        brandsVMS.add(brandsVM);
        return brandsVMS;
    }
}

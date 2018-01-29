package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Administrator on 2018/1/6.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter{
    AccountRepository accountRepository;

    @Inject
    public HomePresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getHome(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.homeRequest(params).subscribeWith(
            new DisposableObserver<HomeResponse>() {
                @Override
                public void onNext(HomeResponse homeResponse) {
                    mView.hideLoadingBar();
                    mView.showHome(homeResponse);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {

                }
            }));
        ;
    }
}

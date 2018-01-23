package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.Weather;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;

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
    public void getWeather() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getWeather().subscribeWith(new DisposableObserver<Weather>(){

            @Override
            public void onNext(Weather weather) {
                mView.hideLoadingBar();
                mView.showWeather(weather);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.hideLoadingBar();
                if(throwable instanceof ServiceApiFail){
                    //show api return faild message
                    mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                }else{
                    // show net work error Message
                    mView.showNetwordErrorMessage();
                }

            }

            @Override
            public void onComplete() {

            }
        }));
    }

}

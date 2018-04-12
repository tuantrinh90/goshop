package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.domian.AccountDataRepository;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SplashPresenter extends RxPresenter<SplashContract.View> implements
    SplashContract.Presenter {

    private static final int SPLASH_SCREEN_PERIOD = 2;

    private AccountDataRepository repository;

    public SplashPresenter(AccountDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delayToJump() {
        Observable.timer(SPLASH_SCREEN_PERIOD, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Long>() {
                @Override
                public void onSubscribe(@NonNull Disposable disposable) {
                    addSubscrebe(disposable);
                }

                @Override
                public void onNext(@NonNull Long number) {
                    mView.onDelaySuccess();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                }

                @Override
                public void onComplete() {
                }
            });
    }
}

package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.domian.AccountDataRepository;
import com.goshop.app.presentation.model.FlagsVM;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class SplashPresenter extends RxPresenter<SplashContract.View> implements
    SplashContract.Presenter {

    private static final int SPLASH_SCREEN_PERIOD = 1;

    private AccountDataRepository accountDataRepository;

    public SplashPresenter(AccountDataRepository repository) {
        this.accountDataRepository = repository;
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
                    mView.onDelayFinished();
                }

                @Override
                public void onError(@NonNull Throwable e) {
                }

                @Override
                public void onComplete() {
                }
            });
    }

    @Override
    public void getUserInfo() {
        addSubscrebe(accountDataRepository.getUserInfo()
            .subscribeWith(new DisposableObserver<UserData>() {
                @Override
                public void onNext(UserData response) {
                    mView.checkLoginSuccess(response);
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getFlags() {
        addSubscrebe(accountDataRepository.getFlags()
            .subscribeWith(new DisposableObserver<FlagsVM>() {
                @Override
                public void onNext(FlagsVM response) {
                    mView.getFlagsSuccess(response);
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void saveFlags(boolean isLoadLocalData, String type) {
        FlagsVM flagsVM = new FlagsVM();
        flagsVM.setLoadLocalDataFlag(true);
        addSubscrebe(accountDataRepository.saveFlags(flagsVM)
            .subscribeWith(new DisposableObserver<Object>() {
                @Override
                public void onNext(Object response) {
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}
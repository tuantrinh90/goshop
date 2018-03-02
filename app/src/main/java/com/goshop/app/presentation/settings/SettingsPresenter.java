package com.goshop.app.presentation.settings;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class SettingsPresenter extends RxPresenter<SettingsContract.View> implements
    SettingsContract.Presenter {

    AccountRepository accountRepository;

    public SettingsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void settingsLogoutRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.settingsLogoutRequest(params).subscribeWith(
            new DisposableObserver<SettingsLogoutResponse>() {
                @Override
                public void onNext(SettingsLogoutResponse settingsLogoutResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.logoutResult();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

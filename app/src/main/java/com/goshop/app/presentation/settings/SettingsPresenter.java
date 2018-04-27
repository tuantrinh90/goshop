package com.goshop.app.presentation.settings;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class SettingsPresenter extends RxPresenter<SettingsContract.View> implements
    SettingsContract.Presenter {

    AccountRepository accountRepository;

    public SettingsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void settingsLogoutRequest() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.settingsLogoutRequest(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response settingsLogoutResponse) {
                    mView.logoutSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        ServiceApiFail serviceApiFail = (ServiceApiFail) throwable;
                        mView.showServiceErrorMessage(serviceApiFail.getErrorMessage());
                    } else {
                        mView.showNetworkErrorMessage(throwable.getMessage());
                    }
                }

                @Override
                public void onComplete() {
                }
            }));
    }

    @Override
    public void clearUserInfo() {
        addSubscrebe(accountRepository.clearUserInfo()
            .subscribeWith(new DisposableObserver<Boolean>() {
                @Override
                public void onNext(Boolean response) {
                    mView.hideLoadingBar();
                    mView.userInfoClearedSucceed(response);
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();

                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }

    @Override
    public void getUserInfo() {
        addSubscrebe(accountRepository.getUserInfo()
            .subscribeWith(new DisposableObserver<UserData>() {
                @Override
                public void onNext(UserData response) {
                    mView.onUserInfoGetSuccess(response);
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

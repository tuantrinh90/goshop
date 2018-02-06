package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/26.
 */

public class NotificationPresenter extends RxPresenter<NotificationContract.View> implements
    NotificationContract.Presenter {

    private AccountRepository accountRepository;

    public NotificationPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void notificationRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.notificationRequest(params).subscribeWith(
            new DisposableObserver<NotificationsResponse>() {
                @Override
                public void onNext(NotificationsResponse notificationsResponse) {
                    mView.hideLoadingBar();
                    mView.notificationResult(notificationsResponse);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

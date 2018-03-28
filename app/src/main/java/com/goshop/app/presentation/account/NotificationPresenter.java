package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.NotificationVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

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
                    mView.notificationResult(getMockData());
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

    //todo this is mock data
    private List<NotificationVM> getMockData() {
        List<NotificationVM> notificationVMS = new ArrayList<>();
        notificationVMS.add(new NotificationVM(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "12:00 1/2/18"));
        notificationVMS.add(new NotificationVM(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "12:00 1/2/18"));
        notificationVMS.add(new NotificationVM(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "12:00 1/2/18"));

        return notificationVMS;
    }
}

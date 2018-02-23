package com.goshop.app.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    protected CompositeDisposable mCompositeSubscription;

    @Override
    public void attachView(T mvpView) {
        mView = mvpView;
    }

    protected void addSubscrebe(Disposable subscription) {

        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeDisposable();
        }
        mCompositeSubscription.add(subscription);
    }

    public void unSubscrebe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscrebe();
    }
}

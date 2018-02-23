package com.goshop.app.presentation.myorder;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class MyOrderPresenter extends RxPresenter<MyOrderContract.View> implements
    MyOrderContract.Presenter {

    AccountRepository accountRepository;

    @Inject
    public MyOrderPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getOrderList(Map<String, Object> params) {
        mView.showSwipeLayout();
        addSubscrebe(accountRepository.myOrderListRequest(params)
            .subscribeWith(new DisposableObserver<MyOrderListResponse>() {

                @Override
                public void onNext(MyOrderListResponse response) {
                    mView.closeSwipeLayout();
                    mView.showOrderList(response);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.closeSwipeLayout();
                    if (throwable instanceof ServiceApiFail) {
                        //show api return faild message
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        // show net work error Message
                        mView.showNetwordErrorMessage();
                    }

                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getOrderDetail(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.myOrderDetailRequest(params)
            .subscribeWith(new DisposableObserver<MyOrderDetailReponse>() {

                @Override
                public void onNext(MyOrderDetailReponse response) {
                    mView.hideLoadingBar();
                    mView.showOrderDetail(response);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        //show api return faild message
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
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

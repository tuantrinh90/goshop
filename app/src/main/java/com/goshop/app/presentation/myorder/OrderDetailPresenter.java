package com.goshop.app.presentation.myorder;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.OrderDetailResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.OrderDetailMapper;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class OrderDetailPresenter extends RxPresenter<OrderDetailContract.View> implements
    OrderDetailContract.Presenter {

    private AccountRepository accountRepository;

    public OrderDetailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getOrderDetail() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.getOrderDetail(params).subscribeWith(
            new DisposableObserver<Response<OrderDetailResponse>>() {
                @Override
                public void onNext(Response<OrderDetailResponse> response) {
                    mView.hideLoadingBar();
                    mView.showOrderDetailResult(OrderDetailMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    if (e instanceof ServiceApiFail) {
                        mView.showErrorMessage(((ServiceApiFail) e).getErrorMessage());
                    } else {
                        mView.showNetBreak();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

}

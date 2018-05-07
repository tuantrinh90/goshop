package com.goshop.app.presentation.myorder;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.ListOrderMapper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyOrdersPresenter extends RxPresenter<MyOrdersContract.View> implements
    MyOrdersContract.Presenter {

    private AccountRepository accountRepository;

    public MyOrdersPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getListOrder(int page, boolean isRefresh) {
        if(!isRefresh) {
            mView.showLoadingBar();
        }
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_PAGE, page);
        params.put(Const.PARAMS_LIMIT, Const.LIMIT);
        addSubscrebe(accountRepository.getListOrder(params).subscribeWith(
            new DisposableObserver<Response<MyOrderListResponse>>() {
                @Override
                public void onNext(Response<MyOrderListResponse> response) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    mView.showMyOrdersResult(ListOrderMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    if(e instanceof ServiceApiFail) {
                        mView.showGetListFailedMessage(((ServiceApiFail) e).getErrorMessage());
                    } else {
                        mView.showNetError();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));

    }


}

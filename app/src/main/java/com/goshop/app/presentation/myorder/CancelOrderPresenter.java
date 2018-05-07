package com.goshop.app.presentation.myorder;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.OrderMetadataResponse;
import com.goshop.app.data.model.response.OrderResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.OrderMetaMapper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class CancelOrderPresenter extends RxPresenter<CancelOrderContract.View>
    implements CancelOrderContract.Presenter {

    private AccountRepository accountRepository;

    public CancelOrderPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void cancelOrderRequest(String name, String email, String mobile, String handing,
        String reasonCode, String reasonDetail) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_CUSTOMER_ID, Const.CUSTOMER_ID);
        params.put(Const.PARAMS_NAME, name);
        params.put(Const.PARAMS_EMAIL, email);
        params.put(Const.PARAMS_MOBILE_NUMBER, mobile);
        params.put(Const.PARAMS_PRODUCT_HANDLING, handing);
        params.put(Const.PARAMS_CANCEL_REASON_CODE, reasonCode);
        params.put(Const.PARAMS_CANCEL_DETAIL_REASON, reasonDetail);
        addSubscrebe(accountRepository.cancelOrderRequest(params).subscribeWith(
            new DisposableObserver<Response<OrderResponse>>() {
                @Override
                public void onNext(Response<OrderResponse> response) {
                    mView.hideLoadingBar();
                    mView.cancelRequestSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        mView.cancelRequestFailed(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.cancelRequestNetError(throwable.getMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getOrderMetadata() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);

        addSubscrebe(accountRepository.getOrderMetadata(params).subscribeWith(
            new DisposableObserver<Response<OrderMetadataResponse>>() {
                @Override
                public void onNext(Response<OrderMetadataResponse> response) {
                    mView.hideLoadingBar();
                    mView.setReasonCode(OrderMetaMapper.transformReturnReason(response.getData()));
                    mView.setReasonDetail(OrderMetaMapper.transformReturnProductResolution(response.getData()));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        mView.cancelRequestFailed(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.cancelRequestNetError(throwable.getMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }


}

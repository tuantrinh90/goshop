package com.goshop.app.presentation.checkout;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.ApplyVMMapper;
import com.goshop.app.presentation.mapper.CheckoutMapper;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class CheckoutPresenter extends RxPresenter<CheckoutContract.View> implements
    CheckoutContract.Presenter {

    AccountRepository accountRepository;

    @Inject
    public CheckoutPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void checkoutRequest(String quoteId, String addressId) {
        mView.showLoadingBar();
        Map<String , Object> params = new HashMap<>();
        addSubscrebe(accountRepository.checkoutRequest(params).subscribeWith(
            new DisposableObserver<Response<CheckoutResponse>>() {
                @Override
                public void onNext(Response<CheckoutResponse> response) {
                    mView.hideLoadingBar();
                    mView.checkoutRequestSuccess(CheckoutMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showErrorMessage(throwable.getMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void applyCoupon(String couponCode, String cartId) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_CUSTOMER_ID, Const.CUSTOMER_ID);
        params.put(Const.PARAMS_COUPON_CODE, couponCode);
        params.put(Const.PARAMS_CART_ID, cartId);
        addSubscrebe(accountRepository.applyCoupon(params).subscribeWith(
            new DisposableObserver<Response<ApplyCouponResponse>>() {
                @Override
                public void onNext(Response<ApplyCouponResponse> response) {
                    mView.hideLoadingBar();
                    mView.applyCouponSuccess(ApplyVMMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showErrorMessage(e.getMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void applyPoints(String point, String cartId) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_CUSTOMER_ID, Const.CUSTOMER_ID);
        params.put(Const.PARAMS_GOSHOP_POINT, point);
        params.put(Const.PARAMS_CART_ID, cartId);
        addSubscrebe(accountRepository.applyGoShopPoints(params).subscribeWith(
            new DisposableObserver<Response<ApplyPointsResponse>>() {
                @Override
                public void onNext(Response<ApplyPointsResponse> response) {
                    mView.hideLoadingBar();
                    mView.applyPointsSuccess(ApplyVMMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showErrorMessage(e.getMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void applyEGiftCard(String egiftCard, String cartId) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_CUSTOMER_ID, Const.CUSTOMER_ID);
        params.put(Const.PARAMS_EGIFT_CARD, egiftCard);
        params.put(Const.PARAMS_CART_ID, cartId);
        addSubscrebe(accountRepository.applyEGiftCard(params).subscribeWith(
            new DisposableObserver<Response<ApplyEGiftResponse>>() {
                @Override
                public void onNext(Response<ApplyEGiftResponse> response) {
                    mView.hideLoadingBar();
                    mView.applyEGiftSuccess(ApplyVMMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showErrorMessage(e.getMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void paymentRequest() {
        //todo wait for api
        mView.showPaymentProgress();
    }
}

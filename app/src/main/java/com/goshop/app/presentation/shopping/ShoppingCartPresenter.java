package com.goshop.app.presentation.shopping;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ShoppingCartResponse;
import com.goshop.app.data.model.request.AddRemoveCartRequest;
import com.goshop.app.data.model.request.common.CartRequestData;
import com.goshop.app.data.model.response.CartDataResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.ApplyVMMapper;
import com.goshop.app.presentation.mapper.ShoppingCartMapper;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class ShoppingCartPresenter extends RxPresenter<ShoppingCartContract.View> implements
    ShoppingCartContract.Presenter {

    private AccountRepository accountRepository;

    private ProductRepository productRepository;

    public ShoppingCartPresenter(AccountRepository accountRepository,
        ProductRepository productRepository) {
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void viewCartDetails(int page, boolean isRefresh) {
        if(!isRefresh) {
            mView.showLoadingBar();
        }
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        addSubscrebe(accountRepository.viewCartDetails(params).subscribeWith(
            new DisposableObserver<Response<ShoppingCartResponse>>() {
                @Override
                public void onNext(Response<ShoppingCartResponse> response) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    mView.showCartDetail(ShoppingCartMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    if (throwable instanceof ServiceApiFail) {
                        mView.showErrorMessage(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.showNetError();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void removeFromCartRequest(String sku, String qty) {
        mView.showLoadingBar();
        AddRemoveCartRequest request = new AddRemoveCartRequest();
        CartRequestData cartRequestData = new CartRequestData();
        cartRequestData.setSku(sku);
        cartRequestData.setQty(qty);
        cartRequestData.setStoreId(Const.STORE_ID);
        cartRequestData.setWebsiteId(Const.WEBSITE_ID);
        request.setRequest(cartRequestData);
        addSubscrebe(productRepository.removeFromCartRequest(request).subscribeWith(
            new DisposableObserver<Response<CartDataResponse>>() {
                @Override
                public void onNext(Response<CartDataResponse> response) {
                    mView.hideLoadingBar();
                    mView.removeSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    String errorMessage;
                    if (throwable instanceof ServiceApiFail) {
                        errorMessage = ((ServiceApiFail) throwable).getErrorMessage();
                    } else {
                        errorMessage = throwable.getMessage().toString();
                    }
                    mView.removeFailed(errorMessage);
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void addWishlistRequest(String skuId) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_SKU, skuId);
        addSubscrebe(accountRepository.addWishlistRequest(params).subscribeWith(
            new DisposableObserver<Response<MyWishlistResponse>>() {
                @Override
                public void onNext(Response<MyWishlistResponse> response) {
                    mView.hideLoadingBar();
                    mView.addWishlistSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showErrorMessage(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void applyCoupon( String couponCode, String cartId) {
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
                    mView.applySuccess(ApplyVMMapper.transform(response.getData()));
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


}

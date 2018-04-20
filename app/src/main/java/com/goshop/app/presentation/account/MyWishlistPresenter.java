package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.MyWishlistMapper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyWishlistPresenter extends RxPresenter<MyWishlistContract.View> implements
    MyWishlistContract.Presenter {

    private AccountRepository accountRepository;

    public MyWishlistPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void wishlistDeleteRequest(String sku) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_SKU, sku);
        addSubscrebe(accountRepository.wishlistDeleteRequest(params).subscribeWith(
            new DisposableObserver<Response<MyWishlistResponse>>() {
                @Override
                public void onNext(Response<MyWishlistResponse> response) {
                    mView.hideLoadingBar();
                    mView.deleteSuccess(MyWishlistMapper.transform(response));
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
                    mView.hideLoadingBar();
                }
            }));
    }

    @Override
    public void getWishlistItems(int page, boolean isShowLoading) {
        if (isShowLoading) mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_PAGE, page);
        params.put(Const.REQUEST_PARAM_LIMIT, Const.LIMIT);
        addSubscrebe(accountRepository.getWishlistItems(params).subscribeWith(
            new DisposableObserver<Response<MyWishlistResponse>>() {
                @Override
                public void onNext(Response<MyWishlistResponse> response) {
                    mView.hideLoadingBar();
                    mView.showWishlistItems(MyWishlistMapper.transform(response),response.getData().getPagination());
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
                    mView.hideLoadingBar();
                }
            }));
    }

}

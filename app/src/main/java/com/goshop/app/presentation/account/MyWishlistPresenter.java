package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyWishlistResponse;
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
    public void wishlistDeleteRequest(int websiteId, int storeId, String sku) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, websiteId);
        params.put(Const.PARAMS_STORE_ID, storeId);
        params.put(Const.PARAMS_SKU, sku);
        addSubscrebe(accountRepository.wishlistDeleteRequest(params).subscribeWith(
            new DisposableObserver<MyWishlistResponse>() {
                @Override
                public void onNext(MyWishlistResponse myWishlistResponse) {
                    mView.hideLoadingBar();
                    mView.deleteSuccess(MyWishlistMapper.transform(myWishlistResponse));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showError(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getWishlistItems() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getWishlistItems().subscribeWith(
            new DisposableObserver<MyWishlistResponse>() {
                @Override
                public void onNext(MyWishlistResponse myWishlistResponse) {
                    mView.hideLoadingBar();
                    mView.showWishlistItems(MyWishlistMapper.transform(myWishlistResponse));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showError(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

}

package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.MyWishlistResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyWishlistPresenter extends RxPresenter<MyWishlistContract.View> implements
    MyWishlistContract.Presenter {

    private AccountRepository accountRepository;

    public MyWishlistPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void myWishlistRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.myWishlistRequest(params).subscribeWith(
            new DisposableObserver<MyWishlistResponse>() {
                @Override
                public void onNext(MyWishlistResponse myWishlistResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    //todo wait for api
//                    mView.showNodata();
                    mView.showWishlistResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mockdata
    private List<ProductsVM> getMockData() {
        ProductsVM productsVM = new ProductsVM();
        ProductPriceRMVM rmvm = new ProductPriceRMVM("25% OFF", "149", "200");
        ProductPriceVM priceVM = new ProductPriceVM(rmvm);
        productsVM.setImage("");
        productsVM.setTitle("Manjung Korean Crispy Seaweed 2");
        productsVM.setPriceVM(priceVM);
        List<ProductsVM> productsVMS = new ArrayList<>();
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        return productsVMS;
    }
}

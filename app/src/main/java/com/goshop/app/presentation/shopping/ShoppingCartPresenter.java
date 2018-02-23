package com.goshop.app.presentation.shopping;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ShoppingCartApplyVM;
import com.goshop.app.presentation.model.ShoppingCartCheckoutVM;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.ShoppingCartProductVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class ShoppingCartPresenter extends RxPresenter<ShoppingCartContract.View> implements
    ShoppingCartContract.Presenter {

    private AccountRepository accountRepository;

    public ShoppingCartPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void shoppingCartRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        //TODO(helen) wait for api
        addSubscrebe(accountRepository.shoppingCartRequest(params).subscribeWith(
            new DisposableObserver<ShoppingCartResponse>() {
                @Override
                public void onNext(ShoppingCartResponse shoppingCartResponse) {
                    mView.hideLoadingBar();
                    //TODO(helen) wait for api
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen) wait for api
                    mView.showCartDetail(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO(helen)this is mockdata
    private List<ShoppingCartModel> getMockDatas() {
        List<ShoppingCartModel> cartModels = new ArrayList<>();
        cartModels.add(
            new ShoppingCartProductVM("Manjung Korean Crispy Seaweed (Sea Salt)", "Color: Blue",
                "RM 269.00", "RM 119.00", 0, 3));

        cartModels.add(
            new ShoppingCartProductVM("Manjung Korean Crispy Seaweed (Sea Salt)", "Color: Blue",
                "RM 269.00", "RM 119.00", 0, 3));

        cartModels.add(new ShoppingCartApplyVM());
        cartModels.add(new ShoppingCartCheckoutVM());
        return cartModels;
    }
}

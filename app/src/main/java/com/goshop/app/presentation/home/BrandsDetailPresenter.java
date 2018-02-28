package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.BrandsDetailFilterListVM;
import com.goshop.app.presentation.model.BrandsDetailModel;
import com.goshop.app.presentation.model.BrandsDetailTopVM;
import com.goshop.app.presentation.model.widget.ProductFilterListVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class BrandsDetailPresenter extends RxPresenter<BrandsDetailContract.View> implements
    BrandsDetailContract.Presenter {

    private AccountRepository accountRepository;

    public BrandsDetailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void brandsDetailRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.brandsDetailRequest(params).subscribeWith(
            new DisposableObserver<BrandsResponse>() {

                @Override
                public void onNext(BrandsResponse brandsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.brandsDetailResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private List<BrandsDetailModel> getMockData() {
        List<BrandsDetailModel> brandsDetailModels = new ArrayList<>();
        brandsDetailModels.add(new BrandsDetailTopVM());
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

        brandsDetailModels.add(new BrandsDetailFilterListVM(new ProductFilterListVM(productsVMS)));
        return brandsDetailModels;
    }
}

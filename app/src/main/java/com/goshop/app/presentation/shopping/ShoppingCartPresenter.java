package com.goshop.app.presentation.shopping;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ShoppingCartApplyVM;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.ShoppingCartProductVM;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductCartListVM;
import com.goshop.app.presentation.model.widget.ProductListModel;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;

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

        List<CarouselItemsVM> itemsVMS = new ArrayList<>();
        CarouselItemsVM itemsVM = new CarouselItemsVM("http://a.hiphotos.baidu" +
            ".com/image/pic/item/4e4a20a4462309f788a28152790e0cf3d6cad6a4.jpg");
        CarouselItemsVM itemsVM1 = new CarouselItemsVM("http://g.hiphotos.baidu" +
            ".com/image/pic/item/7aec54e736d12f2ee7ed822044c2d56284356881.jpg");
        itemsVMS.add(itemsVM);
        itemsVMS.add(itemsVM1);
        List<ShoppingCartModel> cartModels = new ArrayList<>();
        ProductsVM productsVM = new ProductsVM();
        ProductPriceRMVM rmvm = new ProductPriceRMVM("25% OFF", "149", "200");
        ProductPriceVM priceVM = new ProductPriceVM(rmvm);
        productsVM.setImage("");
        productsVM.setTitle("Manjung Korean Crispy Seaweed 2");
        productsVM.setPriceVM(priceVM);
        List<ProductListModel> listModels = new ArrayList<>();
        listModels.add(new ProductCartListVM(productsVM));
        listModels.add(new ProductCartListVM(productsVM));
        //todo this may add banner when need this widget
//        cartModels.add(new ProductCartBannerVM(itemsVMS));
        cartModels.add(new ShoppingCartProductVM(listModels));
        cartModels.add(new ShoppingCartApplyVM());
        return cartModels;
    }
}

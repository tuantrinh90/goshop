package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.WidgetViewReponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.CarouselAutoPlayVM;
import com.goshop.app.presentation.model.widget.CarouselDataVM;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductDataVM;
import com.goshop.app.presentation.model.widget.ProductItemVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.presentation.model.widget.WidgetOnAirVM;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/2/10.
 */

public class HomePagePresenter extends RxPresenter<HomePageContract.View> implements
    HomePageContract.Presenter {

    AccountRepository accountRepository;

    public HomePagePresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void homePageRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.homePageRequest(params).subscribeWith(
            new DisposableObserver<WidgetViewReponse>() {
                @Override
                public void onNext(WidgetViewReponse widgetViewReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen) wait for api
                    mView.homePageResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO(helen) this is mock data
    private List<WidgetViewModel> getMockData() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(getWidgetBanners());
        widgetViewModels.addAll(getWidgetOnAirVMS());
        widgetViewModels.addAll(getSinglePicture());
        widgetViewModels.add(getWidgetProductScrollerVM("Trending Now"));
        widgetViewModels.addAll(getSinglePicture());
        widgetViewModels.add(getWidgetProductScrollerVM("Best Seller"));
        widgetViewModels.addAll(getSinglePicture());
        widgetViewModels.add(getWidgetProductScrollerVM("TV Special"));
        return widgetViewModels;
    }

    //TODO(helen) this is mock data
    private WidgetCarouselVM getWidgetBanners() {
        CarouselAutoPlayVM autoPlayVM = new CarouselAutoPlayVM(1000, true);
        List<CarouselItemsVM> itemsVMS = new ArrayList<>();
        CarouselItemsVM itemsVM = new CarouselItemsVM("http://a.hiphotos.baidu" +
            ".com/image/pic/item/4e4a20a4462309f788a28152790e0cf3d6cad6a4.jpg");
        CarouselItemsVM itemsVM1 = new CarouselItemsVM("http://g.hiphotos.baidu" +
            ".com/image/pic/item/7aec54e736d12f2ee7ed822044c2d56284356881.jpg");
        CarouselItemsVM itemsVM2 = new CarouselItemsVM("http://img843.ph.126.net/HQO2EzKsZ30Kvp03799Gyg==/883831426873459781.jpg");
        CarouselItemsVM itemsVM3 = new CarouselItemsVM("http://g.hiphotos.baidu" +
            ".com/image/pic/item/9a504fc2d56285356bd508329aef76c6a7ef63e8.jpg");
        itemsVMS.add(itemsVM);
        itemsVMS.add(itemsVM1);
        itemsVMS.add(itemsVM2);
        itemsVMS.add(itemsVM3);
        CarouselDataVM carouselDataVM = new CarouselDataVM(itemsVMS);
        return new WidgetCarouselVM(autoPlayVM, carouselDataVM);
    }

    //TODO(helen) this is mock data
    private List<WidgetOnAirVM> getWidgetOnAirVMS() {
        List<WidgetOnAirVM> widgetOnAirVMS = new ArrayList<>();
        widgetOnAirVMS.add(
            new WidgetOnAirVM("", "", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 239.00",
                "RM 119.00", "30% OFF"));
        return widgetOnAirVMS;
    }

    //TODO(helen) this is mock data
    private List<WidgetSinglePictureVM> getSinglePicture() {
        List<WidgetSinglePictureVM> singlePictureVMS = new ArrayList<>();
        singlePictureVMS.add(new WidgetSinglePictureVM("", R.mipmap.detail_top_demo));
        return singlePictureVMS;
    }

    //TODO(helen) this is mock data
    private WidgetProductScrollerVM getWidgetProductScrollerVM(String title) {
        ProductPriceRMVM productPriceRMVM = new ProductPriceRMVM("25% OFF", "149", "200");
        ProductPriceVM productPriceVM = new ProductPriceVM(productPriceRMVM);
        List<String> attributes = new ArrayList<>();
        attributes.add("New");
        ProductItemVM productItemVM = new ProductItemVM(R.mipmap.bought, "",
            "Bloom By Naelofar Hijab (3pcs set)", attributes, productPriceVM);
        List<ProductItemVM> productItemVMS = new ArrayList<>();
        productItemVMS.add(productItemVM);
        productItemVMS.add(productItemVM);
        productItemVMS.add(productItemVM);
        productItemVMS.add(productItemVM);
        ProductDataVM productDataVM = new ProductDataVM(productItemVMS);
        return new WidgetProductScrollerVM(title, productDataVM);
    }
}

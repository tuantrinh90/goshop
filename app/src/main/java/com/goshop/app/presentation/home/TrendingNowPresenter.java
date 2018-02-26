package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.BaseWidgetResponse;
import com.goshop.app.data.model.response.WidgetListResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.WidgetViewMapper;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.OfferListItemsVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.widget.WidgetTitleExpandVM;
import com.goshop.app.presentation.model.widget.WidgetVideoPlayerVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class TrendingNowPresenter extends RxPresenter<TrendingNowContract.View> implements
    TrendingNowContract.Presenter {

    AccountRepository accountRepository;

    public TrendingNowPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void trendingNowRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.trendingNowRequest(params).subscribeWith(
            new DisposableObserver<WidgetListResponse>() {
                @Override
                public void onNext(WidgetListResponse widgetListResponse) {
                    mView.hideLoadingBar();
                    List<BaseWidgetResponse> baseWidgetRepons = widgetListResponse.getWidgetlist();
                    Log.d("TrendingNowPresenter", "size:" + baseWidgetRepons.size());
                    mView.trendingNowResult(WidgetViewMapper.transform(widgetListResponse));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen) wait for api
                    mView.trendingNowResult(getMockData());
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
        widgetViewModels.add(getWidgetVideoPlayerVMs());
        widgetViewModels.add(getSinglePicture());
        widgetViewModels.addAll(getWidgetProductScrollerVM("Trending Now"));
        widgetViewModels.add(getSinglePicture());
        widgetViewModels.addAll(getWidgetProductScrollerVM("Best Seller"));
        widgetViewModels.add(getSinglePicture());
        widgetViewModels.addAll(getWidgetProductScrollerVM("TV Special"));
        return widgetViewModels;
    }

    //TODO(helen) this is mock data
    private WidgetCarouselVM getWidgetBanners() {
        List<CarouselItemsVM> itemsVMS = new ArrayList<>();
        CarouselItemsVM itemsVM = new CarouselItemsVM("http://a.hiphotos.baidu" +
            ".com/image/pic/item/4e4a20a4462309f788a28152790e0cf3d6cad6a4.jpg");
        CarouselItemsVM itemsVM1 = new CarouselItemsVM("http://g.hiphotos.baidu" +
            ".com/image/pic/item/7aec54e736d12f2ee7ed822044c2d56284356881.jpg");
        CarouselItemsVM itemsVM2 = new CarouselItemsVM(
            "http://img843.ph.126.net/HQO2EzKsZ30Kvp03799Gyg==/883831426873459781.jpg");
        CarouselItemsVM itemsVM3 = new CarouselItemsVM("http://g.hiphotos.baidu" +
            ".com/image/pic/item/9a504fc2d56285356bd508329aef76c6a7ef63e8.jpg");
        itemsVMS.add(itemsVM);
        itemsVMS.add(itemsVM1);
        itemsVMS.add(itemsVM2);
        itemsVMS.add(itemsVM3);
        return new WidgetCarouselVM(true, 1000, itemsVMS);
    }

    //TODO(helen) this is mock data
    private WidgetVideoPlayerVM getWidgetVideoPlayerVMs() {
        List<VideoPlayerItemsVM> videoPlayerItemsVMS = new ArrayList<>();
        VideoPlayerItemsVM videoPlayerItemsVM = new VideoPlayerItemsVM();
        videoPlayerItemsVM.setName("CH118");
        ProductsVM productsVM = new ProductsVM();
        ProductPriceRMVM rmvm = new ProductPriceRMVM("25% OFF", "RM 149.00", "RM 200.00");
        ProductPriceVM priceVM = new ProductPriceVM(rmvm);
        productsVM.setImage("");
        productsVM.setTitle("Manjung Korean Crispy Seaweed 2");
        productsVM.setPriceVM(priceVM);
        List<ProductsVM> productsVMS = new ArrayList<>();
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        videoPlayerItemsVM.setProductsVMS(productsVMS);
        videoPlayerItemsVMS.add(videoPlayerItemsVM);
        videoPlayerItemsVMS.add(videoPlayerItemsVM);
        videoPlayerItemsVMS.add(videoPlayerItemsVM);
        videoPlayerItemsVMS.add(videoPlayerItemsVM);
        return new WidgetVideoPlayerVM("On Air", "TV Schedule", videoPlayerItemsVMS);
    }

    //TODO(helen) this is mock data
    private WidgetSinglePictureVM getSinglePicture() {
        OfferListItemsVM offerListItemsVM = new OfferListItemsVM(R.drawable.ic_detail_top_demo, "",
            "");
        List<OfferListItemsVM> itemsVMS = new ArrayList<>();
        itemsVMS.add(offerListItemsVM);
        return new WidgetSinglePictureVM(itemsVMS);
    }

    //TODO(helen) this is mock data
    private List<WidgetViewModel> getWidgetProductScrollerVM(String title) {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM(title));

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
        widgetViewModels.add(new WidgetProductScrollerVM(productsVMS));

        return widgetViewModels;
    }
}

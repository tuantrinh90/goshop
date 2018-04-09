package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.TrendingBannerVM;
import com.goshop.app.presentation.model.TrendingHorizontalProductsVM;
import com.goshop.app.presentation.model.TrendingNowModel;
import com.goshop.app.presentation.model.TrendingSingleBannerVM;
import com.goshop.app.presentation.model.TrendingVideoVM;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;

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
            new DisposableObserver<TrendingNowResponse>() {
                @Override
                public void onNext(TrendingNowResponse response) {
                    mView.hideLoadingBar();
                    //todo wait for api
                    /*List<BaseWidgetResponse> baseWidgetRepons = widgetListResponse
                    .getWidgetlist();
                    Log.d("TrendingNowPresenter", "size:" + baseWidgetRepons.size());
                    mView.trendingNowResult(WidgetViewMapper.transform(widgetListResponse));*/
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
    private List<TrendingNowModel> getMockData() {
        List<TrendingNowModel> models = new ArrayList<>();
        models.add(getTopBanners());
        models.add(getVideoVM());
        models.add(getSingleBanner());
        models.add(getHorizontalProductsVM("Trending Now"));
        models.add(getSingleBanner());
        models.add(getHorizontalProductsVM("Best Seller"));
        models.add(getSingleBanner());
        models.add(getHorizontalProductsVM("TV Special"));
        return models;
    }

    //TODO(helen) this is mock data
    private TrendingBannerVM getTopBanners() {
        List<CarouselItemsVM> itemsVMS = new ArrayList<>();
        CarouselItemsVM itemsVM = new CarouselItemsVM("");
        CarouselItemsVM itemsVM1 = new CarouselItemsVM("");
        CarouselItemsVM itemsVM2 = new CarouselItemsVM("");
        CarouselItemsVM itemsVM3 = new CarouselItemsVM("");
        itemsVMS.add(itemsVM);
        itemsVMS.add(itemsVM1);
        itemsVMS.add(itemsVM2);
        itemsVMS.add(itemsVM3);
        return new TrendingBannerVM(itemsVMS, true, 2000);
    }

    //TODO(helen) this is mock data
    private TrendingVideoVM getVideoVM() {
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
        return new TrendingVideoVM("On Air", "TV Schedule", videoPlayerItemsVMS);
    }

    //TODO(helen) this is mock data
    private TrendingSingleBannerVM getSingleBanner() {
        CarouselItemsVM itemsVM = new CarouselItemsVM("http://a.hiphotos.baidu" +
            ".com/image/pic/item/4e4a20a4462309f788a28152790e0cf3d6cad6a4.jpg");
        return new TrendingSingleBannerVM(itemsVM);
    }

    //TODO(helen) this is mock data
    private TrendingHorizontalProductsVM getHorizontalProductsVM(String title) {
        ProductsVM productsVM = new ProductsVM();
        ProductPriceRMVM rmvm = new ProductPriceRMVM("25% OFF", "RM 149.00", "RM 200.00");
        ProductPriceVM priceVM = new ProductPriceVM(rmvm);
        productsVM.setImage("");
        productsVM.setTitle("Manjung Korean Crispy Seaweed 2");
        productsVM.setPriceVM(priceVM);
        List<ProductsVM> productsVMS = new ArrayList<>();
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        return new TrendingHorizontalProductsVM(title, productsVMS);
    }
}

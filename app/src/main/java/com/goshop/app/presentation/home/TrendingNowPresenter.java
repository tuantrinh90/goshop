package com.goshop.app.presentation.home;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.BannerResponse;
import com.goshop.app.data.model.response.OnAirScheduleResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.TrendingMapper;
import com.goshop.app.presentation.model.TrendingHorizontalProductsVM;
import com.goshop.app.presentation.model.TrendingNowModel;
import com.goshop.app.presentation.model.TrendingSingleBannerVM;
import com.goshop.app.presentation.model.TrendingVideoVM;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class TrendingNowPresenter extends RxPresenter<TrendingNowContract.View> implements
    TrendingNowContract.Presenter {

    AccountRepository accountRepository;

    ProductRepository productRepository;

    List<TrendingNowModel> trendingNowModels = new ArrayList<>();

    public TrendingNowPresenter(AccountRepository accountRepository,
        ProductRepository productRepository) {
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
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
                    mView.trendingNowResult(WidgetViewMapper.transformBanner(widgetListResponse));*/
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getHomeBanner() {
        mView.showLoadingBar();
        HashMap<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        addSubscrebe(productRepository.getHomeBanner(params).subscribeWith(
            new DisposableObserver<Response<BannerResponse>>() {
                @Override
                public void onNext(Response<BannerResponse> response) {
                    mView.onBannerRequestSuccess(TrendingMapper.transformBanner(response));

                }

                @Override
                public void onError(Throwable throwable) {
                    mView.onBannerRequestFailure(throwable.getMessage());
                }

                @Override
                public void onComplete() {
                }
            }));
    }

    public void getOnAirSchedule(Context context) {
        HashMap<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        addSubscrebe(productRepository.getOnAirSchedule(params).subscribeWith(
            new DisposableObserver<Response<OnAirScheduleResponse>>() {
                @Override
                public void onNext(Response<OnAirScheduleResponse> response) {
                    // TODO: 2018/4/25  hard code need api return
                    trendingNowModels.add(new TrendingVideoVM("On Air", "TV Schedule",
                        TrendingMapper.transformOnAirSchedule(response)));
                    getMockData();
                    mView.onAirScheduleRequestSuccess(trendingNowModels);
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.onAirScheduleRequestFailure(throwable.getMessage());
                    mView.hideLoadingBar();
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }

    private void getMockData() {
        trendingNowModels.add(getSingleBanner());
        trendingNowModels.add(getHorizontalProductsVM("Trending Now"));
        trendingNowModels.add(getSingleBanner());
        trendingNowModels.add(getHorizontalProductsVM("Best Seller"));
        trendingNowModels.add(getSingleBanner());
        trendingNowModels.add(getHorizontalProductsVM("TV Special"));
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

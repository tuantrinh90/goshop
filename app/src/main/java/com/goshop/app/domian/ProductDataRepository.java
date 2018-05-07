package com.goshop.app.domian;

import com.goshop.app.Const;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.response.CategoryResponse;
import com.goshop.app.data.model.request.AddRemoveCartRequest;
import com.goshop.app.data.model.response.CartDataResponse;
import com.goshop.app.data.model.response.ProductDetailResponse;
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.response.BannerResponse;
import com.goshop.app.data.model.response.DeliveryCheckResponse;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.response.OnAirScheduleResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.data.source.ProductDataSource;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProductDataRepository implements ProductRepository {

    private ProductDataSource productCloudDataSource;

    private ProductDataSource productLocalDataSource;

    @Inject
    public ProductDataRepository(
        @Named("cloudProductDataSource") ProductDataSource productCloudDataSource,
        @Named("localProductDataSource") ProductDataSource productLocalDataSource) {
        this.productCloudDataSource = productCloudDataSource;
        this.productLocalDataSource = productLocalDataSource;
    }

    @Override
    public Observable<Response<BrandsResponse>> brandsRequest(Map<String, Object> params) {
        return getServerData(productCloudDataSource.brandsRequest(params));
    }

    @Override
    public Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params) {
        return productCloudDataSource.brandsDetailRequest(params);
    }

    @Override
    public Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params) {
        return productCloudDataSource.searchFilterRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params) {
        return productCloudDataSource.searchResultResponse(params);
    }

    @Override
    public Observable<Response<MyPointsResponse>> getGoShopPointsDetails(
        Map<String, Object> params) {
        return getServerData(productCloudDataSource.getGoShopPointsDetails(params));
    }

    @Override
    public Observable<Response<ProductDetailResponse>> getProductDetails(
        Map<String, Object> params) {
        return getServerData(productCloudDataSource.getProductDetails(params));
    }

    @Override
    public Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params) {
        return productCloudDataSource.promotionSkuRequest(params);
    }

    @Override
    public Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params) {
        return productCloudDataSource.promotionBannerRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params) {
        return productCloudDataSource.promotionListRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<CategoryResponse>> getCategory(Map<String, Object> params) {
        return productCloudDataSource.getCategory(params)
            .concatMap(response -> {
                if (isSuccess(response.getMessage().getStatus())) {
                    return Observable.just(response);
                } else {
                    return Observable
                        .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<CategoryResponse> categoryRightMenuRequest(Map<String, Object> params) {
        return productCloudDataSource.categoryRightMenuRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params) {
        return productCloudDataSource.categoryDetailRequest(params);
    }

    @Override
    public Observable<Response> writeReviewRequest(Map<String, Object> params) {
        return getServerDataMessage(productCloudDataSource.writeReviewRequest(params));
    }

    @Override
    public Observable<Response<QuestionAnswerResponse>> listProductQA(Map<String, Object> params) {
        return getServerData(productCloudDataSource.listProductQA(params));
    }

    @Override
    public Observable<Response> submitQuestions(Map<String, Object> params) {
        return getServerDataMessage(productCloudDataSource.submitQuestions(params));
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        return productCloudDataSource.qaDetailRequest(params);
    }

    @Override
    public Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(
        Map<String, Object> params) {
        return getServerData(productCloudDataSource.deliveryCheckRequest(params));
    }

    @Override
    public Observable<Response<BannerResponse>> getHomeBanner(
        HashMap<String, Object> params) {
        return getServerData(productCloudDataSource.getHomeBanner(params));
    }

    @Override
    public Observable<Response<OnAirScheduleResponse>> getOnAirSchedule(
        HashMap<String, Object> params) {
        return productCloudDataSource.getOnAirSchedule(params)
            .concatMap(response -> {
                // TODO: 2018/4/23 need api
//                if (isSuccess(response.getMessage().getStatus())) {
                if (true) {
                    return Observable.just(response);
                } else {
                    return Observable
                        .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response<CartDataResponse>> addToCartRequest(AddRemoveCartRequest request) {
        return getServerData(productCloudDataSource.addToCartRequest(request));
    }

    public Observable<Response<CartDataResponse>> removeFromCartRequest(
        AddRemoveCartRequest request) {
        return getServerData(productCloudDataSource.removeFromCartRequest(request));
    }

    @Override
    public Observable<Response<CartDataResponse>> updateCartRequest(Map<String, Object> params) {
        return getServerData(productCloudDataSource.updateCartRequest(params));
    }

    private boolean isSuccess(String status) {
        return Const.SUCCESS_STATUS.equals(status.toLowerCase());
    }

    private <T> Observable<Response<T>> getServerData(Observable<Response<T>> observable) {
        return observable.concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<Response> getServerDataMessage(Observable<Response> observable) {
        return observable.concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}

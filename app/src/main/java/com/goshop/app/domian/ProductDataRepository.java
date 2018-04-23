package com.goshop.app.domian;

import com.goshop.app.Const;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.CategoryMenuResponse;
import com.goshop.app.data.model.ProductDetailResponse;
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

import android.util.Log;

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
        return productCloudDataSource.brandsRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
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
        return productCloudDataSource.getGoShopPointsDetails(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params) {
        return productCloudDataSource.productDetailRequest(params);
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
    public Observable<CategoryMenuResponse> getCategoryLeftMenu() {
        return productCloudDataSource.getCategoryLeftMenu();
    }

    @Override
    public Observable<CategoryMenuResponse> categoryRightMenuRequest(Map<String, Object> params) {
        return productCloudDataSource.categoryRightMenuRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params) {
        return productCloudDataSource.categoryDetailRequest(params);
    }

    @Override
    public Observable<Response> writeReviewRequest(Map<String, Object> params) {
        return productCloudDataSource.writeReviewRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<QuestionAnswerResponse>> listProductQA(Map<String, Object> params) {
        return productCloudDataSource.listProductQA(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response> submitQuestions(Map<String, Object> params) {
        return productCloudDataSource.submitQuestions(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        return productCloudDataSource.qaDetailRequest(params);
    }

    @Override
    public Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(
        Map<String, Object> params) {
        return productCloudDataSource.deliveryCheckRequest(params)
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
    public Observable<Response<BannerResponse>> getHomeBanner(HashMap<String, Object> params) {
        return productCloudDataSource.getHomeBanner(params)
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
    public Observable<Response<OnAirScheduleResponse>> getOnAirSchedule(
        HashMap<String, Object> params) {
        return productCloudDataSource.getOnAirSchedule(params)
            .concatMap(response -> {
                // TODO: 2018/4/23 this api message object need adjudt
//                if (isSuccess(response.getMessage().getStatus())) {
                if (true) {
                    return Observable.just(response);
                } else {
                    return Observable
                        .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private boolean isSuccess(String status) {
        return Const.SUCCESS_STATUS.equals(status);
    }
}

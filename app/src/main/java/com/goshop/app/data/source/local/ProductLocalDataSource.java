package com.goshop.app.data.source.local;

import com.goshop.app.data.LocalApi;
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
import com.goshop.app.data.source.ProductDataSource;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ProductLocalDataSource implements ProductDataSource {

    private LocalApi localApi;

    @Inject
    public ProductLocalDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<Response<BrandsResponse>> brandsRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<MyPointsResponse>> getGoShopPointsDetails(
        Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ProductDetailResponse>> getProductDetails(
        Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<CategoryResponse>> getCategory(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<CategoryResponse> categoryRightMenuRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response> writeReviewRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<QuestionAnswerResponse>> listProductQA(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response> submitQuestions(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(
        Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<BannerResponse>> getHomeBanner(HashMap<String, Object> params) {
        return null;
    }

    public Observable<Response<CartDataResponse>> addToCartRequest(AddRemoveCartRequest request) {
        return null;
    }

    @Override
    public Observable<Response<OnAirScheduleResponse>> getOnAirSchedule(
        HashMap<String, Object> params) {
        return null;
    }

    public Observable<Response<CartDataResponse>> removeFromCartRequest(
        AddRemoveCartRequest request) {
        return null;
    }

    @Override
    public Observable<Response<CartDataResponse>> updateCartRequest(Map<String, Object> params) {
        return null;
    }
}

package com.goshop.app.data.source.cloud;

import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.CategoryMenuResponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.response.DeliveryCheckResponse;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.source.ProductDataSource;
import com.goshop.app.utils.ServiceData;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ProductCloudDataSource implements ProductDataSource {

    private RestApi restApi;

    @Inject
    public ProductCloudDataSource(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<BrandsResponse> brandsRequest(Map<String, Object> params) {
        return restApi.brandsRequest(params);
    }

    @Override
    public Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params) {
        return restApi.brandsDetailRequest(params);
    }

    @Override
    public Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params) {
        return restApi.searchFilterRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params) {
        return restApi.searchResultResponse(params);
    }

    @Override
    public Observable<Response<MyPointsResponse>> getGoShopPointsDetails() {
        return restApi.getGoShopPointsDetails();
    }

    @Override
    public Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params) {
        return restApi.productDetailRequest(params);
    }

    @Override
    public Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params) {
        return restApi.promotionSkuRequest(params);
    }

    @Override
    public Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.promotionBannerRequest(params);
        return ServiceData.getPromotionBannerLists();
    }

    @Override
    public Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.promotionListRequest(params);
        return ServiceData.getPromotionListData();
    }

    @Override
    public Observable<CategoryMenuResponse> getCategoryLeftMenu() {
        return restApi.getCategoryLeftMenu();
    }

    @Override
    public Observable<CategoryMenuResponse> categoryRightMenuRequest(Map<String, Object> params) {
        return restApi.categoryRightMenuRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params) {
        return restApi.categoryDetailRequest(params);
    }

    @Override
    public Observable<Response> writeReviewRequest(Map<String, Object> params) {
        return restApi.writeReviewRequest(params);
    }


    @Override
    public Observable<Response<QuestionAnswerResponse>> allQARequest(Map<String, Object> params) {
        return restApi.allQARequest(params);
    }

    @Override
    public Observable<Response> submitQuestions(Map<String, Object> params) {
        return restApi.submitQuestions(params);
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        return restApi.qaDetailRequest(params);
    }

    @Override
    public Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(
        Map<String, Object> params) {
        return restApi.deliveryCheckRequest(params);
    }
}

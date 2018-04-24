package com.goshop.app.data.source;

import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.CategoryMenuResponse;
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

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public interface ProductDataSource {

    Observable<Response<BrandsResponse>> brandsRequest(Map<String, Object> params);

    Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params);

    Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params);

    Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params);

    Observable<Response<MyPointsResponse>> getGoShopPointsDetails(Map<String, Object> params);

    Observable<Response<ProductDetailResponse>> getProductDetails(Map<String, Object> params);

    Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params);

    Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params);

    Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params);

    Observable<CategoryMenuResponse> getCategoryLeftMenu();

    Observable<CategoryMenuResponse> categoryRightMenuRequest(Map<String, Object> params);

    Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params);

    Observable<Response> writeReviewRequest(Map<String, Object> params);

    Observable<Response<QuestionAnswerResponse>> listProductQA(Map<String, Object> params);

    Observable<Response> submitQuestions(Map<String, Object> params);

    Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params);

    Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(Map<String, Object> params);

    Observable<Response<BannerResponse>> getHomeBanner(HashMap<String, Object> params);

    Observable<Response<OnAirScheduleResponse>> getOnAirSchedule(HashMap<String, Object> params);

    Observable<Response<CartDataResponse>> addToCartRequest(AddRemoveCartRequest request);

    Observable<Response<CartDataResponse>> removeFromCartRequest(AddRemoveCartRequest request);
}

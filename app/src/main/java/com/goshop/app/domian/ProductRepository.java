package com.goshop.app.domian;

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

import java.util.Map;

import io.reactivex.Observable;

public interface ProductRepository {

    Observable<BrandsResponse> brandsRequest(Map<String, Object> params);

    Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params);

    Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params);

    Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params);

    Observable<Response<MyPointsResponse>> getGoShopPointsDetails(Map<String, Object> params);

    Observable<ProductDetailResponse> getProductDetails(Map<String, Object> params);

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
}

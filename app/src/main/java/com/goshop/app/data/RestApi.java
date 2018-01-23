package com.goshop.app.data;

import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface RestApi {

    io.reactivex.Observable<GetWeatherResponse> getWeather(String id);

    io.reactivex.Observable<UserInfo> getUser(String username,String password);

    io.reactivex.Observable<UserInfo> registerRequest(Map<String, Object> params);

    io.reactivex.Observable<ComplementEmailReponse> complementEmailRequest(
        Map<String, Object> params);

    Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params);

    Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(Map<String, Object> params);

    Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params);

    Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params);

    Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params);

    Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params);

    Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params);
}

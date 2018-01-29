package com.goshop.app.data.source.local;

import com.goshop.app.data.LocalApi;
import com.goshop.app.data.model.AddressReponse;
import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.GetWebContentReponse;
import com.goshop.app.data.model.PasswordReponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ProfileReponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.source.AccountDataSource;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public class AccountLocalDataSource implements AccountDataSource {

    private LocalApi localApi;

    @Inject
    public AccountLocalDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<UserInfo> getUserInfo(String userId) {
        return null;
    }

    @Override
    public Observable<UserInfo> getUserInfo(String username, String password) {
        return null;
    }

    @Override
    public Observable<GetWeatherResponse> getWeather() {
        return null;
    }

    @Override
    public Observable<UserInfo> registerRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<HomeResponse> homeRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyOrderDetailReponse> myOrderDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ComplementEmailReponse> complementEmailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(
        Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params) {
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
    public Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params) {
        return null;
    }

    public Observable<PasswordReponse> changePasswordRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ProfileReponse> editProfileRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AddressReponse> addAddressRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AddressReponse> myAddressRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<GetWebContentReponse> getEcmcContent() {
        return null;
    }

    public Observable<GetWebContentReponse> getContactContent() {
        return null;
    }
}

package com.goshop.app.data.source.cloud;

import com.goshop.app.data.RestApi;
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
import com.goshop.app.utils.ServiceData;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public class AccountCloudDataSource implements AccountDataSource {

    private RestApi restApi;

    @Inject
    public AccountCloudDataSource(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<UserInfo> getUserInfo(String id) {
        return null;
    }

    @Override
    public Observable<UserInfo> getUserInfo(String username, String password) {
        return restApi.getUser(username, password);
    }

    @Override
    public Observable<GetWeatherResponse> getWeather() {
        return restApi.getWeather("");
    }

    @Override
    public Observable<UserInfo> registerRequest(Map<String, Object> params) {
        return restApi.registerRequest(params);
    }

    @Override
    public Observable<HomeResponse> homeRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.homeRequest(params);
        return ServiceData.getBaseData();
    }

    @Override
    public Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.myOrderListRequest(params);
        return ServiceData.getMyOrderLists();
    }

    @Override
    public Observable<MyOrderDetailReponse> myOrderDetailRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.myOrderDetailRequest(params);
        return ServiceData.getMyOrderDetail();
    }

    @Override
    public Observable<ComplementEmailReponse> complementEmailRequest(Map<String, Object> params) {
        return restApi.complementEmailRequest(params);
    }

    @Override
    public Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params) {
        return restApi.resetPasswordRequest(params);
    }

    @Override
    public Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(
        Map<String, Object> params) {
        return restApi.sendConfirmationLinkRequest(params);
    }

    @Override
    public Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params) {
        return restApi.productDetailRequest(params);
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
    public Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.promotionListRequest(params);
        return ServiceData.getPromotionListData();
    }

    @Override
    public Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.promotionBannerRequest(params);
        return ServiceData.getPromotionBannerLists();
    }

    @Override
    public Observable<ProfileReponse> editProfileRequest(Map<String, Object> params) {
        return restApi.editProfileRequest(params);
    }

    @Override
    public Observable<AddressReponse> addAddressRequest(Map<String, Object> params) {
        return restApi.addAddressRequest(params);
    }

    @Override
    public Observable<AddressReponse> myAddressRequest(Map<String, Object> params) {
        return restApi.myAddressRequest(params);
    }

    @Override
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
        return restApi.shoppingCartRequest(params);
    }

    @Override
    public Observable<GetWebContentReponse> getEcmcContent() {
        return restApi.getEcmcContent();
    }

    @Override
    public Observable<GetWebContentReponse> getContactContent() {
        return restApi.getContactContent();
    }

    @Override
    public Observable<PasswordReponse> changePasswordRequest(Map<String, Object> params) {
        return restApi.changePasswordRequest(params);
    }
}

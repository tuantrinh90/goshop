package com.goshop.app.data.source.cloud;

import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.AllDealsResponse;
import com.goshop.app.data.model.AllReviewsResponse;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.ComplementEmailResponse;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.data.model.FAQResponse;
import com.goshop.app.data.model.GetWebContentResponse;
import com.goshop.app.data.model.GoLoyaltyResponse;
import com.goshop.app.data.model.HelpSupportResponse;
import com.goshop.app.data.model.MyRewardsResponse;
import com.goshop.app.data.model.OrderDetailResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.QuestionAnswerResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.MyOrderDetailResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.ProfileMetadataResponse;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.ResetPasswordResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.source.AccountDataSource;
import com.goshop.app.utils.ServiceData;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AccountCloudDataSource implements AccountDataSource {

    private RestApi restApi;

    @Inject
    public AccountCloudDataSource(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<TrendingNowResponse> trendingNowRequest(Map<String, Object> params) {
        return restApi.trendingNowRequest(params);
    }

    @Override
    public Observable<Response<MyEGiftResponse>> eGiftCardsRequest(Map<String, Object> params) {
        return restApi.eGiftCardsRequest(params);
    }

    @Override
    public Observable<Response<MyEGiftResponse>> getEGiftCardDetails() {
        return restApi.getEGiftCardDetails();
    }

    @Override
    public Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params) {
        return restApi.goLoyaltyRequest(params);
    }

    @Override
    public Observable<AllDealsResponse> allDealsRequest(Map<String, Object> params) {
        return restApi.allDealsRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> expiredRequest(Map<String, Object> params) {
        return restApi.expiredRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> pendingRequest(Map<String, Object> params) {
        return restApi.pendingRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> redeemedRequest(Map<String, Object> params) {
        return restApi.redeemedRequest(params);
    }

    @Override
    public Observable<CardRedeemResponse> cardRedeemRequest(Map<String, Object> params) {
        return restApi.cardRedeemRequest(params);
    }

    @Override
    public Observable<CardRedeemResponse> swipeRedeemRequest(Map<String, Object> params) {
        return restApi.swipeRedeemRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> rewardsDetailRequest(Map<String, Object> params) {
        return restApi.rewardsDetailRequest(params);
    }

    @Override
    public Observable<Response<MyWishlistResponse>> wishlistDeleteRequest(
        Map<String, Object> params) {
        return restApi.wishlistDeleteRequest(params);
    }

    @Override
    public Observable<Response<MyWishlistResponse>> addWishlistRequest(Map<String, Object> params) {
        return restApi.addWishlistRequest(params);
    }

    @Override
    public Observable<Response<MyWishlistResponse>> getWishlistItems() {
        return restApi.getWishlistItems();
    }

    @Override
    public Observable<ProductDetailResponse> pdpDetailRequest(Map<String, Object> params) {
        return restApi.pdpDetailRequest(params);
    }

    @Override
    public Observable<AllReviewsResponse> allReviewsRequest(Map<String, Object> params) {
        return restApi.allReviewsRequest(params);
    }

    @Override
    public Observable<Response> registerRequest(Map<String, Object> params) {
        return restApi.registerRequest(params);
    }

    @Override
    public Observable<HomeResponse> homeRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.homeRequest(params);
        return ServiceData.getBaseData();
    }

    @Override
    public Observable<CheckoutResponse> checkoutRequest(String sessionKey) {
        //TODO joyson temp code
//        return restApi.checkoutRequest(sessionKey);
        return ServiceData.getCheckout();
    }

    @Override
    public Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.myOrderListRequest(params);
        return ServiceData.getMyOrderLists();
    }

    @Override
    public Observable<MyOrderListResponse> myOrdersRequest(Map<String, Object> params) {
        return restApi.myOrdersRequest(params);
    }

    @Override
    public Observable<OrderDetailResponse> orderDetailRequest(Map<String, Object> params) {
        return restApi.orderDetailRequest(params);
    }

    @Override
    public Observable<MyOrderDetailResponse> myOrderDetailRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.myOrderDetailRequest(params);
        return ServiceData.getMyOrderDetail();
    }

    @Override
    public Observable<NotificationsResponse> notificationRequest(Map<String, Object> params) {
        //TODO joyson temp code
//        return restApi.notificationRequest(params);
        return ServiceData.getNotification();
    }

    @Override
    public Observable<ComplementEmailResponse> complementEmailRequest(Map<String, Object> params) {
        return restApi.complementEmailRequest(params);
    }

    @Override
    public Observable<Response<ResetPasswordResponse>> resetPasswordRequest(
        Map<String, Object> params) {
        return restApi.resetPasswordRequest(params);
    }

    @Override
    public Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
        Map<String, Object> params) {
        return restApi.sendConfirmationLinkRequest(params);
    }

    @Override
    public Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params) {
        return restApi.productDetailRequest(params);
    }

    @Override
    public Observable<Response> changePasswordRequest(Map<String, Object> params) {
        return restApi.changePasswordRequest(params);
    }

    @Override
    public Observable<Response<ProfileResponse>> editProfileRequest(Map<String, Object> params) {
        return restApi.editProfileRequest(params);
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(Map<String, Object> params) {
        return restApi.addAddressRequest(params);
    }

    @Override
    public Observable<Response<AddressResponse>> addAddressRequest(AddressRequest addressRequest) {
        return restApi.addAddressRequest(addressRequest);
    }

    @Override
    public Observable<Response<AddressResponse>> editAddressRequest(AddressRequest addressRequest) {
        return restApi.editAddressRequest(addressRequest);
    }

    @Override
    public Observable<Response<AddressResponse>> getAddressList() {
        return restApi.getAddressList();
    }

    @Override
    public Observable<AddressResponse> editAddressRequest(Map<String, Object> params) {
        return restApi.editAddressRequest(params);
    }

    @Override
    public Observable<AddressResponse> myAddressRequest(Map<String, Object> params) {
        return restApi.myAddressRequest(params);
    }

    @Override
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
        return restApi.shoppingCartRequest(params);
    }

    @Override
    public Observable<GetWebContentResponse> getEcmcContent() {
        return restApi.getEcmcContent();
    }

    @Override
    public Observable<GetWebContentResponse> getContactContent() {
        return restApi.getContactContent();
    }

    @Override
    public Observable<HelpSupportResponse> helpSupportRequest(Map<String, Object> params) {
        return restApi.helpSupportRequest(params);
    }

    @Override
    public Observable<FAQResponse> faqRequest(Map<String, Object> params) {
        return restApi.faqRequest(params);
    }

    @Override
    public Observable<TermsConditionsResponse> termsConditionsRequest(Map<String, Object> params) {
        return restApi.termsConditionsRequest(params);
    }

    @Override
    public Observable<ContactUsResponse> getContactInfo() {
        return restApi.getContactInfo();
    }

    @Override
    public Observable<ContactUsResponse> contactMessageRequest(Map<String, Object> params) {
        return restApi.contactMessageRequest(params);
    }

    @Override
    public Observable<SettingsLogoutResponse> settingsLogoutRequest(Map<String, Object> params) {
        return restApi.settingsLogoutRequest(params);
    }

    public Observable<PaymentStatusResponse> paymentStatusRequest(Map<String, Object> params) {
        return restApi.paymentStatusRequest(params);
    }

    @Override
    public Observable<AddressResponse> selectAddressRequest(Map<String, Object> params) {
        return restApi.selectAddressRequest(params);
    }

    @Override
    public Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params) {
        return restApi.rightVideoRequest(params);
    }

    @Override
    public Observable<TVShowResponse> tvShowRequest(Map<String, Object> params) {
        return restApi.tvShowRequest(params);
    }

    @Override
    public Observable<QuestionAnswerResponse> allQARequest(Map<String, Object> params) {
        return restApi.allQARequest(params);
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        return restApi.qaDetailRequest(params);
    }

    @Override
    public Observable<Response<ProfileResponse>> getUserProfile() {
        return restApi.getUserProfile();
    }

    @Override
    public Observable<Response<ProfileMetadataResponse>> getProfileMetadata() {
        return restApi.getProfileMetadata();
    }

    @Override
    public Observable<Response<LoginResponse>> loginRequest(Map<String, Object> params) {
        return restApi.loginRequest(params);
    }

    @Override
    public Observable<Response<LoginResponse>> facebookLoginRequest(Map<String, Object> params) {
        return restApi.facebookLoginRequest(params);
    }

    @Override
    public Observable<Object> saveUserInfo(UserData customer) {
        return null;
    }

    @Override
    public Observable<UserData> getUserInfo() {
        return null;
    }

    @Override
    public Observable<Boolean> clearUserInfo() {
        return null;
    }

}

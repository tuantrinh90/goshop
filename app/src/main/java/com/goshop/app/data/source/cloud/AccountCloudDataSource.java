package com.goshop.app.data.source.cloud;

import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.response.AllReviewsResponse;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.ComplementEmailResponse;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.data.model.FAQResponse;
import com.goshop.app.data.model.GetWebContentResponse;
import com.goshop.app.data.model.GoLoyaltyResponse;
import com.goshop.app.data.model.response.CartDataResponse;
import com.goshop.app.data.model.response.DealsResponse;
import com.goshop.app.data.model.response.FilterCategoryResponse;
import com.goshop.app.data.model.response.FilterStatusResponse;
import com.goshop.app.data.model.response.HelpSupportResponse;
import com.goshop.app.data.model.response.MyRewardsResponse;
import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.data.model.response.OrderDetailResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.response.OrderMetadataResponse;
import com.goshop.app.data.model.response.PaymentResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.OrderResponse;
import com.goshop.app.data.model.response.ProfileMetadataResponse;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.ResetPasswordResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.model.response.ZipCodeResponse;
import com.goshop.app.data.source.AccountDataSource;
import com.goshop.app.presentation.model.FlagsVM;
import com.goshop.app.presentation.model.UserDataVM;
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
    public Observable<Response<MyEGiftResponse>> getEGiftCardDetails(Map<String, Object> params) {
        return restApi.getEGiftCardDetails(params);
    }

    @Override
    public Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params) {
        return restApi.goLoyaltyRequest(params);
    }

    @Override
    public Observable<Response<DealsResponse>> getListDeals() {
        return restApi.getListDeals();
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
    public Observable<Response<CardRedeemResponse>> swipeRedeemRequest(Map<String, Object> params) {
        return restApi.swipeRedeemRequest(params);
    }

    @Override
    public Observable<Response<MyRewardsResponse>> rewardsDetailRequest(Map<String, Object> params) {
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
    public Observable<Response<MyWishlistResponse>> getWishlistItems(Map<String, Object> params) {
        return restApi.getWishlistItems(params);
    }

    @Override
    public Observable<Response<AllReviewsResponse>> getProductRatingReviews(Map<String, Object> params) {
        return restApi.getProductRatingReviews(params);
    }

    @Override
    public Observable<Response> registerRequest(Map<String, Object> params) {
        return restApi.registerRequest(params);
    }

    @Override
    public Observable<Response<CheckoutResponse>> checkoutRequest(Map<String, Object> params) {
        return restApi.checkoutRequest(params);
    }

    @Override
    public Observable<Response<MyOrderListResponse>> getListOrder(Map<String, Object> params) {
        return restApi.getListOrder(params);
    }

    @Override
    public Observable<Response<OrderDetailResponse>> getOrderDetail(Map<String, Object> params) {
        return restApi.getOrderDetail(params);
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
    public Observable<Response<AddressResponse>> getAddressList(Map<String, Object> params) {
        return restApi.getAddressList(params);
    }

    @Override
    public Observable<Response<AddressResponse>> editAddressRequest(Map<String, Object> params) {
        return restApi.editAddressRequest(params);
    }

    @Override
    public Observable<Response<AddressResponse>> setDefaultShippingBilling(
        Map<String, Object> params) {
        return restApi.setDefaultShippingBilling(params);
    }

    @Override
    public Observable<AddressResponse> myAddressRequest(Map<String, Object> params) {
        return restApi.myAddressRequest(params);
    }

    @Override
    public Observable<Response<CartDataResponse>> viewCartDetails(Map<String, Object> params) {
        return restApi.viewCartDetails(params);
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
    public Observable<Response<HelpSupportResponse>> helpSupportRequest(Map<String, Object> params) {
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
    public Observable<Response> contactMessageRequest(Map<String, Object> params) {
        return restApi.contactMessageRequest(params);
    }

    @Override
    public Observable<Response> settingsLogoutRequest(Map<String, Object> params) {
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
    public Observable<Response<ProfileResponse>> getUserProfile(Map<String, Object> params) {
        return restApi.getUserProfile(params);
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
    public Observable<Object> saveUserInfo(UserDataVM customer) {
        return null;
    }

    @Override
    public Observable<UserDataVM> getUserInfo() {
        return null;
    }

    @Override
    public Observable<Boolean> clearUserInfo() {
        return null;
    }

    @Override
    public Observable<Response<StatesResponse>> getStates(Map<String, Object> params) {
        return restApi.getStates(params);
    }

    @Override
    public Observable<Response<CityResponse>> getCity(Map<String, Object> params) {
        return restApi.getCity(params);
    }

    @Override
    public Observable<Response<ZipCodeResponse>> getZipCode(Map<String, Object> params) {
        return restApi.getZipCode(params);
    }

    @Override
    public Observable<Response<OrderResponse>> cancelOrderRequest(Map<String, Object> params) {
        return restApi.cancelOrderRequest(params);
    }

    @Override
    public Observable<Response<OrderResponse>> returnOrderRequest(Map<String, Object> params) {
        return restApi.returnOrderRequest(params);
    }

    @Override
    public Observable<Response> selectDefaultShippingRequest(Map<String, Object> params) {
        return restApi.selectDefaultShippingRequest(params);
    }

    @Override
    public Observable<Response> selectDefaultBillingRequest(Map<String, Object> params) {
        return restApi.selectDefaultBillingRequest(params);
    }

    @Override
    public Observable<FlagsVM> getFlags() {
        return null;
    }

    @Override
    public Observable<Object> saveFlags(FlagsVM flagsVM) {
        return null;
    }

    @Override
    public Observable<Response<ApplyCouponResponse>> applyCoupon(Map<String, Object> params) {
        return restApi.applyCoupon(params);
    }

    @Override
    public Observable<Response<ApplyPointsResponse>> applyGoShopPoints(Map<String, Object> params) {
        return restApi.applyGoShopPoints(params);
    }

    @Override
    public Observable<Response<ApplyEGiftResponse>> applyEGiftCard(Map<String, Object> params) {
        return restApi.applyEGiftCard(params);
    }

    @Override
    public Observable<Response<OrderMetadataResponse>> getOrderMetadata(
        Map<String, Object> params) {
        return restApi.getOrderMetadata(params);
    }

    @Override
    public Observable<Response<PaymentResponse>> paymentRequest(Map<String, Object> params) {
        return restApi.paymentRequest(params);
    }

    @Override
    public Observable<Response<FilterCategoryResponse>> getFilterCategory() {
        return restApi.getFilterCategory();
    }

    @Override
    public Observable<Response<FilterStatusResponse>> getFilterStatus() {
        return restApi.getFilterStatus();
    }

}

package com.goshop.app.data.source.local;

import com.goshop.app.data.LocalApi;
import com.goshop.app.data.model.AllDealsResponse;
import com.goshop.app.data.model.response.AllReviewsResponse;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.ComplementEmailResponse;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.data.model.FAQResponse;
import com.goshop.app.data.model.GetWebContentResponse;
import com.goshop.app.data.model.GoLoyaltyResponse;
import com.goshop.app.data.model.response.HelpSupportResponse;
import com.goshop.app.data.model.MyRewardsResponse;
import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.data.model.response.OrderDetailResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.response.ShoppingCartResponse;
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

import java.util.Map;
import javax.inject.Inject;
import io.reactivex.Observable;

public class AccountLocalDataSource implements AccountDataSource {

    private LocalApi localApi;

    @Inject
    public AccountLocalDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<TrendingNowResponse> trendingNowRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<MyEGiftResponse>> eGiftCardsRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<MyEGiftResponse>> getEGiftCardDetails(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AllDealsResponse> allDealsRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyRewardsResponse> expiredRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyRewardsResponse> pendingRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyRewardsResponse> redeemedRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<CardRedeemResponse> cardRedeemRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<CardRedeemResponse> swipeRedeemRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyRewardsResponse> rewardsDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<MyWishlistResponse>> wishlistDeleteRequest(
        Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<MyWishlistResponse>> addWishlistRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<MyWishlistResponse>> getWishlistItems(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<AllReviewsResponse>> getProductRatingReviews(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response> registerRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<CheckoutResponse> checkoutRequest(String sessionKey) {
        return null;
    }

    @Override
    public Observable<Response<MyOrderListResponse>> getListOrder(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<OrderDetailResponse>> getOrderDetail(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<NotificationsResponse> notificationRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ComplementEmailResponse> complementEmailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ResetPasswordResponse>> resetPasswordRequest(
        Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
        Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response> changePasswordRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ProfileResponse>> editProfileRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<AddressResponse>> addAddressRequest(AddressRequest addressRequest) {
        return null;
    }

    @Override
    public Observable<Response<AddressResponse>> editAddressRequest(AddressRequest addressRequest) {
        return null;
    }

    @Override
    public Observable<Response<AddressResponse>> getAddressList(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AddressResponse> editAddressRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AddressResponse> myAddressRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ShoppingCartResponse>> viewCartDetails(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<GetWebContentResponse> getEcmcContent() {
        return null;
    }

    @Override
    public Observable<GetWebContentResponse> getContactContent() {
        return null;
    }

    @Override
    public Observable<Response<HelpSupportResponse>> helpSupportRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<FAQResponse> faqRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<TermsConditionsResponse> termsConditionsRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ContactUsResponse> getContactInfo() {
        return null;
    }

    @Override
    public Observable<ContactUsResponse> contactMessageRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response> settingsLogoutRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<PaymentStatusResponse> paymentStatusRequest(Map<String, Object> params) {

        return null;
    }

    @Override
    public Observable<AddressResponse> selectAddressRequest(Map<String, Object> params) {

        return null;
    }

    @Override
    public Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<TVShowResponse> tvShowRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ProfileResponse>> getUserProfile(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ProfileMetadataResponse>> getProfileMetadata() {
        return null;
    }

    @Override
    public Observable<Response<LoginResponse>> loginRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<LoginResponse>> facebookLoginRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<StatesResponse>> getStates() {
        return null;
    }

    @Override
    public Observable<Response<CityResponse>> getCity() {
        return null;
    }

    @Override
    public Observable<Response<ZipCodeResponse>> getZipCode() {
        return null;
    }

    @Override
    public Observable<Object> saveUserInfo(UserData customer) {
        return localApi.saveUserInfo(customer);
    }

    @Override
    public Observable<UserData> getUserInfo() {
        return localApi.getUserInfo();
    }

    @Override
    public Observable<Boolean> clearUserInfo() {
        return localApi.clearUserInfo();
    }

    @Override
    public Observable<Response<OrderResponse>> cancelOrderRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<OrderResponse>> returnOrderRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response> selectDefaultShippingRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response> selectDefaultBillingRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<FlagsVM> getFlags() {
        return localApi.getFlags();
    }

    @Override
    public Observable<Object> saveFlags(FlagsVM flagsVM) {
        return localApi.saveFlags(flagsVM);
    }

    @Override
    public Observable<Response<ApplyCouponResponse>> applyCoupon(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ApplyPointsResponse>> applyGoShopPoints(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<Response<ApplyEGiftResponse>> applyEGiftCard(Map<String, Object> params) {
        return null;
    }
}

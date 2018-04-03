package com.goshop.app.data.source.local;

import com.goshop.app.data.LocalApi;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.AllDealsResponse;
import com.goshop.app.data.model.AllReviewsResponse;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.CategoryMenuResponse;
import com.goshop.app.data.model.ComplementEmailResponse;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.data.model.FAQResponse;
import com.goshop.app.data.model.GetWebContentResponse;
import com.goshop.app.data.model.GoLoyaltyResponse;
import com.goshop.app.data.model.HelpSupportResponse;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.MyRewardsResponse;
import com.goshop.app.data.model.MyWishlistResponse;
import com.goshop.app.data.model.OrderDetailResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.QuestionAnswerResponse;
import com.goshop.app.data.model.response.ChangePasswordResponse;
import com.goshop.app.data.model.response.ResetPasswordResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.MyOrderDetailResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.RegisterResponse;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.data.source.AccountDataSource;

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
    public Observable<BrandsResponse> brandsRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyEGiftResponse> eGiftCardsRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyEGiftResponse> getEGiftCardDetails() {
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
    public Observable<MyWishlistResponse> myWishlistRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ProductDetailResponse> pdpDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AllReviewsResponse> allReviewsRequest(Map<String, Object> params) {
        return null;
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
    public Observable<RegisterResponse> registerRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<HomeResponse> homeRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<CheckoutResponse> checkoutRequest(String sessionKey) {
        return null;
    }

    @Override
    public Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyOrderListResponse> myOrdersRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<OrderDetailResponse> orderDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyOrderDetailResponse> myOrderDetailRequest(Map<String, Object> params) {
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
    public Observable<ResetPasswordResponse> resetPasswordRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
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

    @Override
    public Observable<ChangePasswordResponse> changePasswordRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ProfileResponse> editProfileRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(AddressRequest addressRequest) {
        return null;
    }

    @Override
    public Observable<AddressResponse> editAddressRequest(AddressRequest addressRequest) {
        return null;
    }

    @Override
    public Observable<AddressResponse> getAddressList() {
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
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
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
    public Observable<HelpSupportResponse> helpSupportRequest(Map<String, Object> params) {
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
    public Observable<SettingsLogoutResponse> settingsLogoutRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyPointsResponse> myPointsRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<MyPointsResponse> getGoShopPointsDetails() {
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
    public Observable<CategoryMenuResponse> getCategoryLeftMenu() {
        return null;
    }

    @Override
    public Observable<CategoryMenuResponse> categoryRightMenuRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params) {
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
    public Observable<QuestionAnswerResponse> allQARequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<ProfileResponse> getUserProfile() {
        return null;
    }

    @Override
    public Observable<LoginResponse> loginRequest(Map<String, Object> params) {
        return null;
    }

    @Override
    public Observable<LoginResponse> facebookLoginRequest(Map<String, Object> params) {
        return null;
    }
}

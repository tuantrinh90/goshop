package com.goshop.app.data.source;

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
import com.goshop.app.data.model.response.MyWishlistResponse;
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

import java.util.Map;

import io.reactivex.Observable;

public interface AccountDataSource {

    Observable<TrendingNowResponse> trendingNowRequest(Map<String, Object> params);

    Observable<BrandsResponse> brandsRequest(Map<String, Object> params);

    Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params);

    Observable<MyEGiftResponse> eGiftCardsRequest(Map<String, Object> params);

    Observable<MyEGiftResponse> getEGiftCardDetails();

    Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params);

    Observable<AllDealsResponse> allDealsRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> expiredRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> pendingRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> redeemedRequest(Map<String, Object> params);

    Observable<CardRedeemResponse> cardRedeemRequest(Map<String, Object> params);

    Observable<CardRedeemResponse> swipeRedeemRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> rewardsDetailRequest(Map<String, Object> params);

    Observable<MyWishlistResponse> wishlistDeleteRequest(Map<String, Object> params);

    Observable<MyWishlistResponse> addWishlistRequest(Map<String, Object> params);

    Observable<MyWishlistResponse> getWishlistItems();

    Observable<ProductDetailResponse> pdpDetailRequest(Map<String, Object> params);

    Observable<AllReviewsResponse> allReviewsRequest(Map<String, Object> params);

    Observable<UserInfo> getUserInfo(String userId);

    Observable<UserInfo> getUserInfo(String username, String password);

    Observable<GetWeatherResponse> getWeather();

    Observable<RegisterResponse> registerRequest(Map<String, Object> params);

    Observable<HomeResponse> homeRequest(Map<String, Object> params);

    Observable<CheckoutResponse> checkoutRequest(String sessionKey);

    Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params);

    Observable<MyOrderListResponse> myOrdersRequest(Map<String, Object> params);

    Observable<OrderDetailResponse> orderDetailRequest(Map<String, Object> params);

    Observable<MyOrderDetailResponse> myOrderDetailRequest(Map<String, Object> params);

    Observable<NotificationsResponse> notificationRequest(Map<String, Object> params);

    Observable<ComplementEmailResponse> complementEmailRequest(Map<String, Object> params);

    Observable<ResetPasswordResponse> resetPasswordRequest(Map<String, Object> params);

    Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
        Map<String, Object> params);

    Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params);

    Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params);

    Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params);

    Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params);

    Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params);

    Observable<ChangePasswordResponse> changePasswordRequest(Map<String, Object> params);

    Observable<ProfileResponse> editProfileRequest(Map<String, Object> params);

    Observable<AddressResponse> addAddressRequest(Map<String, Object> params);

    Observable<AddressResponse> addAddressRequest(AddressRequest addressRequest);

    Observable<AddressResponse> editAddressRequest(AddressRequest addressRequest);

    Observable<AddressResponse> getAddressList();

    Observable<AddressResponse> editAddressRequest(Map<String, Object> params);

    Observable<AddressResponse> myAddressRequest(Map<String, Object> params);

    Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params);

    Observable<GetWebContentResponse> getEcmcContent();

    Observable<GetWebContentResponse> getContactContent();

    Observable<HelpSupportResponse> helpSupportRequest(Map<String, Object> params);

    Observable<FAQResponse> faqRequest(Map<String, Object> params);

    Observable<TermsConditionsResponse> termsConditionsRequest(Map<String, Object> params);

    Observable<ContactUsResponse> getContactInfo();

    Observable<ContactUsResponse> contactMessageRequest(Map<String, Object> params);

    Observable<SettingsLogoutResponse> settingsLogoutRequest(Map<String, Object> params);

    Observable<MyPointsResponse> myPointsRequest(Map<String, Object> params);

    Observable<MyPointsResponse> getGoShopPointsDetails();

    Observable<PaymentStatusResponse> paymentStatusRequest(Map<String, Object> params);

    Observable<AddressResponse> selectAddressRequest(Map<String, Object> params);

    Observable<CategoryMenuResponse> getCategoryLeftMenu();

    Observable<CategoryMenuResponse> categoryRightMenuRequest(Map<String, Object> params);

    Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params);

    Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params);

    Observable<TVShowResponse> tvShowRequest(Map<String, Object> params);

    Observable<QuestionAnswerResponse> allQARequest(Map<String, Object> params);

    Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params);

    Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params);

    Observable<ProfileResponse> getUserProfile();

    Observable<LoginResponse> loginRequest(Map<String, Object> params);

    Observable<LoginResponse> facebookLoginRequest(Map<String, Object> params);

}

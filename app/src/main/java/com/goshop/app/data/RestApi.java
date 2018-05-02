package com.goshop.app.data;

import com.goshop.app.data.model.request.AddRemoveCartRequest;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.AllDealsResponse;
import com.goshop.app.data.model.response.AllReviewsResponse;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.response.CategoryResponse;
import com.goshop.app.data.model.ComplementEmailResponse;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.data.model.FAQResponse;
import com.goshop.app.data.model.GetWebContentResponse;
import com.goshop.app.data.model.GoLoyaltyResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.HelpSupportResponse;
import com.goshop.app.data.model.response.BannerResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.data.model.response.CartDataResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.DeliveryCheckResponse;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.MyRewardsResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.OrderDetailResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.response.OrderMetadataResponse;
import com.goshop.app.data.model.response.PaymentResponse;
import com.goshop.app.data.model.response.ProductDetailResponse;
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.response.OnAirScheduleResponse;
import com.goshop.app.data.model.response.OrderResponse;
import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.response.ProfileMetadataResponse;
import com.goshop.app.data.model.response.ResetPasswordResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.data.model.response.ZipCodeResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public interface RestApi {

    Observable<TrendingNowResponse> trendingNowRequest(Map<String, Object> params);

    Observable<Response<BrandsResponse>> brandsRequest(Map<String, Object> params);

    Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params);

    Observable<Response<MyEGiftResponse>> eGiftCardsRequest(Map<String, Object> params);

    Observable<Response<MyEGiftResponse>> getEGiftCardDetails(Map<String, Object> params);

    Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params);

    Observable<AllDealsResponse> allDealsRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> expiredRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> pendingRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> redeemedRequest(Map<String, Object> params);

    Observable<CardRedeemResponse> cardRedeemRequest(Map<String, Object> params);

    Observable<Response<CardRedeemResponse>> swipeRedeemRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> rewardsDetailRequest(Map<String, Object> params);

    Observable<Response<MyWishlistResponse>> wishlistDeleteRequest(Map<String, Object> params);

    Observable<Response<MyWishlistResponse>> addWishlistRequest(Map<String, Object> params);

    Observable<Response<MyWishlistResponse>> getWishlistItems(Map<String, Object> params);

    Observable<Response<AllReviewsResponse>> getProductRatingReviews(Map<String, Object> params);

    io.reactivex.Observable<Response> registerRequest(Map<String, Object> params);

    Observable<Response<CheckoutResponse>> checkoutRequest(Map<String, Object> params);

    Observable<Response<MyOrderListResponse>> getListOrder(Map<String, Object> params);

    Observable<Response<OrderDetailResponse>> getOrderDetail(Map<String, Object> params);

    io.reactivex.Observable<NotificationsResponse> notificationRequest(Map<String, Object> params);

    io.reactivex.Observable<ComplementEmailResponse> complementEmailRequest(
        Map<String, Object> params);

    Observable<Response<ResetPasswordResponse>> resetPasswordRequest(Map<String, Object> params);

    Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
        Map<String, Object> params);

    Observable<Response<ProductDetailResponse>> getProductDetails(Map<String, Object> params);

    Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params);

    Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params);

    Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params);

    Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params);

    Observable<Response> changePasswordRequest(Map<String, Object> params);

    Observable<Response<ProfileResponse>> editProfileRequest(Map<String, Object> params);

    Observable<AddressResponse> addAddressRequest(Map<String, Object> params);

    Observable<Response<AddressResponse>> addAddressRequest(AddressRequest addressRequest);

    Observable<Response<AddressResponse>> editAddressRequest(AddressRequest addressRequest);

    Observable<Response<AddressResponse>> getAddressList(Map<String, Object> params);

    Observable<Response<AddressResponse>> editAddressRequest(Map<String, Object> params);

    Observable<AddressResponse> myAddressRequest(Map<String, Object> params);

    Observable<Response<CartDataResponse>> viewCartDetails(Map<String, Object> params);

    Observable<GetWebContentResponse> getEcmcContent();

    Observable<GetWebContentResponse> getContactContent();

    Observable<Response<HelpSupportResponse>> helpSupportRequest(Map<String, Object> params);

    Observable<FAQResponse> faqRequest(Map<String, Object> params);

    Observable<TermsConditionsResponse> termsConditionsRequest(Map<String, Object> params);

    Observable<ContactUsResponse> getContactInfo();

    Observable<Response> contactMessageRequest(Map<String, Object> params);

    Observable<Response> settingsLogoutRequest(Map<String, Object> params);

    Observable<Response<MyPointsResponse>> myPointsRequest(Map<String, Object> params);

    Observable<Response<MyPointsResponse>> getGoShopPointsDetails(Map<String, Object> params);

    Observable<PaymentStatusResponse> paymentStatusRequest(Map<String, Object> params);

    Observable<AddressResponse> selectAddressRequest(Map<String, Object> params);

    Observable<Response<CategoryResponse>> getCategory(Map<String, Object> params);

    Observable<CategoryResponse> categoryRightMenuRequest(Map<String, Object> params);

    Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params);

    Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params);

    Observable<TVShowResponse> tvShowRequest(Map<String, Object> params);

    Observable<Response<QuestionAnswerResponse>> listProductQA(Map<String, Object> params);

    Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params);

    Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params);

    Observable<Response<ProfileResponse>> getUserProfile(Map<String, Object> params);

    Observable<Response<ProfileMetadataResponse>> getProfileMetadata();

    Observable<Response<LoginResponse>> loginRequest(Map<String, Object> params);

    Observable<Response<LoginResponse>> facebookLoginRequest(Map<String, Object> params);

    Observable<Response<StatesResponse>> getStates(Map<String, Object> params);

    Observable<Response<CityResponse>> getCity(Map<String, Object> params);

    Observable<Response<ZipCodeResponse>> getZipCode(Map<String, Object> params);

    Observable<Response> writeReviewRequest(Map<String, Object> params);

    Observable<Response> submitQuestions(Map<String, Object> params);

    Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(Map<String, Object> params);

    Observable<Response<OrderResponse>> cancelOrderRequest(Map<String, Object> params);

    Observable<Response<OrderResponse>> returnOrderRequest(Map<String, Object> params);

    Observable<Response> selectDefaultShippingRequest(Map<String, Object> params);

    Observable<Response> selectDefaultBillingRequest(Map<String, Object> params);

    Observable<Response<BannerResponse>> getHomeBanner(HashMap<String, Object> params);

    Observable<Response<OnAirScheduleResponse>> getOnAirSchedule(HashMap<String, Object> params);

    Observable<Response<CartDataResponse>> addToCartRequest(AddRemoveCartRequest request);

    Observable<Response<CartDataResponse>> removeFromCartRequest(AddRemoveCartRequest request);

    Observable<Response<CartDataResponse>> updateCartRequest(Map<String, Object> params);

    Observable<Response<ApplyCouponResponse>> applyCoupon(Map<String, Object> params);

    Observable<Response<ApplyPointsResponse>> applyGoShopPoints(Map<String, Object> params);

    Observable<Response<ApplyEGiftResponse>> applyEGiftCard(Map<String, Object> params);

    Observable<Response<OrderMetadataResponse>> getOrderMetadata(Map<String, Object> params);

    Observable<Response<PaymentResponse>> paymentRequest(Map<String, Object> params);

}

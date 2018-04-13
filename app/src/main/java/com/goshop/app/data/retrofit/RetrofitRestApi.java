package com.goshop.app.data.retrofit;

import com.goshop.app.data.model.AllDealsResponse;
import com.goshop.app.data.model.response.AllReviewsResponse;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.CategoryMenuResponse;
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
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.response.DeliveryCheckResponse;
import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.request.GetUserRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.MyOrderDetailResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.ProfileMetadataResponse;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.ResetPasswordResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.data.model.response.ZipCodeResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface RetrofitRestApi {

    String CONTENT_TYPE_JSON = "Content-Type: application/vnd.api+json";

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<TrendingNowResponse> trendingNowRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<BrandsResponse> brandsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<BrandsResponse> brandsDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<MyEGiftResponse>> eGiftCardsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<MyEGiftResponse>> getEGiftCardDetails(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<GoLoyaltyResponse> goLoyaltyRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<AllDealsResponse> allDealsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<MyRewardsResponse> expiredRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<MyRewardsResponse> pendingRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<MyRewardsResponse> redeemedRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<CardRedeemResponse> cardRedeemRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<CardRedeemResponse> swipeRedeemRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<MyRewardsResponse> rewardsDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<MyWishlistResponse>> wishilistDeleteRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<MyWishlistResponse>> addWishlistRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<MyWishlistResponse>> getWishlistItems(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ProductDetailResponse> pdpDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<AllReviewsResponse>> allReviewsRequest(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<HomeResponse> homeRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<MyOrderListResponse> myOrderListRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<MyOrderListResponse> myOrdersRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<OrderDetailResponse> orderDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<MyOrderDetailResponse> myOrderDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<CheckoutResponse> checkoutRequest(@Url String fullUrl,
        String sessionKey);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<NotificationsResponse> notificationRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response> registerRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ComplementEmailResponse> complementEmailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<ResetPasswordResponse>> resetPasswordRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ProductDetailResponse> productDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SearchFilterResponse> searchFilterRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SearchResultResponse> searchResultResponse(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<PromotionListResponse> promotionListRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response> changePasswordRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<PromotionBannerResponse> promotionBannerRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<ProfileResponse>> editProfileRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<AddressResponse> addAddressRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<AddressResponse>> addAddressRequest(@Url String url,
        @Body AddressRequest addressRequest);

    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<AddressResponse>> editAddressRequest(@Url String url,
        @Body AddressRequest addressRequest);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<AddressResponse>> getAddressList(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<AddressResponse> editAddressRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<AddressResponse> myAddressRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ShoppingCartResponse> shoppingCartRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<GetWebContentResponse> getEcmcContent(@Url String fullUrl);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<GetWebContentResponse> getContactContent(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<HelpSupportResponse> helpSupportRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<FAQResponse> faqRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<TermsConditionsResponse> termsConditionsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<ContactUsResponse> getContactInfo(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ContactUsResponse> contactMessageRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SettingsLogoutResponse> settingsLogoutRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<PaymentStatusResponse> paymentStatusRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<MyPointsResponse>> myPointsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<MyPointsResponse>> getGoShopPointsDetails(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<AddressResponse> selectAddressRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<CategoryMenuResponse> getCategoryLeftMenu(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<CategoryMenuResponse> categoryRightMenuRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SearchResultResponse> categoryDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<TVShowResponse> rightVideoRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<TVShowResponse> tvShowRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<QuestionAnswerResponse>> allQARequest(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<QuestionAnswerResponse> qaDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<PromotionSkuResponse> promotionSkuRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<ProfileResponse>> getUserProfile(@Url String fullUrl);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<ProfileMetadataResponse>> getProfileMetadata(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<LoginResponse>> loginRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<LoginResponse>> facebookLoginRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<StatesResponse>> getStates(@Url String fullUrl);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<CityResponse>> getCity(@Url String fullUrl);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Response<ZipCodeResponse>> getZipCode(@Url String fullUrl);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response> writeReviewRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response> submitQuestions(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);
}

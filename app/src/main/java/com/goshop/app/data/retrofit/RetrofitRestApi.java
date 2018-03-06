package com.goshop.app.data.retrofit;

import com.goshop.app.data.model.AddressResponse;
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
import com.goshop.app.data.model.MyEGiftResponse;
import com.goshop.app.data.model.MyPointsResponse;
import com.goshop.app.data.model.MyRewardsResponse;
import com.goshop.app.data.model.PasswordResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ProfileResponse;
import com.goshop.app.data.model.ResetPasswordResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.request.GetUserRequest;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.MyOrderDetailResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.WidgetListResponse;

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
    Observable<WidgetListResponse> trendingNowRequest(@Url String fullUrl,
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
    Observable<MyEGiftResponse> eGiftCardsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

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
    Observable<ProductDetailResponse> pdpDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<AllReviewsResponse> allReviewsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<GetWeatherResponse> getWeather(@Url String url);

    //TODO  this is an example
    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<UserInfo> getUserInfo(@Url String url,
        @Body GetUserRequest getUserRequest);

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

    //TODO  this is an example
    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Error> loginCreatePinRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<UserInfo> registerRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ComplementEmailResponse> complementEmailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ResetPasswordResponse> resetPasswordRequest(@Url String fullUrl,
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
    Observable<PasswordResponse> changePasswordRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<PromotionBannerResponse> promotionBannerRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ProfileResponse> editProfileRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<AddressResponse> addAddressRequest(@Url String fullUrl,
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
    Observable<MyPointsResponse> myPointsRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

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
    Observable<TVShowResponse> leftVideoRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);
}

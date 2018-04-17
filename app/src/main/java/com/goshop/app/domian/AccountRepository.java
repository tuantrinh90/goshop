package com.goshop.app.domian;

import com.goshop.app.data.model.AllDealsResponse;
import com.goshop.app.data.model.response.AllReviewsResponse;
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
import com.goshop.app.data.model.response.OrderResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.CityResponse;
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
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.model.response.ZipCodeResponse;

import java.util.Map;

import io.reactivex.Observable;

public interface AccountRepository {

    Observable<TrendingNowResponse> trendingNowRequest(Map<String, Object> params);

    Observable<Response<MyEGiftResponse>> eGiftCardsRequest(Map<String, Object> params);

    Observable<Response<MyEGiftResponse>> getEGiftCardDetails();

    Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params);

    Observable<AllDealsResponse> allDealsRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> expiredRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> pendingRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> redeemedRequest(Map<String, Object> params);

    Observable<CardRedeemResponse> cardRedeemRequest(Map<String, Object> params);

    Observable<CardRedeemResponse> swipeRedeemRequest(Map<String, Object> params);

    Observable<MyRewardsResponse> rewardsDetailRequest(Map<String, Object> params);

    Observable<Response<MyWishlistResponse>> wishlistDeleteRequest(Map<String, Object> params);

    Observable<Response<MyWishlistResponse>> addWishlistRequest(Map<String, Object> params);

    Observable<Response<MyWishlistResponse>> getWishlistItems();

    Observable<ProductDetailResponse> pdpDetailRequest(Map<String, Object> params);

    Observable<Response<AllReviewsResponse>> allReviewsRequest(Map<String, Object> params);

    Observable<Response> registerRequest(Map<String, Object> params);

    Observable<HomeResponse> homeRequest(Map<String, Object> params);

    Observable<CheckoutResponse> checkoutRequest(String sessionKey);

    Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params);

    Observable<MyOrderListResponse> myOrdersRequest(Map<String, Object> params);

    Observable<OrderDetailResponse> orderDetailRequest(Map<String, Object> params);

    Observable<MyOrderDetailResponse> myOrderDetailRequest(Map<String, Object> params);

    Observable<NotificationsResponse> notificationRequest(Map<String, Object> params);

    Observable<ComplementEmailResponse> complementEmailRequest(Map<String, Object> params);

    Observable<Response<ResetPasswordResponse>> resetPasswordRequest(Map<String, Object> params);

    Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
        Map<String, Object> params);

    Observable<Response> changePasswordRequest(Map<String, Object> params);

    Observable<Response<ProfileResponse>> editProfileRequest(Map<String, Object> params);

    Observable<AddressResponse> addAddressRequest(Map<String, Object> params);

    Observable<Response<AddressResponse>> addAddressRequest(AddressRequest addressRequest);

    Observable<Response<AddressResponse>> editAddressRequest(AddressRequest addressRequest);

    Observable<AddressResponse> editAddressRequest(Map<String, Object> params);

    Observable<AddressResponse> myAddressRequest(Map<String, Object> params);

    Observable<Response<AddressResponse>> getAddressList();

    Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params);

    Observable<GetWebContentResponse> getEcmcContent();

    Observable<GetWebContentResponse> getContactContent();

    Observable<HelpSupportResponse> helpSupportRequest(Map<String, Object> params);

    Observable<FAQResponse> faqRequest(Map<String, Object> params);

    Observable<TermsConditionsResponse> termsConditionsRequest(Map<String, Object> params);

    Observable<ContactUsResponse> getContactInfo();

    Observable<ContactUsResponse> contactMessageRequest(Map<String, Object> params);

    Observable<SettingsLogoutResponse> settingsLogoutRequest(Map<String, Object> params);

    Observable<PaymentStatusResponse> paymentStatusRequest(Map<String, Object> params);

    Observable<AddressResponse> selectAddressRequest(Map<String, Object> params);

    Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params);

    Observable<TVShowResponse> tvShowRequest(Map<String, Object> params);

    Observable<Response<ProfileResponse>> getUserProfile(Map<String, Object> params);

    Observable<Response<ProfileMetadataResponse>> getProfileMetadata();

    Observable<Response<LoginResponse>> loginRequest(Map<String, Object> params);

    Observable<Response<LoginResponse>> facebookLoginRequest(Map<String, Object> params);

    Observable<Object> saveUserInfo(UserData customer);

    Observable<UserData> getUserInfo();

    Observable<Response<StatesResponse>> getStates();

    Observable<Response<CityResponse>> getCity();

    Observable<Response<ZipCodeResponse>> getZipCode();

    Observable<Boolean>  clearUserInfo();

    Observable<Response<OrderResponse>> cancelOrderRequest(Map<String, Object> params);

    Observable<Response<OrderResponse>> returnOrderRequest(Map<String, Object> params);
}

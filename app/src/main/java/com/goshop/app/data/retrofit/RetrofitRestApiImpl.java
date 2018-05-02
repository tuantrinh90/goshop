package com.goshop.app.data.retrofit;

import com.goshop.app.data.EndpointAddress;
import com.goshop.app.data.RestApi;
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
import com.goshop.app.data.model.MyRewardsResponse;
import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.data.model.response.OrderDetailResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.response.CartDataResponse;
import com.goshop.app.data.model.response.OrderMetadataResponse;
import com.goshop.app.data.model.response.PaymentResponse;
import com.goshop.app.data.model.response.ProductDetailResponse;
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.response.BannerResponse;
import com.goshop.app.data.model.response.DeliveryCheckResponse;
import com.goshop.app.data.model.response.OnAirScheduleResponse;
import com.goshop.app.data.model.response.OrderResponse;
import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.MyEGiftResponse;
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

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class RetrofitRestApiImpl implements RestApi {

    private RetrofitRestApi retrofitRestApi;

    @Inject
    public RetrofitRestApiImpl(Retrofit retrofit) {
        this.retrofitRestApi = retrofit.create(RetrofitRestApi.class);
    }

    @Override
    public Observable<TrendingNowResponse> trendingNowRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_PAGE);
        return retrofitRestApi.trendingNowRequest(url, params);
    }

    @Override
    public Observable<Response<BrandsResponse>> brandsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_BRAND_LIST);
        return retrofitRestApi.brandsRequest(url, params);
    }

    @Override
    public Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.BRANDS_DETAIL);
        return retrofitRestApi.brandsDetailRequest(url, params);
    }

    @Override
    public Observable<Response<MyEGiftResponse>> eGiftCardsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ACTIVATE_EGIFTCARD);
        return retrofitRestApi.eGiftCardsRequest(url, params);
    }

    @Override
    public Observable<Response<MyEGiftResponse>> getEGiftCardDetails(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.EGIFTCARD_DETAILS);
        return retrofitRestApi.getEGiftCardDetails(url, params);
    }

    @Override
    public Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GO_LOYALTY);
        return retrofitRestApi.goLoyaltyRequest(url, params);
    }

    @Override
    public Observable<AllDealsResponse> allDealsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ALL_DEALS);
        return retrofitRestApi.allDealsRequest(url, params);
    }

    @Override
    public Observable<MyRewardsResponse> expiredRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.EXPIRED);
        return retrofitRestApi.expiredRequest(url, params);
    }

    @Override
    public Observable<MyRewardsResponse> pendingRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PENDING);
        return retrofitRestApi.pendingRequest(url, params);
    }

    @Override
    public Observable<MyRewardsResponse> redeemedRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.REDEEMED);
        return retrofitRestApi.redeemedRequest(url, params);
    }

    @Override
    public Observable<CardRedeemResponse> cardRedeemRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CARD_REDEEM);
        return retrofitRestApi.cardRedeemRequest(url, params);
    }

    @Override
    public Observable<Response<CardRedeemResponse>> swipeRedeemRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SWIPE_REDEEM);
        return retrofitRestApi.swipeRedeemRequest(url, params);
    }

    @Override
    public Observable<MyRewardsResponse> rewardsDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.REWARDS_DETAIL);
        return retrofitRestApi.rewardsDetailRequest(url, params);
    }

    @Override
    public Observable<Response<MyWishlistResponse>> wishlistDeleteRequest(
        Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.REMOVE_WISHLIST);
        return retrofitRestApi.wishilistDeleteRequest(url, params);
    }

    @Override
    public Observable<Response<MyWishlistResponse>> addWishlistRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_WISHLIST);
        return retrofitRestApi.addWishlistRequest(url, params);
    }

    @Override
    public Observable<Response<MyWishlistResponse>> getWishlistItems(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_WISHLIST_ITEMS);
        return retrofitRestApi.getWishlistItems(url, params);
    }

    @Override
    public Observable<Response<AllReviewsResponse>> getProductRatingReviews(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_PRODUCT_RATING_REVIEWS);
        return retrofitRestApi.getProductRatingReviews(url, params);
    }

    public Observable<Response> registerRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.REGISTER_USER);
        return retrofitRestApi.registerRequest(url, params);
    }

    @Override
    public Observable<Response<CheckoutResponse>> checkoutRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CHECKOUT);
        return retrofitRestApi.checkoutRequest(url, params);
    }

    @Override
    public Observable<Response<MyOrderListResponse>> getListOrder(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.LIST_ORDER);
        return retrofitRestApi.getListOrder(url, params);
    }

    @Override
    public Observable<Response<OrderDetailResponse>> getOrderDetail(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.VIEW_ORDER_DETAIL);
        return retrofitRestApi.getOrderDetail(url, params);
    }

    @Override
    public Observable<NotificationsResponse> notificationRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.NOTIFICATION_REQUEST);
        return retrofitRestApi.notificationRequest(url, params);
    }

    @Override
    public Observable<ComplementEmailResponse> complementEmailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.COMPLEMENT_EMAIL);
        return retrofitRestApi.complementEmailRequest(url, params);
    }

    @Override
    public Observable<Response<ResetPasswordResponse>> resetPasswordRequest(
        Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.RESET_PASSWORD);
        return retrofitRestApi.resetPasswordRequest(url, params);
    }

    @Override
    public Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
        Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SEND_CONFIRMATION_LINK);
        return retrofitRestApi.sendConfirmationLinkRequest(url, params);
    }

    @Override
    public Observable<Response<ProductDetailResponse>> getProductDetails(
        Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_PRODUCT_DETAILS);
        return retrofitRestApi.getProductDetails(url, params);
    }

    @Override
    public Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SEARCH_FILGER);
        return retrofitRestApi.searchFilterRequest(url, params);
    }

    @Override
    public Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SEARCH_RESULT);
        return retrofitRestApi.searchResultResponse(url, params);
    }

    @Override
    public Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PROMOTION_LIST);
        return retrofitRestApi.promotionListRequest(url, params);
    }

    @Override
    public Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PROMOTION_BANNER);
        return retrofitRestApi.promotionBannerRequest(url, params);
    }

    @Override
    public Observable<Response> changePasswordRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CHANGE_PASSWORD);
        return retrofitRestApi.changePasswordRequest(url, params);
    }

    @Override
    public Observable<Response<ProfileResponse>> editProfileRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.EDIT_USER_PROFILE);
        return retrofitRestApi.editProfileRequest(url, params);
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_ADDRESS);
        return retrofitRestApi.addAddressRequest(url, params);
    }

    @Override
    public Observable<Response<AddressResponse>> addAddressRequest(AddressRequest addressRequest) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_CUSTOMER_ADDRESS);
        return retrofitRestApi.addAddressRequest(url, addressRequest);
    }

    @Override
    public Observable<Response<AddressResponse>> editAddressRequest(AddressRequest addressRequest) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.EDIT_CUSTOMER_ADDRESS);
        return retrofitRestApi.editAddressRequest(url, addressRequest);
    }

    @Override
    public Observable<Response<AddressResponse>> getAddressList(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.LIST_CUSTOMER_ADDRESSES);
        return retrofitRestApi.getAddressList(url, params);
    }

    @Override
    public Observable<Response<AddressResponse>> editAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.EDIT_CUSTOMER_ADDRESS);
        return retrofitRestApi.editAddressRequest(url, params);
    }

    @Override
    public Observable<AddressResponse> myAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MY_ADDRESS);
        return retrofitRestApi.myAddressRequest(url, params);
    }

    @Override
    public Observable<Response<CartDataResponse>> viewCartDetails(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.VIEW_CART_DETAIL);
        return retrofitRestApi.viewCartDetails(url, params);
    }

    @Override
    public Observable<GetWebContentResponse> getEcmcContent() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_ECMC);
        return retrofitRestApi.getEcmcContent(url);
    }

    @Override
    public Observable<GetWebContentResponse> getContactContent() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_CONTACT_US);
        return retrofitRestApi.getContactContent(url);
    }

    @Override
    public Observable<Response<HelpSupportResponse>> helpSupportRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HELP_SUPPORT);
        return retrofitRestApi.helpSupportRequest(url, params);
    }

    @Override
    public Observable<FAQResponse> faqRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.FAQ);
        return retrofitRestApi.faqRequest(url, params);
    }

    @Override
    public Observable<TermsConditionsResponse> termsConditionsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.TERMS_CONDITIONS);
        return retrofitRestApi.termsConditionsRequest(url, params);
    }

    @Override
    public Observable<ContactUsResponse> getContactInfo() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_CONTACT_INFO);
        return retrofitRestApi.getContactInfo(url);
    }

    @Override
    public Observable<Response> contactMessageRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CONTACT_MESSAGE);
        return retrofitRestApi.contactMessageRequest(url, params);
    }

    @Override
    public Observable<Response> settingsLogoutRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SETTING_LOGOUT);
        return retrofitRestApi.settingsLogoutRequest(url, params);
    }

    @Override
    public Observable<Response<MyPointsResponse>> myPointsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MY_POINTS);
        return retrofitRestApi.myPointsRequest(url, params);
    }

    @Override
    public Observable<Response<MyPointsResponse>> getGoShopPointsDetails(
        Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_GOSHOP_POINTS_DETAIL);
        return retrofitRestApi.getGoShopPointsDetails(url, params);
    }

    @Override
    public Observable<PaymentStatusResponse> paymentStatusRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PAYMENT_STATUS);
        return retrofitRestApi.paymentStatusRequest(url, params);
    }

    @Override
    public Observable<AddressResponse> selectAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SELECT_ADDRESS);
        return retrofitRestApi.selectAddressRequest(url, params);
    }

    @Override
    public Observable<Response<CategoryResponse>> getCategory(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CATEGORY_TREE);
        return retrofitRestApi.getCategory(url, params);
    }

    @Override
    public Observable<CategoryResponse> categoryRightMenuRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CATEGORY_RIGHT);
        return retrofitRestApi.categoryRightMenuRequest(url, params);
    }

    @Override
    public Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CATEGORY_DETAIL);
        return retrofitRestApi.categoryDetailRequest(url, params);
    }

    @Override
    public Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.TV_SHOWS);
        return retrofitRestApi.rightVideoRequest(url, params);
    }

    @Override
    public Observable<TVShowResponse> tvShowRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.TV_SHOWS);
        return retrofitRestApi.tvShowRequest(url, params);
    }

    @Override
    public Observable<Response<QuestionAnswerResponse>> listProductQA(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.LIST_PRODUCT_QUESTION_ANSWER);
        return retrofitRestApi.listProductQA(url, params);
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.QUESTION_ANSWER);
        return retrofitRestApi.qaDetailRequest(url, params);
    }

    @Override
    public Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PROMOTION_SKU);
        return retrofitRestApi.promotionSkuRequest(url, params);
    }

    @Override
    public Observable<Response<ProfileResponse>> getUserProfile(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_USER_PROFILE);
        return retrofitRestApi.getUserProfile(url, params);
    }

    @Override
    public Observable<Response<ProfileMetadataResponse>> getProfileMetadata() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_PROFILE_METADATA);
        return retrofitRestApi.getProfileMetadata(url);
    }

    @Override
    public Observable<Response<LoginResponse>> loginRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.LOGIN);
        return retrofitRestApi.loginRequest(url, params);
    }

    @Override
    public Observable<Response<LoginResponse>> facebookLoginRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.LOGIN_WITH_FB);
        return retrofitRestApi.facebookLoginRequest(url, params);
    }

    @Override
    public Observable<Response<StatesResponse>> getStates(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_STATES);
        return retrofitRestApi.getStates(url,params);
    }

    @Override
    public Observable<Response<CityResponse>> getCity(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_CITY);
        return retrofitRestApi.getCity(url,params);
    }

    @Override
    public Observable<Response<ZipCodeResponse>> getZipCode(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_ZIPCODE);
        return retrofitRestApi.getZipCode(url,params);
    }

    @Override
    public Observable<Response> writeReviewRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_PRODUCT_REVIEW);
        return retrofitRestApi.writeReviewRequest(url, params);
    }

    @Override
    public Observable<Response> submitQuestions(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SUBMIT_QUESTIONS);
        return retrofitRestApi.submitQuestions(url, params);
    }

    @Override
    public Observable<Response<DeliveryCheckResponse>> deliveryCheckRequest(
        Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.DELIVERY_CHECK);
        return retrofitRestApi.deliveryCheckRequest(url, params);
    }

    @Override
    public Observable<Response<OrderResponse>> cancelOrderRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CANCEL_ORDER);
        return retrofitRestApi.cancelOrderRequest(url, params);
    }

    @Override
    public Observable<Response<OrderResponse>> returnOrderRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.RETURN_ORDER);
        return retrofitRestApi.returnOrderRequest(url, params);
    }

    @Override
    public Observable<Response> selectDefaultShippingRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.DEFAULT_SHIPPING_ADDRESS);
        return retrofitRestApi.selectDefaultShippingRequest(url, params);
    }

    @Override
    public Observable<Response> selectDefaultBillingRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.DEFAULT_BILLING_ADDRESS);
        return retrofitRestApi.selectDefaultBillingRequest(url, params);
    }

    @Override
    public Observable<Response<BannerResponse>> getHomeBanner(HashMap<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_BANNER);
        return retrofitRestApi.getHomeBanner(url, params);
    }

    @Override
    public Observable<Response<OnAirScheduleResponse>> getOnAirSchedule(
        HashMap<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_ON_AIR_SCHEDULE);
        return retrofitRestApi.getOnAirSchedule(url, params);
    }

    public Observable<Response<CartDataResponse>> addToCartRequest(AddRemoveCartRequest request) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_REMOVE_CART);
        return retrofitRestApi.addToCartRequest(url, request);
    }

    @Override
    public Observable<Response<CartDataResponse>> removeFromCartRequest(
        AddRemoveCartRequest request) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_REMOVE_CART);
        return retrofitRestApi.removeFromCartRequest(url, request);
    }

    @Override
    public Observable<Response<CartDataResponse>> updateCartRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.UPDATE_CART);
        return retrofitRestApi.updateCartRequest(url, params);
    }

    @Override
    public Observable<Response<ApplyCouponResponse>> applyCoupon(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.APPLY_COUPON);
        return retrofitRestApi.applyCoupon(url, params);
    }

    @Override
    public Observable<Response<ApplyPointsResponse>> applyGoShopPoints(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.APPLY_GOSHOP_POINTS);
        return retrofitRestApi.applyGoShopPoints(url, params);
    }

    @Override
    public Observable<Response<ApplyEGiftResponse>> applyEGiftCard(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.APPLY_EGIFTCART);
        return retrofitRestApi.applyEGiftCard(url, params);
    }

    @Override
    public Observable<Response<OrderMetadataResponse>> getOrderMetadata(
        Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_ORDER_METADATA);
        return retrofitRestApi.getOrderMetadata(url, params);
    }

    @Override
    public Observable<Response<PaymentResponse>> paymentRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PLACE_ORDER);
        return retrofitRestApi.paymentRequest(url, params);
    }
}

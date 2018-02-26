package com.goshop.app.data.retrofit;

import com.goshop.app.data.EndpointAddress;
import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.AddressResponse;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.CategoryMenuResponse;
import com.goshop.app.data.model.ComplementEmailResponse;
import com.goshop.app.data.model.ContactUsResponse;
import com.goshop.app.data.model.FAQResponse;
import com.goshop.app.data.model.GetSettingsResponse;
import com.goshop.app.data.model.GetWebContentResponse;
import com.goshop.app.data.model.HelpSupportResponse;
import com.goshop.app.data.model.MyPointsResponse;
import com.goshop.app.data.model.PasswordResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ProfileResponse;
import com.goshop.app.data.model.ResetPasswordResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
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
    public Observable<WidgetListResponse> trendingNowRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_PAGE);
        return retrofitRestApi.trendingNowRequest(url, params);
    }

    @Override
    public Observable<BrandsResponse> brandsPageRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_PAGE);
        return retrofitRestApi.brandsPageRequest(url, params);
    }

    @Override
    public Observable<ProductDetailResponse> pdpDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PDP_DETAILS);
        return retrofitRestApi.pdpDetailRequest(url, params);
    }

    @Override
    public Observable<GetWeatherResponse> getWeather(String id) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.USER_INFO);
        return retrofitRestApi.getWeather(url);
    }

    @Override
    public Observable<UserInfo> getUser(String username, String password) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.USER_INFO);
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setUserName(username);
        getUserRequest.setPassword(password);
        return retrofitRestApi.getUserInfo(url, getUserRequest);
    }

    public Observable<UserInfo> registerRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.REGISTER);
        return retrofitRestApi.registerRequest(url, params);
    }

    @Override
    public Observable<HomeResponse> homeRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_REQUEST);
        return retrofitRestApi.homeRequest(url, params);
    }

    @Override
    public Observable<CheckoutResponse> checkoutRequest(String sessionkey) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CHECKOUT_REQUEST);
        return retrofitRestApi.checkoutRequest(url, sessionkey);
    }

    @Override
    public Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MYORDER_LIST_REQUEST);
        return retrofitRestApi.myOrderListRequest(url, params);
    }

    @Override
    public Observable<MyOrderDetailResponse> myOrderDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MYORDER_DETAIL_REQUEST);
        return retrofitRestApi.myOrderDetailRequest(url, params);
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
    public Observable<ResetPasswordResponse> resetPasswordRequest(Map<String, Object> params) {
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
    public Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PRODUCT_DETAIL);
        return retrofitRestApi.productDetailRequest(url, params);
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
    public Observable<PasswordResponse> changePasswordRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CHANGE_PASSWORD);
        return retrofitRestApi.changePasswordRequest(url, params);
    }

    @Override
    public Observable<ProfileResponse> editProfileRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.EDIT_PROFILE);
        return retrofitRestApi.editProfileRequest(url, params);
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_ADDRESS);
        return retrofitRestApi.addAddressRequest(url, params);
    }

    @Override
    public Observable<AddressResponse> myAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MY_ADDRESS);
        return retrofitRestApi.myAddressRequest(url, params);
    }

    @Override
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SHOPPINT_CART);
        return retrofitRestApi.shoppingCartRequest(url, params);
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
    public Observable<HelpSupportResponse> helpSupportRequest(Map<String, Object> params) {
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
    public Observable<ContactUsResponse> contactMessageRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CONTACT_MESSAGE);
        return retrofitRestApi.contactMessageRequest(url, params);
    }

    @Override
    public Observable<GetSettingsResponse> getSettingsDetail() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SETTING_DETAILS);
        return retrofitRestApi.getSettingsDetail(url);
    }

    @Override
    public Observable<MyPointsResponse> myPointsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MY_POINTS);
        return retrofitRestApi.myPointsRequest(url, params);
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
    public Observable<CategoryMenuResponse> getCategoryLeftMenu() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CATEGORY_LEFT);
        return retrofitRestApi.getCategoryLeftMenu(url);
    }

    @Override
    public Observable<CategoryMenuResponse> categoryRightMenuRequest(Map<String, Object> params) {
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
    public Observable<TVShowResponse> leftVideoRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.TV_SHOWS);
        return retrofitRestApi.leftVideoRequest(url, params);
    }
}

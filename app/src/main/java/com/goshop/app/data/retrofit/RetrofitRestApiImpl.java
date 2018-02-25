package com.goshop.app.data.retrofit;

import com.goshop.app.data.EndpointAddress;
import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.AddressReponse;
import com.goshop.app.data.model.BrandsReponse;
import com.goshop.app.data.model.CategoryMenuResponse;
import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ContactUsReponse;
import com.goshop.app.data.model.FAQReponse;
import com.goshop.app.data.model.GetSettingsReponse;
import com.goshop.app.data.model.GetWebContentReponse;
import com.goshop.app.data.model.HelpSupportReponse;
import com.goshop.app.data.model.MyPointsReponse;
import com.goshop.app.data.model.PasswordReponse;
import com.goshop.app.data.model.PaymentStatusReponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ProfileReponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowReponse;
import com.goshop.app.data.model.TermsConditionsReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.request.GetUserRequest;
import com.goshop.app.data.model.response.BaseWidgetReponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.WidgetListReponse;

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
    public Observable<WidgetListReponse> homePageRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HOME_PAGE);
        return retrofitRestApi.homePageRequest(url, params);
    }

    @Override
    public Observable<BrandsReponse> brandsPageRequest(Map<String, Object> params) {
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
    public Observable<MyOrderDetailReponse> myOrderDetailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MYORDER_DETAIL_REQUEST);
        return retrofitRestApi.myOrderDetailRequest(url, params);
    }

    @Override
    public Observable<NotificationsResponse> notificationRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.NOTIFICATION_REQUEST);
        return retrofitRestApi.notificationRequest(url, params);
    }

    @Override
    public Observable<ComplementEmailReponse> complementEmailRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.COMPLEMENT_EMAIL);
        return retrofitRestApi.complementEmailRequest(url, params);
    }

    @Override
    public Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.RESET_PASSWORD);
        return retrofitRestApi.resetPasswordRequest(url, params);
    }

    @Override
    public Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(
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
    public Observable<PasswordReponse> changePasswordRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CHANGE_PASSWORD);
        return retrofitRestApi.changePasswordRequest(url, params);
    }

    @Override
    public Observable<ProfileReponse> editProfileRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.EDIT_PROFILE);
        return retrofitRestApi.editProfileRequest(url, params);
    }

    @Override
    public Observable<AddressReponse> addAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.ADD_ADDRESS);
        return retrofitRestApi.addAddressRequest(url, params);
    }

    @Override
    public Observable<AddressReponse> myAddressRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MY_ADDRESS);
        return retrofitRestApi.myAddressRequest(url, params);
    }

    @Override
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SHOPPINT_CART);
        return retrofitRestApi.shoppingCartRequest(url, params);
    }

    @Override
    public Observable<GetWebContentReponse> getEcmcContent() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_ECMC);
        return retrofitRestApi.getEcmcContent(url);
    }

    @Override
    public Observable<GetWebContentReponse> getContactContent() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_CONTACT_US);
        return retrofitRestApi.getContactContent(url);
    }

    @Override
    public Observable<HelpSupportReponse> helpSupportRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.HELP_SUPPORT);
        return retrofitRestApi.helpSupportRequest(url, params);
    }

    @Override
    public Observable<FAQReponse> faqRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.FAQ);
        return retrofitRestApi.faqRequest(url, params);
    }

    @Override
    public Observable<TermsConditionsReponse> termsConditionsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.TERMS_CONDITIONS);
        return retrofitRestApi.termsConditionsRequest(url, params);
    }

    @Override
    public Observable<ContactUsReponse> getContactInfo() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.GET_CONTACT_INFO);
        return retrofitRestApi.getContactInfo(url);
    }

    @Override
    public Observable<ContactUsReponse> contactMessageRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.CONTACT_MESSAGE);
        return retrofitRestApi.contactMessageRequest(url, params);
    }

    @Override
    public Observable<GetSettingsReponse> getSettingsDetail() {
        String url = EndpointAddress.getFullUrl(EndpointAddress.SETTING_DETAILS);
        return retrofitRestApi.getSettingsDetail(url);
    }

    @Override
    public Observable<MyPointsReponse> myPointsRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.MY_POINTS);
        return retrofitRestApi.myPointsRequest(url, params);
    }

    @Override
    public Observable<PaymentStatusReponse> paymentStatusRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.PAYMENT_STATUS);
        return retrofitRestApi.paymentStatusRequest(url, params);
    }

    @Override
    public Observable<AddressReponse> selectAddressRequest(Map<String, Object> params) {
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
    public Observable<TVShowReponse> rightVideoRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.TV_SHOWS);
        return retrofitRestApi.rightVideoRequest(url, params);
    }

    @Override
    public Observable<TVShowReponse> leftVideoRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.TV_SHOWS);
        return retrofitRestApi.leftVideoRequest(url, params);
    }
}

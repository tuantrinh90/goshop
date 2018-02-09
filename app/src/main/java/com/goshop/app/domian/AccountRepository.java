package com.goshop.app.domian;

import com.goshop.app.data.model.AddressReponse;
import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ContactUsReponse;
import com.goshop.app.data.model.FAQReponse;
import com.goshop.app.data.model.GetSettingsReponse;
import com.goshop.app.data.model.GetWebContentReponse;
import com.goshop.app.data.model.HelpSupportReponse;
import com.goshop.app.data.model.MyPointsReponse;
import com.goshop.app.data.model.PasswordReponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ProfileReponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TermsConditionsReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.Weather;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.MyOrderDetailReponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface AccountRepository {

    Observable<UserInfo> getUserInfo(String userId);

    Observable<UserInfo> getUserInfo(String username, String password);

    Observable<Weather> getWeather();

    Observable<UserInfo> registerRequest(Map<String, Object> params);

    Observable<HomeResponse> homeRequest(Map<String, Object> params);

    Observable<CheckoutResponse> checkoutRequest(String sessionKey);

    Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params);

    Observable<MyOrderDetailReponse> myOrderDetailRequest(Map<String, Object> params);

    Observable<NotificationsResponse> notificationRequest(Map<String, Object> params);

    Observable<ComplementEmailReponse> complementEmailRequest(Map<String, Object> params);

    Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params);

    Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(Map<String, Object> params);

    Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params);

    Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params);

    Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params);

    Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params);

    Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params);

    Observable<PasswordReponse> changePasswordRequest(Map<String, Object> params);

    Observable<ProfileReponse> editProfileRequest(Map<String, Object> params);

    Observable<AddressReponse> addAddressRequest(Map<String, Object> params);

    Observable<AddressReponse> myAddressRequest(Map<String, Object> params);

    Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params);

    Observable<GetWebContentReponse> getEcmcContent();

    Observable<GetWebContentReponse> getContactContent();

    Observable<HelpSupportReponse> helpSupportRequest(Map<String, Object> params);

    Observable<FAQReponse> faqRequest(Map<String, Object> params);

    Observable<TermsConditionsReponse> termsConditionsRequest(Map<String, Object> params);

    Observable<ContactUsReponse> getContactInfo();

    Observable<ContactUsReponse> contactMessageRequest(Map<String, Object> params);

    Observable<GetSettingsReponse> getSettingsDetail();

    Observable<MyPointsReponse> myPointsRequest(Map<String, Object> params);
}

package com.goshop.app.domian;

import com.goshop.app.data.model.AddressReponse;
import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ContactUsReponse;
import com.goshop.app.data.model.FAQReponse;
import com.goshop.app.data.model.GetWebContentReponse;
import com.goshop.app.data.model.HelpSupportReponse;
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
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.data.source.AccountDataSource;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ray on 2018/1/5.
 */

public class AccountDataRepository implements AccountRepository {

    private AccountDataSource accountCloudDataSource;

    private AccountDataSource accountLocalDataSource;

    @Inject
    public AccountDataRepository(
        @Named("cloudAccountDataSource") AccountDataSource accountCloudDataSource,
        @Named("localAccountDataSource") AccountDataSource accountLocalDataSource) {
        this.accountCloudDataSource = accountCloudDataSource;
        this.accountLocalDataSource = accountLocalDataSource;
    }

    @Override
    public Observable<UserInfo> getUserInfo(String id) {
        return accountCloudDataSource.getUserInfo(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<UserInfo> getUserInfo(String username, String password) {
        return accountCloudDataSource.getUserInfo(username, password);
    }

    @Override
    public Observable<Weather> getWeather() {
        return accountCloudDataSource.getWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap(getWeatherResponse -> {
                if (getWeatherResponse != null && getWeatherResponse.getWeatherinfo()
                    .getCity() != null) {
                    return Observable.just(getWeatherResponse.getWeatherinfo());
                } else {
                    return Observable.error(new ServiceApiFail("error"));
                }
            });
    }

    public Observable<UserInfo> registerRequest(Map<String, Object> params) {
        return accountCloudDataSource.registerRequest(params);
    }

    @Override
    public Observable<HomeResponse> homeRequest(Map<String, Object> params) {
        return accountCloudDataSource.homeRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<CheckoutResponse> checkoutRequest(String sessionKey) {
        return accountCloudDataSource.checkoutRequest(sessionKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<MyOrderListResponse> myOrderListRequest(Map<String, Object> params) {
        return accountCloudDataSource.myOrderListRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<MyOrderDetailReponse> myOrderDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.myOrderDetailRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<NotificationsResponse> notificationRequest(Map<String, Object> params) {
        return accountCloudDataSource.notificationRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ComplementEmailReponse> complementEmailRequest(Map<String, Object> params) {
        return accountCloudDataSource.complementEmailRequest(params);
    }

    @Override
    public Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params) {
        return accountCloudDataSource.resetPasswordRequest(params);
    }

    @Override
    public Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(
        Map<String, Object> params) {
        return accountCloudDataSource.sendConfirmationLinkRequest(params);
    }

    @Override
    public Observable<ProductDetailResponse> productDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.productDetailRequest(params);
    }

    @Override
    public Observable<PromotionListResponse> promotionListRequest(Map<String, Object> params) {
        return accountCloudDataSource.promotionListRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<PromotionBannerResponse> promotionBannerRequest(Map<String, Object> params) {
        return accountCloudDataSource.promotionBannerRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params) {
        return accountCloudDataSource.searchFilterRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params) {
        return accountCloudDataSource.searchResultResponse(params);
    }

    @Override
    public Observable<PasswordReponse> changePasswordRequest(Map<String, Object> params) {
        return accountCloudDataSource.changePasswordRequest(params);
    }

    @Override
    public Observable<ProfileReponse> editProfileRequest(Map<String, Object> params) {
        return accountCloudDataSource.editProfileRequest(params);
    }

    @Override
    public Observable<AddressReponse> addAddressRequest(Map<String, Object> params) {
        return accountCloudDataSource.addAddressRequest(params);
    }

    @Override
    public Observable<AddressReponse> myAddressRequest(Map<String, Object> params) {
        return accountCloudDataSource.addAddressRequest(params);
    }

    @Override
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
        return accountCloudDataSource.shoppingCartRequest(params);
    }

    @Override
    public Observable<GetWebContentReponse> getEcmcContent() {
        return accountCloudDataSource.getEcmcContent();
    }

    @Override
    public Observable<GetWebContentReponse> getContactContent() {
        return accountCloudDataSource.getContactContent();
    }

    @Override
    public Observable<HelpSupportReponse> helpSupportRequest(Map<String, Object> params) {
        return accountCloudDataSource.helpSupportRequest(params);
    }

    @Override
    public Observable<FAQReponse> faqRequest(Map<String, Object> params) {
        return accountCloudDataSource.faqRequest(params);
    }

    @Override
    public Observable<TermsConditionsReponse> termsConditionsRequest(Map<String, Object> params) {
        return accountCloudDataSource.termsConditionsRequest(params);
    }

    @Override
    public Observable<ContactUsReponse> getContactInfo() {
        return accountCloudDataSource.getContactInfo();
    }

    @Override
    public Observable<ContactUsReponse> contactMessageRequest(Map<String, Object> params) {
        return accountCloudDataSource.contactMessageRequest(params);
    }
}

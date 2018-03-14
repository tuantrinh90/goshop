package com.goshop.app.domian;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
import com.goshop.app.data.model.MyWishlistResponse;
import com.goshop.app.data.model.OrderDetailResponse;
import com.goshop.app.data.model.PasswordResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ProfileResponse;
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.QuestionAnswerResponse;
import com.goshop.app.data.model.ResetPasswordResponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.SettingsLogoutResponse;
import com.goshop.app.data.model.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.Weather;
import com.goshop.app.data.model.response.BaseWidgetResponse;
import com.goshop.app.data.model.response.CarouselResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.data.model.response.MyOrderDetailResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.OfferListResponse;
import com.goshop.app.data.model.response.ProductScrollerResponse;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.model.response.VideoPlayerResponse;
import com.goshop.app.data.model.response.WidgetListResponse;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.data.source.AccountDataSource;
import com.goshop.app.utils.MockJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
    public Observable<WidgetListResponse> trendingNowRequest(Map<String, Object> params) {
        //TODO this is mock data , will delete later
        WidgetListResponse widgetListResponse = new WidgetListResponse();
        List<BaseWidgetResponse> baseWidgets = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(MockJson.JSON_DATA);
        JsonObject object = element.getAsJsonObject();
        JsonArray array = object.getAsJsonArray("widgetlist");
        for (int i = 0; i < array.size(); i++) {
            JsonElement arrayElement = array.get(i);
            JsonObject arrayObject = arrayElement.getAsJsonObject();
            String name = arrayObject.getAsJsonPrimitive("name").getAsString();

            if (name.equals("Carousel")) {
                CarouselResponse carouselReponse = new Gson()
                    .fromJson(arrayObject, CarouselResponse.class);
                baseWidgets.add(carouselReponse);
            }
            if (name.equals("VideoPlayer")) {
                VideoPlayerResponse videoPlayerReponse = new Gson()
                    .fromJson(arrayObject, VideoPlayerResponse.class);
                baseWidgets.add(videoPlayerReponse);
            }
            if (name.equals("OfferList")) {
                OfferListResponse offerListReponse = new Gson()
                    .fromJson(arrayObject, OfferListResponse.class);
                baseWidgets.add(offerListReponse);
            }
            if (name.equals("ProductScroller")) {
                ProductScrollerResponse carouselReponse = new Gson()
                    .fromJson(arrayObject, ProductScrollerResponse.class);
                baseWidgets.add(carouselReponse);
            }
        }
        widgetListResponse.setWidgetlist(baseWidgets);
        return Observable.just(widgetListResponse);
//        return accountCloudDataSource.trendingNowRequest(params);
    }

    @Override
    public Observable<BrandsResponse> brandsRequest(Map<String, Object> params) {
        return accountCloudDataSource.brandsRequest(params);
    }

    @Override
    public Observable<BrandsResponse> brandsDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.brandsDetailRequest(params);
    }

    @Override
    public Observable<MyEGiftResponse> eGiftCardsRequest(Map<String, Object> params) {
        return accountCloudDataSource.eGiftCardsRequest(params);
    }

    @Override
    public Observable<GoLoyaltyResponse> goLoyaltyRequest(Map<String, Object> params) {
        return accountCloudDataSource.goLoyaltyRequest(params);
    }

    @Override
    public Observable<AllDealsResponse> allDealsRequest(Map<String, Object> params) {
        return accountCloudDataSource.allDealsRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> expiredRequest(Map<String, Object> params) {
        return accountCloudDataSource.expiredRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> pendingRequest(Map<String, Object> params) {
        return accountCloudDataSource.pendingRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> redeemedRequest(Map<String, Object> params) {
        return accountCloudDataSource.redeemedRequest(params);
    }

    @Override
    public Observable<CardRedeemResponse> cardRedeemRequest(Map<String, Object> params) {
        return accountCloudDataSource.cardRedeemRequest(params);
    }

    @Override
    public Observable<CardRedeemResponse> swipeRedeemRequest(Map<String, Object> params) {
        return accountCloudDataSource.swipeRedeemRequest(params);
    }

    @Override
    public Observable<MyRewardsResponse> rewardsDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.rewardsDetailRequest(params);
    }

    @Override
    public Observable<MyWishlistResponse> myWishlistRequest(Map<String, Object> params) {
        return accountCloudDataSource.myWishlistRequest(params);
    }

    @Override
    public Observable<ProductDetailResponse> pdpDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.pdpDetailRequest(params);
    }

    @Override
    public Observable<AllReviewsResponse> allReviewsRequest(Map<String, Object> params) {
        return accountCloudDataSource.allReviewsRequest(params);
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
    public Observable<MyOrderListResponse> myOrdersRequest(Map<String, Object> params) {
        return accountCloudDataSource.myOrdersRequest(params);
    }

    @Override
    public Observable<OrderDetailResponse> orderDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.orderDetailRequest(params);
    }

    @Override
    public Observable<MyOrderDetailResponse> myOrderDetailRequest(Map<String, Object> params) {
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
    public Observable<ComplementEmailResponse> complementEmailRequest(Map<String, Object> params) {
        return accountCloudDataSource.complementEmailRequest(params);
    }

    @Override
    public Observable<ResetPasswordResponse> resetPasswordRequest(Map<String, Object> params) {
        return accountCloudDataSource.resetPasswordRequest(params);
    }

    @Override
    public Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
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
    public Observable<PasswordResponse> changePasswordRequest(Map<String, Object> params) {
        return accountCloudDataSource.changePasswordRequest(params);
    }

    @Override
    public Observable<ProfileResponse> editProfileRequest(Map<String, Object> params) {
        return accountCloudDataSource.editProfileRequest(params);
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(Map<String, Object> params) {
        return accountCloudDataSource.addAddressRequest(params);
    }

    @Override
    public Observable<AddressResponse> editAddressRequest(Map<String, Object> params) {
        return accountCloudDataSource.editAddressRequest(params);
    }

    @Override
    public Observable<AddressResponse> myAddressRequest(Map<String, Object> params) {
        return accountCloudDataSource.addAddressRequest(params);
    }

    @Override
    public Observable<ShoppingCartResponse> shoppingCartRequest(Map<String, Object> params) {
        return accountCloudDataSource.shoppingCartRequest(params);
    }

    @Override
    public Observable<GetWebContentResponse> getEcmcContent() {
        return accountCloudDataSource.getEcmcContent();
    }

    @Override
    public Observable<GetWebContentResponse> getContactContent() {
        return accountCloudDataSource.getContactContent();
    }

    @Override
    public Observable<HelpSupportResponse> helpSupportRequest(Map<String, Object> params) {
        return accountCloudDataSource.helpSupportRequest(params);
    }

    @Override
    public Observable<FAQResponse> faqRequest(Map<String, Object> params) {
        return accountCloudDataSource.faqRequest(params);
    }

    @Override
    public Observable<TermsConditionsResponse> termsConditionsRequest(Map<String, Object> params) {
        return accountCloudDataSource.termsConditionsRequest(params);
    }

    @Override
    public Observable<ContactUsResponse> getContactInfo() {
        return accountCloudDataSource.getContactInfo();
    }

    @Override
    public Observable<ContactUsResponse> contactMessageRequest(Map<String, Object> params) {
        return accountCloudDataSource.contactMessageRequest(params);
    }

    @Override
    public Observable<SettingsLogoutResponse> settingsLogoutRequest(Map<String, Object> params) {
        return accountCloudDataSource.settingsLogoutRequest(params);
    }

    @Override
    public Observable<MyPointsResponse> myPointsRequest(Map<String, Object> params) {
        return accountCloudDataSource.myPointsRequest(params);
    }

    @Override
    public Observable<PaymentStatusResponse> paymentStatusRequest(Map<String, Object> params) {
        return accountCloudDataSource.paymentStatusRequest(params);
    }

    @Override
    public Observable<AddressResponse> selectAddressRequest(Map<String, Object> params) {
        return accountCloudDataSource.selectAddressRequest(params);
    }

    @Override
    public Observable<CategoryMenuResponse> getCategoryLeftMenu() {
        return accountCloudDataSource.getCategoryLeftMenu();
    }

    @Override
    public Observable<CategoryMenuResponse> categoryRightMenuRequest(Map<String, Object> params) {
        return accountCloudDataSource.categoryRightMenuRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> categoryDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.categoryDetailRequest(params);
    }

    @Override
    public Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params) {
        return accountCloudDataSource.rightVideoRequest(params);
    }

    @Override
    public Observable<TVShowResponse> leftVideoRequest(Map<String, Object> params) {
        return accountCloudDataSource.leftVideoRequest(params);
    }

    @Override
    public Observable<QuestionAnswerResponse> allQARequest(Map<String, Object> params) {
        return accountCloudDataSource.allQARequest(params);
    }

    @Override
    public Observable<QuestionAnswerResponse> qaDetailRequest(Map<String, Object> params) {
        return accountCloudDataSource.qaDetailRequest(params);
    }

    @Override
    public Observable<PromotionSkuResponse> promotionSkuRequest(Map<String, Object> params) {
        return accountCloudDataSource.promotionSkuRequest(params);
    }
}

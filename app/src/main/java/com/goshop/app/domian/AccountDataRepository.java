package com.goshop.app.domian;

import com.goshop.app.Const;
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
import com.goshop.app.data.model.response.ApplyCouponResponse;
import com.goshop.app.data.model.response.ApplyEGiftResponse;
import com.goshop.app.data.model.response.ApplyPointsResponse;
import com.goshop.app.data.model.response.OrderDetailResponse;
import com.goshop.app.data.model.PaymentStatusResponse;
import com.goshop.app.data.model.SendConfirmationLinkResponse;
import com.goshop.app.data.model.response.ShoppingCartResponse;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.data.model.TermsConditionsResponse;
import com.goshop.app.data.model.request.AddressRequest;
import com.goshop.app.data.model.response.AddressResponse;
import com.goshop.app.data.model.response.CheckoutResponse;
import com.goshop.app.data.model.response.CityResponse;
import com.goshop.app.data.model.response.LoginResponse;
import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.data.model.response.OrderResponse;
import com.goshop.app.data.model.response.ProfileMetadataResponse;
import com.goshop.app.data.model.response.ProfileResponse;
import com.goshop.app.data.model.response.ResetPasswordResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.StatesResponse;
import com.goshop.app.data.model.response.TrendingNowResponse;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.model.response.ZipCodeResponse;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.data.source.AccountDataSource;
import com.goshop.app.presentation.model.FlagsVM;

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
    public Observable<TrendingNowResponse> trendingNowRequest(Map<String, Object> params) {
        //TODO this is mock data , will delete later
       /* WidgetListResponse widgetListResponse = new WidgetListResponse();
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
        return Observable.just(widgetListResponse);*/
        return accountCloudDataSource.trendingNowRequest(params);
    }

    @Override
    public Observable<Response<MyEGiftResponse>> eGiftCardsRequest(Map<String, Object> params) {
        return accountCloudDataSource.eGiftCardsRequest(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap(response -> {
                if (response != null && isSuccess(response.getMessage().getStatus())) {
                    return Observable.just(response);
                } else {
                    return Observable
                        .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
                }
            });
    }

    @Override
    public Observable<Response<MyEGiftResponse>> getEGiftCardDetails(Map<String, Object> params) {
        return accountCloudDataSource.getEGiftCardDetails(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
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
    public Observable<Response<MyWishlistResponse>> wishlistDeleteRequest(
        Map<String, Object> params) {
        return accountCloudDataSource.wishlistDeleteRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<MyWishlistResponse>> addWishlistRequest(Map<String, Object> params) {
        return accountCloudDataSource.addWishlistRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<MyWishlistResponse>> getWishlistItems(Map<String, Object> params) {
        return accountCloudDataSource.getWishlistItems(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<AllReviewsResponse>> getProductRatingReviews(
        Map<String, Object> params) {
        return accountCloudDataSource.getProductRatingReviews(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response> registerRequest(Map<String, Object> params) {
        return accountCloudDataSource.registerRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<CheckoutResponse> checkoutRequest(String sessionKey) {
        return accountCloudDataSource.checkoutRequest(sessionKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }



    @Override
    public Observable<Response<MyOrderListResponse>> getListOrder(Map<String, Object> params) {
        return accountCloudDataSource.getListOrder(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<OrderDetailResponse>> getOrderDetail(Map<String, Object> params) {
        return accountCloudDataSource.getOrderDetail(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
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
    public Observable<Response<ResetPasswordResponse>> resetPasswordRequest(
        Map<String, Object> params) {
        return accountCloudDataSource.resetPasswordRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<SendConfirmationLinkResponse> sendConfirmationLinkRequest(
        Map<String, Object> params) {
        return accountCloudDataSource.sendConfirmationLinkRequest(params);
    }

    @Override
    public Observable<Response> changePasswordRequest(Map<String, Object> params) {
        return accountCloudDataSource.changePasswordRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<ProfileResponse>> editProfileRequest(Map<String, Object> params) {
        return accountCloudDataSource.editProfileRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<AddressResponse> addAddressRequest(Map<String, Object> params) {
        return accountCloudDataSource.addAddressRequest(params);
    }

    @Override
    public Observable<Response<AddressResponse>> addAddressRequest(AddressRequest addressRequest) {
        return accountCloudDataSource.addAddressRequest(addressRequest).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<AddressResponse>> editAddressRequest(AddressRequest addressRequest) {
        return accountCloudDataSource.editAddressRequest(addressRequest).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
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
    public Observable<Response<AddressResponse>> getAddressList(Map<String, Object> params) {
        return accountCloudDataSource.getAddressList(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<ShoppingCartResponse>> viewCartDetails(Map<String, Object> params) {
        return accountCloudDataSource.viewCartDetails(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
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
    public Observable<Response> settingsLogoutRequest(Map<String, Object> params) {
        return accountCloudDataSource.settingsLogoutRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
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
    public Observable<TVShowResponse> rightVideoRequest(Map<String, Object> params) {
        return accountCloudDataSource.rightVideoRequest(params);
    }

    @Override
    public Observable<TVShowResponse> tvShowRequest(Map<String, Object> params) {
        return accountCloudDataSource.tvShowRequest(params);
    }

    @Override
    public Observable<Response<ProfileResponse>> getUserProfile(Map<String, Object> params) {
        return accountCloudDataSource.getUserProfile(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<ProfileMetadataResponse>> getProfileMetadata() {
        return accountCloudDataSource.getProfileMetadata().concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<LoginResponse>> loginRequest(Map<String, Object> params) {
        return accountCloudDataSource.loginRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<LoginResponse>> facebookLoginRequest(Map<String, Object> params) {
        return accountCloudDataSource.facebookLoginRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> saveUserInfo(UserData customer) {
        return accountLocalDataSource.saveUserInfo(customer);
    }

    @Override
    public Observable<UserData> getUserInfo() {
        return accountLocalDataSource.getUserInfo();
    }

    @Override
    public Observable<Boolean> clearUserInfo() {
        return accountLocalDataSource.clearUserInfo();
    }

    @Override
    public Observable<Response<StatesResponse>> getStates(Map<String, Object> params) {
        return accountCloudDataSource.getStates(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<CityResponse>> getCity(Map<String, Object> params) {
        return accountCloudDataSource.getCity(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<ZipCodeResponse>> getZipCode(Map<String, Object> params) {
        return accountCloudDataSource.getZipCode(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<OrderResponse>> cancelOrderRequest(Map<String, Object> params) {
        return accountCloudDataSource.cancelOrderRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<OrderResponse>> returnOrderRequest(Map<String, Object> params) {
        return accountCloudDataSource.returnOrderRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response> selectDefaultShippingRequest(Map<String, Object> params) {
        return accountCloudDataSource.selectDefaultShippingRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response> selectDefaultBillingRequest(Map<String, Object> params) {
        return accountCloudDataSource.selectDefaultBillingRequest(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<FlagsVM> getFlags() {
        return accountLocalDataSource.getFlags();
    }

    @Override
    public Observable<Object> saveFlags(FlagsVM flagsVM) {
        return accountLocalDataSource.saveFlags(flagsVM);
    }

    @Override
    public Observable<Response<ApplyCouponResponse>> applyCoupon(Map<String, Object> params) {
        return accountCloudDataSource.applyCoupon(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<ApplyPointsResponse>> applyGoShopPoints(Map<String, Object> params) {
        return accountCloudDataSource.applyGoShopPoints(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<ApplyEGiftResponse>> applyEGiftCard(Map<String, Object> params) {
        return accountCloudDataSource.applyEGiftCard(params).concatMap(response -> {
            if (isSuccess(response.getMessage().getStatus())) {
                return Observable.just(response);
            } else {
                return Observable
                    .error(new ServiceApiFail(response.getMessage().getDisplayMessage()));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private boolean isSuccess(String status) {
        return Const.SUCCESS_STATUS.equals(status);
    }

}

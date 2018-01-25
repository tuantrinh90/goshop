package com.goshop.app.domian;

import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.Weather;
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

    @Override
    public Observable<UserInfo> getUserInfo(String username, String password) {
        return accountCloudDataSource.getUserInfo(username, password);
    }

    public Observable<UserInfo> registerRequest(Map<String, Object> params) {
        return accountCloudDataSource.registerRequest(params);
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
    public Observable<SearchFilterResponse> searchFilterRequest(Map<String, Object> params) {
        return accountCloudDataSource.searchFilterRequest(params);
    }

    @Override
    public Observable<SearchResultResponse> searchResultResponse(Map<String, Object> params) {
        return accountCloudDataSource.searchResultResponse(params);
    }

    @Override
    public Observable<UserInfo> getUserInfo(String id) {
        return accountCloudDataSource.getUserInfo(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
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
}

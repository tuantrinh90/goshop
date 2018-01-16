package com.goshop.app.data.retrofit;

import com.goshop.app.data.EndpointAddress;
import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.GetWeatherResponse;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Ray on 2018/1/5.
 */

public class RetrofitRestApiImpl implements RestApi {

    private RetrofitRestApi retrofitRestApi;

    @Inject
    public RetrofitRestApiImpl(Retrofit retrofit) {
        this.retrofitRestApi = retrofit.create(RetrofitRestApi.class);
    }

    @Override
    public Observable<GetWeatherResponse> getWeather(String id) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.USER_INFO);
        return retrofitRestApi.getWeather(url);
    }

    @Override
    public Observable<UserInfo> registerRequest(Map<String, Object> params) {
        String url = EndpointAddress.getFullUrl(EndpointAddress.REGISTER);
        return retrofitRestApi.registerRequest(url, params);
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
}
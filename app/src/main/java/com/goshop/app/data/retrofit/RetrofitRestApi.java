package com.goshop.app.data.retrofit;

import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.request.GetUserRequest;
import com.goshop.app.data.model.request.SaveUserRequest;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.model.response.HomeResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Ray on 2018/1/5.
 */

public interface RetrofitRestApi {

    String CONTENT_TYPE_JSON = "Content-Type: application/vnd.api+json";

    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<GetWeatherResponse> getWeather(@Url String url);

    //TODO  this is an example
    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<UserInfo> getUserInfo(@Url String url, @Query("userId") String id);

    //TODO  this is an example
    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<Boolean> getUserInfo(@Url String url,
        @QueryMap(encoded = true) Map<String, Object> query);

    //TODO  this is an example
    @Headers({CONTENT_TYPE_JSON})
    @GET
    Observable<UserInfo> getUserInfo(@Url String url,
        @Body GetUserRequest getUserRequest);

    //TODO  this is an example
    @Headers(CONTENT_TYPE_JSON)
    @POST
    Observable<UserInfo> saveUserInfo(@Url String url, @Body SaveUserRequest saveUserRequest);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<HomeResponse> homeRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    //TODO  this is an example
    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<Error> loginCreatePinRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<UserInfo> registerRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ComplementEmailReponse> complementEmailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ResetPasswordReponse> resetPasswordRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<ProductDetailResponse> productDetailRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SearchFilterResponse> searchFilterRequest(@Url String fullUrl,
        @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @Headers({CONTENT_TYPE_JSON})
    @POST
    Observable<SearchResultResponse> searchResultResponse(@Url String fullUrl,
        @FieldMap Map<String, Object> params);
}

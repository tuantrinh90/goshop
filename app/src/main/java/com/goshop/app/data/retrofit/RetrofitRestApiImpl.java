package com.goshop.app.data.retrofit;

import com.goshop.app.data.EndpointAddress;
import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.request.GetUserRequest;
import com.goshop.app.data.model.response.GetUserResponse;
import com.goshop.app.data.model.response.GetWeatherResponse;

import java.util.HashMap;

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
        String url= EndpointAddress.getFullUrl(EndpointAddress.USER_INFO);
        return retrofitRestApi.getWeather(url);
    }

    @Override
    public Observable<UserInfo> getUser(String username,String password) {
        String url= EndpointAddress.getFullUrl(EndpointAddress.USER_INFO);
        GetUserRequest getUserRequest=new GetUserRequest();
        getUserRequest.setUserName(username);
        getUserRequest.setPassword(password);
        return retrofitRestApi.getUserInfo(url,getUserRequest);
    }
}

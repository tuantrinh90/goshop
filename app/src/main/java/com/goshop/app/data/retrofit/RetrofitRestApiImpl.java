package com.goshop.app.data.retrofit;

import com.goshop.app.data.RestApi;
import com.goshop.app.data.model.UserInfo;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Ray on 2018/1/5.
 */

public class RetrofitRestApiImpl implements RestApi {

    private RetrofitRestApi retrofitRestApi;

    public RetrofitRestApiImpl(Retrofit retrofit) {
        this.retrofitRestApi = retrofit.create(RetrofitRestApi.class);
    }

    @Override
    public Observable<UserInfo> getUserInfo(String id) {
        return null;
    }
}

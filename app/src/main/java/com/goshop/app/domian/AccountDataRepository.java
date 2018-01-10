package com.goshop.app.domian;

import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.Weather;
import com.goshop.app.data.model.response.GetWeatherResponse;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.data.source.AccountDataSource;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ray on 2018/1/5.
 */

public class AccountDataRepository implements AccountRepository {

    private AccountDataSource accountCloudDataSource;

    private AccountDataSource accountLocalDataSource;

    @Inject
    public AccountDataRepository(@Named("cloudAccountDataSource") AccountDataSource accountCloudDataSource,@Named("localAccountDataSource") AccountDataSource accountLocalDataSource) {
        this.accountCloudDataSource = accountCloudDataSource;
        this.accountLocalDataSource = accountLocalDataSource;
    }


    @Override
    public Observable<Weather> getWeather() {
        return accountCloudDataSource.getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(getWeatherResponse -> {
                    if(getWeatherResponse!=null&&getWeatherResponse.getWeatherinfo().getCity()!=null){
                        return Observable.just(getWeatherResponse.getWeatherinfo());
                    }else {
                        return Observable.error(new ServiceApiFail("error"));
                    }
                });
    }

    @Override
    public Observable<UserInfo> getUserInfo(String username,String password) {
        return accountCloudDataSource.getUserInfo(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

package com.goshop.app.domian;

import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.Weather;
import com.goshop.app.data.model.response.GetWeatherResponse;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface AccountRepository {

    Observable<UserInfo> getUserInfo(String username,String password);

    Observable<Weather> getWeather();

}

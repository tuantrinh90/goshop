package com.goshop.app.data;

import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.GetUserResponse;
import com.goshop.app.data.model.response.GetWeatherResponse;

import java.util.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface RestApi {

    io.reactivex.Observable<GetWeatherResponse> getWeather(String id);

    io.reactivex.Observable<UserInfo> getUser(String username,String password);

}

package com.goshop.app.data.source;

import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.Weather;
import com.goshop.app.data.model.response.GetWeatherResponse;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface AccountDataSource {

    Observable<UserInfo> getUserInfo(String id);

    Observable<GetWeatherResponse> getWeather();

    Observable<UserInfo> registerRequest(Map<String, Object> params);

    Observable<ComplementEmailReponse> complementEmailRequest(Map<String, Object> params);

    Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params);

    Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(Map<String, Object> params);
}

package com.goshop.app.data;

import com.goshop.app.data.model.ComplementEmailReponse;
import com.goshop.app.data.model.ResetPasswordReponse;
import com.goshop.app.data.model.SendConfirmationLinkReponse;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.model.response.GetWeatherResponse;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface RestApi {

    io.reactivex.Observable<GetWeatherResponse> getWeather(String id);

    io.reactivex.Observable<UserInfo> registerRequest(Map<String, Object> params);

    io.reactivex.Observable<ComplementEmailReponse> complementEmailRequest(
        Map<String, Object> params);

    Observable<ResetPasswordReponse> resetPasswordRequest(Map<String, Object> params);

    Observable<SendConfirmationLinkReponse> sendConfirmationLinkRequest(Map<String, Object> params);
}

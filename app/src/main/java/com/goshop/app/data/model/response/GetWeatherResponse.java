package com.goshop.app.data.model.response;

import com.goshop.app.data.model.Weather;

/**
 * Created by Administrator on 2018/1/7.
 */

public class GetWeatherResponse {
    private Weather weatherinfo;

    public Weather getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(Weather weatherinfo) {
        this.weatherinfo = weatherinfo;
    }
}

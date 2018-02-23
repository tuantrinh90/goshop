package com.goshop.app.data.model.response;

import com.goshop.app.data.model.Weather;

public class GetWeatherResponse {

    private Weather weatherinfo;

    public Weather getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(Weather weatherinfo) {
        this.weatherinfo = weatherinfo;
    }
}

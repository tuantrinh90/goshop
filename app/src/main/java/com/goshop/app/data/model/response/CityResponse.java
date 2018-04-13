package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.CityData;

import java.util.List;

public class CityResponse {

    private List<CityData> city;

    public List<CityData> getCity() {
        return city;
    }

    public void setCity(List<CityData> city) {
        this.city = city;
    }

}

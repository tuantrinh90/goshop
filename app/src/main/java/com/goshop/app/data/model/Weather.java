package com.goshop.app.data.model;

import com.google.gson.annotations.SerializedName;

public class Weather {
//    {
//        "weatherinfo": {
//        "city": "太仓",
//                "cityid": "101190408",
//                "temp1": "2℃",
//                "temp2": "16℃",
//                "weather": "晴转多云",
//                "img1": "n0.gif",
//                "img2": "d1.gif",
//                "ptime": "18:00"
//    }
//    }

    private String city;

    @SerializedName("cityid")
    private String cityId;

    private String temp1;

    private String temp2;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }
}

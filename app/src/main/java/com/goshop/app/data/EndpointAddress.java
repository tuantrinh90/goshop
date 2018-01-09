package com.goshop.app.data;

import com.goshop.app.BuildConfig;

/**
 * Created by winniseptiani on 3/22/17.
 */

@SuppressWarnings("ALL")
public class EndpointAddress {
    //todo test api
    public static final String USER_INFO = "data/cityinfo/101190408.html";

    public static String getFullUrl(String endpointUrl) {
        return BuildConfig.SERVICE_API_URL + endpointUrl;
    }
}

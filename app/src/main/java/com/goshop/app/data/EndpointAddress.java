package com.goshop.app.data;

import com.goshop.app.BuildConfig;

/**
 * Created by winniseptiani on 3/22/17.
 */

@SuppressWarnings("ALL")
public class EndpointAddress {
    //todo test api
    public static final String USER_INFO = "data/cityinfo/101190408.html";
    //todo wait for api
    public static final String REGISTER = "";
    //todo wait for api
    public static final String COMPLEMENT_EMAIL = "";
    //todo wait for api
    public static final String RESET_PASSWORD = "";
    //todo wait for api
    public static final String SEND_CONFIRMATION_LINK = "";
    //todo wait for api
    public static final String PRODUCT_DETAIL = "";
    //todo wait for api
    public static final String SEARCH_FILGER = "";
    //todo wait for api
    public static final String SEARCH_RESULT = "";
    //todo wait for api
    public static final String PROMOTION_LIST = "";
    public static final String PROMOTION_BANNER = "";

    public static String getFullUrl(String endpointUrl) {
        return BuildConfig.SERVICE_API_URL + endpointUrl;
    }
}

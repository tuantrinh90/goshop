package com.goshop.app.data;

import com.goshop.app.BuildConfig;

/**
 * Created by winniseptiani on 3/22/17.
 */

@SuppressWarnings("ALL")
public class EndpointAddress {

    public static final String ADD_ADDRESS = "";

    //todo wait for api
    public static final String CHANGE_PASSWORD = "";

    //todo wait for api
    public static final String COMPLEMENT_EMAIL = "";

    //todo wait for api
    public static final String EDIT_PROFILE = "";

    //todo wait for api
    public static final String HOME_REQUEST = "";

    public static final String MY_ADDRESS = "";

    //todo wait for api
    public static final String PRODUCT_DETAIL = "";

    public static final String PROMOTION_BANNER = "";

    //todo wait for api
    public static final String PROMOTION_LIST = "";

    //todo wait for api
    public static final String REGISTER = "";

    //todo wait for api
    public static final String RESET_PASSWORD = "";

    //todo wait for api
    public static final String SEARCH_FILGER = "";

    //todo wait for api
    public static final String SEARCH_RESULT = "";

    //todo wait for api
    public static final String SEND_CONFIRMATION_LINK = "";

    //todo test api
    public static final String USER_INFO = "data/cityinfo/101190408.html";

    public static String getFullUrl(String endpointUrl) {
        return BuildConfig.SERVICE_API_URL + endpointUrl;
    }
}

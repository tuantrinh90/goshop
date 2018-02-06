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

    //todo wait for api
    public static final String CHECKOUT_REQUEST = "";

    //todo wait for api
    public static final String MYORDER_LIST_REQUEST = "";

    //todo wait for api
    public static final String MYORDER_DETAIL_REQUEST = "";

    //todo wait for api
    public static final String NOTIFICATION_REQUEST = "";

    //todo wait for api
    public static final String MY_ADDRESS = "";

    //todo wait for api
    public static final String PRODUCT_DETAIL = "";

    //todo wait for api
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

    public static final String SHOPPINT_CART = "";

    //todo test api
    public static final String USER_INFO = "data/cityinfo/101190408.html";

    public static final String GET_ECMC = "";

    public static final String GET_CONTACT_US = "";

    public static final String HELP_SUPPORT = "";

    public static final String FAQ = "";

    public static final String TERMS_CONDITIONS = "";

    public static final String GET_CONTACT_INFO = "";

    public static final String CONTACT_MESSAGE = "";

    public static String getFullUrl(String endpointUrl) {
        return BuildConfig.SERVICE_API_URL + endpointUrl;
    }
}

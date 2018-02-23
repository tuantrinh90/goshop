package com.goshop.app.data;

import com.goshop.app.BuildConfig;

@SuppressWarnings("ALL")
public class EndpointAddress {

    public static final String HOME_PAGE = "";

    public static final String PDP_DETAILS = "";

    public static final String ADD_ADDRESS = "";

    //todo wait for api
    public static final String CHANGE_PASSWORD = "";

    //todo wait for api
    public static final String CHECKOUT_REQUEST = "";

    //todo wait for api
    public static final String COMPLEMENT_EMAIL = "";

    public static final String CONTACT_MESSAGE = "";

    //todo wait for api
    public static final String EDIT_PROFILE = "";

    public static final String FAQ = "";

    public static final String GET_CONTACT_INFO = "";

    public static final String GET_CONTACT_US = "";

    public static final String GET_ECMC = "";

    public static final String HELP_SUPPORT = "";

    //todo wait for api
    public static final String HOME_REQUEST = "";

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

    public static final String SETTING_DETAILS = "";

    public static final String SHOPPINT_CART = "";

    public static final String TERMS_CONDITIONS = "";

    public static final String MY_POINTS = "";

    //todo test api
    public static final String USER_INFO = "data/cityinfo/101190408.html";

    public static final String PAYMENT_STATUS = "";

    public static final String SELECT_ADDRESS = "";

    public static final String CATEGORY_LEFT = "";

    public static final String CATEGORY_RIGHT = "";

    public static final String CATEGORY_DETAIL = "";

    public static final String TV_SHOWS = "";

    public static String getFullUrl(String endpointUrl) {
        return BuildConfig.SERVICE_API_URL + endpointUrl;
    }
}

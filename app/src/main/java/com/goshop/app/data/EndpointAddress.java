package com.goshop.app.data;

import com.goshop.app.BuildConfig;

@SuppressWarnings("ALL")
public class EndpointAddress {

    public static final String ADD_ADDRESS = "";

    public static final String ALL_DEALS = "";

    public static final String ALL_REVIEWS = "";

    public static final String BRANDS_DETAIL = "";

    public static final String BRANDS_PAGE = "";

    public static final String CATEGORY_DETAIL = "";

    public static final String CATEGORY_LEFT = "";

    public static final String CATEGORY_RIGHT = "";

    //todo wait for api
    public static final String CHANGE_PASSWORD = "";

    //todo wait for api
    public static final String CHECKOUT_REQUEST = "";

    //todo wait for api
    public static final String COMPLEMENT_EMAIL = "";

    public static final String CONTACT_MESSAGE = "";

    //todo wait for api
    public static final String EDIT_PROFILE = "";

    public static final String EXPIRED = "";

    public static final String FAQ = "";

    public static final String GET_CONTACT_INFO = "";

    public static final String GET_CONTACT_US = "";

    public static final String GET_ECMC = "";

    public static final String GO_LOYALTY = "";

    public static final String HELP_SUPPORT = "";

    public static final String HOME_PAGE = "";

    //todo wait for api
    public static final String HOME_REQUEST = "";

    //todo wait for api
    public static final String MYORDER_DETAIL_REQUEST = "";

    //todo wait for api
    public static final String MYORDER_LIST_REQUEST = "";

    //todo wait for api
    public static final String MY_ADDRESS = "";

    public static final String MY_EGIFT_CARDS = "";

    public static final String MY_POINTS = "";

    //todo wait for api
    public static final String NOTIFICATION_REQUEST = "";

    public static final String PAYMENT_STATUS = "";

    public static final String PDP_DETAILS = "";

    public static final String PENDING = "";

    //todo wait for api
    public static final String PRODUCT_DETAIL = "";

    //todo wait for api
    public static final String PROMOTION_BANNER = "";

    //todo wait for api
    public static final String PROMOTION_LIST = "";

    public static final String REDEEMED = "";

    public static final String CARD_REDEEM = "";

    public static final String SWIPE_REDEEM = "";

    //todo wait for api
    public static final String REGISTER = "";

    //todo wait for api
    public static final String RESET_PASSWORD = "";

    public static final String REWARDS_DETAIL = "";

    public static final String MY_WISHLIST = "";

    //todo wait for api
    public static final String SEARCH_FILGER = "";

    //todo wait for api
    public static final String SEARCH_RESULT = "";

    public static final String SELECT_ADDRESS = "";

    //todo wait for api
    public static final String SEND_CONFIRMATION_LINK = "";

    public static final String SETTING_DETAILS = "";

    public static final String SHOPPINT_CART = "";

    public static final String TERMS_CONDITIONS = "";

    public static final String TV_SHOWS = "";

    //todo test api
    public static final String USER_INFO = "data/cityinfo/101190408.html";

    public static String getFullUrl(String endpointUrl) {
        return BuildConfig.SERVICE_API_URL + endpointUrl;
    }
}

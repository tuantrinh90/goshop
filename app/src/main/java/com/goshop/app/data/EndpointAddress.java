package com.goshop.app.data;

import com.goshop.app.BuildConfig;

@SuppressWarnings("ALL")
public class EndpointAddress {

    public static final String LOGIN = "rest/all/V1/rest-api/customer/login";

    public static final String LOGIN_WITH_FB = "rest/all/V1/rest-api/customer/login-with-fb";

    public static final String RESET_PASSWORD = "rest/all/V1/rest-api/customer/reset-password";

    public static final String CHANGE_PASSWORD = "rest/all/V1/rest-api/customer/change-password";

    public static final String REGISTER_USER = "rest/all/V1/rest-api/customer/register";

    public static final String GET_USER_PROFILE = "rest/all/V1/rest-api/customer/me";

    public static final String EDIT_USER_PROFILE = "rest/all/V1/rest-api/customer/customer_id";

    public static final String LIST_CUSTOMER_ADDRESSES =
        "rest/all/V1/rest-api/customer/customer_id/address";

    public static final String ADD_CUSTOMER_ADDRESS =
        "rest/all/V1/rest-api/customer/customer_id/address";

    public static final String EDIT_CUSTOMER_ADDRESS =
        "rest/all/V1/rest-api/customer/customer_id/address";

    public static final String GET_GOSHOP_POINTS_DETAIL =
        "rest/all/V1/rest-api/customer/customer_id/goshop-points?website_idstore_id";

    public static final String EGIFTCARD_DETAILS =
        "rest/all/V1/rest-api/customer/customer_id/egiftcard?website_idstore_id";

    public static final String ACTIVATE_EGIFTCARD = "rest/all/V1/rest-api/customer/id/egiftcard";

    public static final String GET_WISHLIST_ITEMS =
        "rest/all/V1/rest-api/customer/customer_id/wishlist?website_idstore_id";

    public static final String ADD_WISHLIST = "rest/all/V1/rest-api/customer/id/wishlist";

    public static final String REMOVE_WISHLIST = "rest/all/V1/rest-api/customer/id/wishlist";

    public static final String GET_PROFILE_METADATA =
        "rest/all/V1/rest-api/customer/metadata?website_idstore_id";

    public static final String GET_STATES = "rest/all/V1/rest-api/address/getstates";

    public static final String GET_CITY = "rest/all/V1/rest-api/address/getcity";

    public static final String GET_ZIPCODE = "rest/all/V1/rest-api/address/getzipcode";

    public static final String GET_PRODUCT_RATING_REVIEWS =
        "rest/all/V1/rest-api/catalog/product/sku/reviews";

    public static final String ADD_PRODUCT_REVIEW =
        "rest/all/V1/rest-api/catalog/product/sku/review";

    public static final String LIST_PRODUCT_QUESTION_ANSWER =
        "rest/all/V1/rest-api/catalog/product/sku_id/question-answer";

    public static final String SUBMIT_QUESTIONS =
        "rest/all/V1/rest-api/catalog/product/sku/ask-questions";

    public static final String DELIVERY_CHECK =
        "rest/all/V1/rest-api/catalog/product/sku/delivery-check";

    public static final String GET_PRODUCT_DETAILS = "rest/all/V1/rest-api/catalog/product/sku_id";

    public static final String CANCEL_ORDER = "rest/all/V1/rest-api//order/order_id/cancel";

    public static final String RETURN_ORDER = "rest/all/V1/rest-api/order/order_id/return";

    public static final String SETTING_LOGOUT = "rest/all/V1/rest-api/customer/logout";

    public static final String ADD_ADDRESS = "";

    public static final String EDIT_ADDRESS = "";

    public static final String ALL_DEALS = "";

    public static final String BRANDS_DETAIL = "";

    public static final String BRANDS_PAGE = "";

    public static final String CATEGORY_DETAIL = "";

    public static final String CATEGORY_LEFT = "";

    public static final String CATEGORY_RIGHT = "";

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

    public static final String QUESTION_ANSWER = "";

    public static final String PROMOTION_SKU = "";

    public static final String DEFAULT_SHIPPING_ADDRESS = "";

    public static final String DEFAULT_BILLING_ADDRESS = "";

    //todo test api
    public static final String USER_INFO = "data/cityinfo/101190408.html";

    public static String getFullUrl(String endpointUrl) {
        return BuildConfig.SERVICE_API_URL + endpointUrl;
    }
}

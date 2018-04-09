package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("available_goshop_points")
    private String availableGoshopPoints;

    @SerializedName("cart_items_count")
    private int cartItemsCount;

    private String dob;

    private String email;

    @SerializedName("email_subscribe")
    private boolean emailSubscribe;

    private int id;

    private LanguageData language;

    @SerializedName("max_failed_login")
    private int maxFailedLogin;

    @SerializedName("mobile_number")
    private String mobileNumber;

    private String name;

    private RaceData race;

    @SerializedName("sms_subscribe")
    private boolean smsSubscribe;

    private String title;

    private TokenData token;

    @SerializedName("wishlist_tems_count")
    private int wishlistTemsCount;

    public int getWishlistTemsCount() {
        return wishlistTemsCount;
    }

    public void setWishlistTemsCount(int wishlistTemsCount) {
        this.wishlistTemsCount = wishlistTemsCount;
    }

    public int getCartItemsCount() {
        return cartItemsCount;
    }

    public void setCartItemsCount(int cartItemsCount) {
        this.cartItemsCount = cartItemsCount;
    }

    public String getAvailableGoshopPoints() {
        return availableGoshopPoints;
    }

    public void setAvailableGoshopPoints(String availableGoshopPoints) {
        this.availableGoshopPoints = availableGoshopPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LanguageData getLanguage() {
        return language;
    }

    public void setLanguage(LanguageData language) {
        this.language = language;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public RaceData getRace() {
        return race;
    }

    public void setRace(RaceData race) {
        this.race = race;
    }

    public int getMaxFailedLogin() {
        return maxFailedLogin;
    }

    public void setMaxFailedLogin(int maxFailedLogin) {
        this.maxFailedLogin = maxFailedLogin;
    }

    public boolean isEmailSubscribe() {
        return emailSubscribe;
    }

    public void setEmailSubscribe(boolean emailSubscribe) {
        this.emailSubscribe = emailSubscribe;
    }

    public boolean isSmsSubscribe() {
        return smsSubscribe;
    }

    public void setSmsSubscribe(boolean smsSubscribe) {
        this.smsSubscribe = smsSubscribe;
    }

    public TokenData getToken() {
        return token;
    }

    public void setToken(TokenData token) {
        this.token = token;
    }


}

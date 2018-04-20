package com.goshop.app.data.realm.model;

import com.goshop.app.data.model.response.common.UserData;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserInfoRealm extends RealmObject {

    @PrimaryKey
    String realmId;

    int id;

    String title;

    String name;

    String email;

    String mobileNumber;

    int languageId;

    String languageName;

    String dob;

    int raceId;

    String raceName;

    int maxFailedLogin;

    boolean emailSubscribe;

    boolean smsSubscribe;

    String token;

    String tokenExpiration;

    int cartItemsCount;

    int wishListItemsCount;

    public UserInfoRealm() {
    }

    public UserInfoRealm(UserData userData) {
        this.realmId="1";
        this.id = userData.getId();
        this.title = userData.getTitle();
        this.name = userData.getName();
        this.email = userData.getEmail();
        this.mobileNumber = userData.getMobileNumber();
        if (userData.getLanguage() != null) {
            this.languageId = userData.getLanguage().getId();
            this.languageName = userData.getLanguage().getName();
        }
        this.dob = userData.getDob();
        if (userData.getRace() != null) {
            this.raceId = userData.getRace().getId();
            this.raceName = userData.getRace().getName();
        }
        this.maxFailedLogin = userData.getMaxFailedLogin();
        this.emailSubscribe = userData.isEmailSubscribe();
        this.smsSubscribe = userData.isSmsSubscribe();
        if (userData.getToken() != null) {
            this.token = userData.getToken().getToken();
            this.tokenExpiration = userData.getToken().getExpiration();
        }
        this.wishListItemsCount = userData.getWishlistTemsCount();
        this.cartItemsCount = userData.getCartItemsCount();
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

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(String tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public int getCartItemsCount() {
        return cartItemsCount;
    }

    public void setCartItemsCount(int cartItemsCount) {
        this.cartItemsCount = cartItemsCount;
    }

    public int getWishListItemsCount() {
        return wishListItemsCount;
    }

    public void setWishListItemsCount(int wishListItemsCount) {
        this.wishListItemsCount = wishListItemsCount;
    }
}

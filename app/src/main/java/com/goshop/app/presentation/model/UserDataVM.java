package com.goshop.app.presentation.model;

import com.goshop.app.data.realm.model.UserInfoRealm;

public class UserDataVM {

    private String availableGoshopPoints;

    private int cartItemsCount;

    private String dob;

    private String email;

    private boolean emailSubscribe;

    private int id;

    private LanguageVM language;

    private int maxFailedLogin;

    private String mobileNumber;

    private String name;

    private RaceVM race;

    private boolean smsSubscribe;

    private String title;

    private TokenVM token;

    private int wishlistTemsCount;

    public UserDataVM() {
    }

    public UserDataVM(UserInfoRealm userInfoRealm) {
        this.id = userInfoRealm.getId();
        this.title = userInfoRealm.getTitle();
        this.name = userInfoRealm.getName();
        this.email = userInfoRealm.getEmail();
        this.mobileNumber = userInfoRealm.getMobileNumber();
        LanguageVM languageData = new LanguageVM();
        languageData.setId(userInfoRealm.getLanguageId());
        languageData.setName(userInfoRealm.getLanguageName());
        this.language = languageData;
        this.dob = userInfoRealm.getDob();
        RaceVM raceData = new RaceVM();
        raceData.setId(userInfoRealm.getRaceId());
        raceData.setName(userInfoRealm.getRaceName());
        this.race = raceData;
        this.maxFailedLogin = userInfoRealm.getMaxFailedLogin();
        this.emailSubscribe = userInfoRealm.isEmailSubscribe();
        this.smsSubscribe = userInfoRealm.isSmsSubscribe();
        TokenVM tokenData = new TokenVM();
        tokenData.setToken(userInfoRealm.getToken());
        tokenData.setExpiration(userInfoRealm.getTokenExpiration());
        this.token = tokenData;
        this.wishlistTemsCount = userInfoRealm.getWishListItemsCount();
        this.cartItemsCount = userInfoRealm.getCartItemsCount();
        this.availableGoshopPoints = userInfoRealm.getAvailableGoshopPoints();
    }

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

    public LanguageVM getLanguage() {
        return language;
    }

    public void setLanguage(LanguageVM language) {
        this.language = language;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public RaceVM getRace() {
        return race;
    }

    public void setRace(RaceVM race) {
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

    public TokenVM getToken() {
        return token;
    }

    public void setToken(TokenVM token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserDataVM{" +
            "availableGoshopPoints='" + availableGoshopPoints + '\'' +
            ", cartItemsCount=" + cartItemsCount +
            ", dob='" + dob + '\'' +
            ", email='" + email + '\'' +
            ", emailSubscribe=" + emailSubscribe +
            ", id=" + id +
            ", language=" + language +
            ", maxFailedLogin=" + maxFailedLogin +
            ", mobileNumber='" + mobileNumber + '\'' +
            ", name='" + name + '\'' +
            ", race=" + race +
            ", smsSubscribe=" + smsSubscribe +
            ", title='" + title + '\'' +
            ", token=" + token +
            ", wishlistTemsCount=" + wishlistTemsCount +
            '}';
    }
}

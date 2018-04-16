package com.goshop.app.data;

import com.goshop.app.data.model.response.common.UserData;

import io.reactivex.Observable;

public interface LocalApi {

    Observable<Object> saveUserInfo(UserData customer);

    Observable<UserData> getUserInfo();

    Observable<Boolean> clearUserInfo();
}

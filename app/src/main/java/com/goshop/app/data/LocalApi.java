package com.goshop.app.data;

import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.presentation.model.FlagsVM;

import io.reactivex.Observable;

public interface LocalApi {

    Observable<Object> saveUserInfo(UserData customer);

    Observable<UserData> getUserInfo();

    Observable<Boolean> clearUserInfo();

    Observable<FlagsVM> getFlags();

    Observable<Object> saveFlags(FlagsVM flagsVM);
}

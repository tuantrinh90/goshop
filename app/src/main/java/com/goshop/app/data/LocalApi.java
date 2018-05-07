package com.goshop.app.data;

import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.presentation.model.FlagsVM;
import com.goshop.app.presentation.model.UserDataVM;

import io.reactivex.Observable;

public interface LocalApi {

    Observable<Object> saveUserInfo(UserDataVM customer);

    Observable<UserDataVM> getUserInfo();

    Observable<Boolean> clearUserInfo();

    Observable<FlagsVM> getFlags();

    Observable<Object> saveFlags(FlagsVM flagsVM);
}

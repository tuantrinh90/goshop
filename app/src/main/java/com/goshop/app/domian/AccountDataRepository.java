package com.goshop.app.domian;

import com.goshop.app.data.model.UserInfo;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public class AccountDataRepository implements AccountRepository {

    @Override
    public Observable<UserInfo> getUserInfo(String id) {
        return null;
    }
}

package com.goshop.app.data.source.cloud;

import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.source.AccountDataSource;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public class AccountCloudDataSource implements AccountDataSource {

    @Override
    public Observable<UserInfo> getUserInfo(String id) {
        return null;
    }
}

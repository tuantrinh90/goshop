package com.goshop.app.data.source.local;

import com.goshop.app.data.LocalApi;
import com.goshop.app.data.model.UserInfo;
import com.goshop.app.data.source.AccountDataSource;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public class AccountLocalDataSource implements AccountDataSource {

    private LocalApi localApi;
    
    public AccountLocalDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<UserInfo> getUserInfo(String id) {
        return null;
    }
}

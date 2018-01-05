package com.goshop.app.data.source;

import com.goshop.app.data.model.UserInfo;

import io.reactivex.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface AccountDataSource {

    Observable<UserInfo> getUserInfo(String id);
}

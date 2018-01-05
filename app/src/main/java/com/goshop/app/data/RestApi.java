package com.goshop.app.data;

import com.goshop.app.data.model.UserInfo;

import java.util.Observable;

/**
 * Created by Ray on 2018/1/5.
 */

public interface RestApi {

    io.reactivex.Observable<UserInfo> getUserInfo(String id);

}

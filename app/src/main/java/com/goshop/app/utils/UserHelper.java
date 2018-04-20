package com.goshop.app.utils;

import com.goshop.app.GoShopApplication;
import com.goshop.app.data.model.response.common.UserData;

import android.text.TextUtils;

public class UserHelper {

    public static int getUserId() {
        if (GoShopApplication.getCacheUserInfo() != null) {
            return GoShopApplication.getCacheUserInfo().getId();
        }
        return 0;
    }

    public static boolean isLogin() {
        if (GoShopApplication.getCacheUserInfo() != null && GoShopApplication.getCacheUserInfo()
            .getToken() != null) {
            return !TextUtils
                .isEmpty(GoShopApplication.getCacheUserInfo().getToken().getToken());
        }
        return false;
    }

    public static boolean checkUserData(UserData userData) {
        return userData != null && userData.getToken() != null && !TextUtils
            .isEmpty(userData.getToken().getToken());
    }
}

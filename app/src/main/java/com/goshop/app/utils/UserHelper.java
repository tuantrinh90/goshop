package com.goshop.app.utils;

import com.goshop.app.GoShopApplication;

public class UserHelper {

    public static int getUserId() {
        if (GoShopApplication.getCacheUserInfo() != null) {
            return GoShopApplication.getCacheUserInfo().getId();
        }
        return 0;
    }
}

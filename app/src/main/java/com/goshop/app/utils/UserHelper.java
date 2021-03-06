package com.goshop.app.utils;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.presentation.model.UserDataVM;
import android.app.Activity;
import android.content.Intent;
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

    public static boolean isLogin(UserDataVM userData) {
        return userData != null && userData.getToken() != null && !TextUtils
            .isEmpty(userData.getToken().getToken());
    }

    public static void goToLogin(Activity activity, Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enter_bottom_top, R.anim.enter_top_bottom);
    }
}

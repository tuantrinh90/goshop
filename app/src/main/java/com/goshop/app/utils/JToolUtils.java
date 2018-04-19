package com.goshop.app.utils;

import com.google.gson.Gson;

import com.orhanobut.logger.Logger;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JToolUtils {

    private static final String TAG = "JToolUtils";

    //TODO joyson test use : print object
    public static void printObject(Object object) {
        Gson gson = new Gson();
        String result = gson.toJson(object);
        Logger.e("object json:" + result);
    }

    public static void generateHashKey(Context context) {
        try {
            PackageInfo info = context.getPackageManager()
                .getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String KeyHash = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                Logger.e(TAG + KeyHash);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

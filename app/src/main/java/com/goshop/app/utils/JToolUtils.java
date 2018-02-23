package com.goshop.app.utils;

import com.google.gson.Gson;

import com.orhanobut.logger.Logger;

public class JToolUtils {

    //TODO joyson test use : print object
    public static void printObject(Object object) {
        Gson gson = new Gson();
        String result = gson.toJson(object);
        Logger.e("object json:" + result);
    }
}

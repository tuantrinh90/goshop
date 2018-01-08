package com.goshop.app;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.request.target.ViewTarget;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by img on 2018/1/5.
 */

public class App extends Application {
    private static App mInstance;
    public static App getInstance() {
        if (mInstance==null){
            mInstance=new App();
        }
        return mInstance;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mInstance = this;
            Logger.addLogAdapter(new AndroidLogAdapter());
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}

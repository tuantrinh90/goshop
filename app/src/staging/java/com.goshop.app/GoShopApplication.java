package com.goshop.app;

import com.crashlytics.android.Crashlytics;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.realm.EncryptionKey;
import com.goshop.app.data.realm.SchemaMigration;
import com.squareup.leakcanary.LeakCanary;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import injection.components.ApplicationComponent;
import injection.components.DaggerApplicationComponent;
import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class GoShopApplication extends MultiDexApplication {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private static ApplicationComponent mApplicationComponent;

    private static boolean isLogin;

    private static UserData userInfo;

    public static Context getAppContext() {
        return GoShopApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initializeComponents();
        setFabric();
        setLeakCanary();
        initRealm();
    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    private void initializeComponents() {
        mApplicationComponent = DaggerApplicationComponent.Initializer.init(this);
    }

    private void setFabric() {
        Fabric.with(this, new Crashlytics());
    }

    private void setLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
            .encryptionKey(EncryptionKey.generateKey())
            .schemaVersion(SchemaMigration.SCHEMA_VERSION)
            .migration(new SchemaMigration())
            .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public static void setLogin(boolean login) {
        isLogin = login;
    }

    public static void cacheUserInfo(UserData userInfo) {
        GoShopApplication.userInfo = userInfo;
    }

    public static UserData getCacheUserInfo() {
        return userInfo;
    }
}
package com.goshop.app.data.realm;

import com.goshop.app.data.LocalApi;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.realm.model.UserInfoRealm;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmDataSource implements LocalApi {

    @Inject
    public RealmDataSource() {

    }

    @Override
    public Observable<Object> saveUserInfo(UserData customer) {
        if (customer != null) {
            UserInfoRealm userInfoRealm = new UserInfoRealm(customer);
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(realm1 -> {
                realm1.copyToRealmOrUpdate(userInfoRealm);
            });
            realm.close();
            return Observable.just(realm.isClosed());
        } else {
            return Observable.just(true);
        }
    }

    @Override
    public Observable<UserData> getUserInfo() {
        Realm realm = Realm.getDefaultInstance();
        UserInfoRealm userInfoRealm = realm.where(UserInfoRealm.class)
            .findFirst();
        if (userInfoRealm != null) {
            UserData userInfo = new UserData(userInfoRealm);
            realm.close();
            return Observable.just(userInfo);
        } else {
            return Observable.just(new UserData());
        }
    }

    @Override
    public Observable<Boolean> clearUserInfo() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<UserInfoRealm> results = realm.where(UserInfoRealm.class)
            .findAll();
        realm.executeTransaction(transactionRealm -> results.deleteAllFromRealm());
        realm.close();
        return Observable.just(realm.isClosed());
    }
}

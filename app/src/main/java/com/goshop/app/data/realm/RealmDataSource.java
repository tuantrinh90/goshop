package com.goshop.app.data.realm;

import com.goshop.app.data.LocalApi;
import com.goshop.app.data.model.response.common.UserData;
import com.goshop.app.data.realm.model.FlagsRealm;
import com.goshop.app.data.realm.model.UserInfoRealm;
import com.goshop.app.presentation.model.FlagsVM;
import com.goshop.app.presentation.model.UserDataVM;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmDataSource implements LocalApi {

    @Inject
    public RealmDataSource() {

    }

    @Override
    public Observable<Object> saveUserInfo(UserDataVM customer) {
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
    public Observable<UserDataVM> getUserInfo() {
        Realm realm = Realm.getDefaultInstance();
        UserInfoRealm userInfoRealm = realm.where(UserInfoRealm.class)
            .findFirst();
        if (userInfoRealm != null) {
            UserDataVM userInfo = new UserDataVM(userInfoRealm);
            realm.close();
            return Observable.just(userInfo);
        } else {
            return Observable.just(new UserDataVM());
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

    @Override
    public Observable<FlagsVM> getFlags() {
        Realm realm = Realm.getDefaultInstance();
        FlagsRealm flagsRealm = realm.where(FlagsRealm.class)
            .findFirst();
        if (flagsRealm != null) {
            FlagsVM userInfo = new FlagsVM(flagsRealm);
            realm.close();
            return Observable.just(userInfo);
        } else {
            return Observable.just(new FlagsVM());
        }
    }

    public Observable<Object> saveFlags(FlagsVM flagsVM) {
        if (flagsVM != null) {
            FlagsRealm flagsRealm1 = new FlagsRealm(flagsVM);
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(realm1 -> {
                realm1.copyToRealmOrUpdate(flagsRealm1);
            });
            realm.close();
            return Observable.just(realm.isClosed());
        } else {
            return Observable.just(false);
        }
    }
}

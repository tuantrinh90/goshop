package com.goshop.app.data.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

//TODO ray this is just a presentation class
public class UserRealm extends RealmObject {

    private String name;

    @PrimaryKey
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

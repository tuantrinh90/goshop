package com.goshop.app.data.realm.model;

import com.goshop.app.presentation.model.FlagsVM;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FlagsRealm extends RealmObject {

    @PrimaryKey
    private String id = "1";

    private boolean loadLocalDataFlag;

    public FlagsRealm() {
    }

    public FlagsRealm(FlagsVM flagsVM) {
        this.loadLocalDataFlag = flagsVM.isLoadLocalDataFlag();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLoadLocalDataFlag() {
        return loadLocalDataFlag;
    }

    public void setLoadLocalDataFlag(boolean loadLocalDataFlag) {
        this.loadLocalDataFlag = loadLocalDataFlag;
    }
}

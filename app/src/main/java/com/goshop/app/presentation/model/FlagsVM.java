package com.goshop.app.presentation.model;

import com.goshop.app.data.realm.model.FlagsRealm;

public class FlagsVM {

    private boolean loadLocalDataFlag;

    public FlagsVM() {
    }

    public FlagsVM(FlagsRealm flagsRealm) {
        this.loadLocalDataFlag = flagsRealm.isLoadLocalDataFlag();
    }

    public boolean isLoadLocalDataFlag() {
        return loadLocalDataFlag;
    }

    public void setLoadLocalDataFlag(boolean loadLocalDataFlag) {
        this.loadLocalDataFlag = loadLocalDataFlag;
    }
}

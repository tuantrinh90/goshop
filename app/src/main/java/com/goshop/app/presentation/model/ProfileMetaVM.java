package com.goshop.app.presentation.model;

import android.support.annotation.NonNull;

public class ProfileMetaVM implements Comparable<ProfileMetaVM>{

    private String key;

    private String value;

    private boolean isSelect = false;

    public ProfileMetaVM(String value) {
        this.value = value;
    }

    public ProfileMetaVM(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    @Override
    public int compareTo(@NonNull ProfileMetaVM o) {
        return this.getKey().compareTo(o.getKey());
    }
}

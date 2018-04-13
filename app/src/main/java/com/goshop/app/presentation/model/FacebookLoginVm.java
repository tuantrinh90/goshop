package com.goshop.app.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FacebookLoginVm implements Parcelable {

    private String id;

    private String name;

    private String gender;

    private String emali;

    private String token;

    public FacebookLoginVm() {
    }

    protected FacebookLoginVm(Parcel in) {
        id = in.readString();
        name = in.readString();
        gender = in.readString();
        emali = in.readString();
        token = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmali() {
        return emali;
    }

    public void setEmali(String emali) {
        this.emali = emali;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static final Creator<FacebookLoginVm> CREATOR = new Creator<FacebookLoginVm>() {
        @Override
        public FacebookLoginVm createFromParcel(Parcel in) {
            return new FacebookLoginVm(in);
        }

        @Override
        public FacebookLoginVm[] newArray(int size) {
            return new FacebookLoginVm[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(emali);
        dest.writeString(token);
    }
}

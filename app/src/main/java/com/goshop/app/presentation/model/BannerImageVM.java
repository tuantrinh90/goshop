package com.goshop.app.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BannerImageVM implements Parcelable {

    private String path;

    private String link;

    protected BannerImageVM(Parcel in) {
        path = in.readString();
        link = in.readString();
    }

    public BannerImageVM(String path, String link) {
        this.path = path;
        this.link = link;
    }

    public static final Creator<BannerImageVM> CREATOR = new Creator<BannerImageVM>() {
        @Override
        public BannerImageVM createFromParcel(Parcel in) {
            return new BannerImageVM(in);
        }

        @Override
        public BannerImageVM[] newArray(int size) {
            return new BannerImageVM[size];
        }
    };

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(path);
        dest.writeString(link);
    }
}

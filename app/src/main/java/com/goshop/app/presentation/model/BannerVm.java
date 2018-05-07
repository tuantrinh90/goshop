package com.goshop.app.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BannerVm implements Parcelable {

    private int id;

    private String type;

    private String link;

    private String image;

    protected BannerVm(Parcel in) {
        id = in.readInt();
        type = in.readString();
        link = in.readString();
        image = in.readString();
    }

    public BannerVm() {
    }

    public static final Creator<BannerVm> CREATOR = new Creator<BannerVm>() {
        @Override
        public BannerVm createFromParcel(Parcel in) {
            return new BannerVm(in);
        }

        @Override
        public BannerVm[] newArray(int size) {
            return new BannerVm[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(type);
        dest.writeString(link);
        dest.writeString(image);
    }
}

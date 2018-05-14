package com.goshop.app.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.List;

public class BannerVm implements Parcelable ,Comparable {

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

    private String id;

    private int position;

    private List<BannerImageVM> bannerImageVMS;

    protected BannerVm(Parcel in) {
        id = in.readString();
        position = in.readInt();
        bannerImageVMS = in.createTypedArrayList(BannerImageVM.CREATOR);
    }

    public BannerVm() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<BannerImageVM> getBannerImageVMS() {
        return bannerImageVMS;
    }

    public void setBannerImageVMS(
        List<BannerImageVM> bannerImageVMS) {
        this.bannerImageVMS = bannerImageVMS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(position);
        dest.writeTypedList(bannerImageVMS);
    }

    @Override
    public int compareTo(@NonNull Object o) {
        BannerVm bannerVm = (BannerVm) o;
        return Integer.valueOf(this.position).compareTo(bannerVm.getPosition());
    }
}

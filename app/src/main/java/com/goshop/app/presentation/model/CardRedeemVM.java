package com.goshop.app.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CardRedeemVM implements Parcelable {

    private String detail;

    private String end;

    private String thumb;

    private int thumbDefault;

    private String time;

    private String title;

    public CardRedeemVM(String thumb, int thumbDefault, String title, String detail,
        String time, String end) {
        this.thumb = thumb;
        this.thumbDefault = thumbDefault;
        this.title = title;
        this.detail = detail;
        this.time = time;
        this.end = end;

    }

    protected CardRedeemVM(Parcel in) {
        detail = in.readString();
        end = in.readString();
        thumb = in.readString();
        thumbDefault = in.readInt();
        time = in.readString();
        title = in.readString();
    }

    public static final Creator<CardRedeemVM> CREATOR = new Creator<CardRedeemVM>() {
        @Override
        public CardRedeemVM createFromParcel(Parcel in) {
            return new CardRedeemVM(in);
        }

        @Override
        public CardRedeemVM[] newArray(int size) {
            return new CardRedeemVM[size];
        }
    };

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getThumbDefault() {
        return thumbDefault;
    }

    public void setThumbDefault(int thumbDefault) {
        this.thumbDefault = thumbDefault;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(detail);
        dest.writeString(end);
        dest.writeString(thumb);
        dest.writeInt(thumbDefault);
        dest.writeString(time);
        dest.writeString(title);
    }
}

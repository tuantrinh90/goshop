package com.goshop.app.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AddressVM implements Parcelable {

    public static final Creator<AddressVM> CREATOR = new Creator<AddressVM>() {
        @Override
        public AddressVM createFromParcel(Parcel in) {
            return new AddressVM(in);
        }

        @Override
        public AddressVM[] newArray(int size) {
            return new AddressVM[size];
        }
    };

    private String address;

    private String city;

    private String code;

    private String country;

    private boolean isDefault;

    private String name;

    private String state;

    private String tel;

    public AddressVM(String name, String address, String city, String state, String code,
        String country, String tel, boolean isDefault) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
        this.tel = tel;
        this.isDefault = isDefault;
    }

    protected AddressVM(Parcel in) {
        address = in.readString();
        city = in.readString();
        code = in.readString();
        country = in.readString();
        isDefault = in.readByte() != 0;
        name = in.readString();
        state = in.readString();
        tel = in.readString();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(code);
        dest.writeString(country);
        dest.writeByte((byte) (isDefault ? 1 : 0));
        dest.writeString(name);
        dest.writeString(state);
        dest.writeString(tel);
    }
}

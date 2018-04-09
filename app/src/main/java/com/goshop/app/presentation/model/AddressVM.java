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

    private String addressSecond;

    private boolean billingDefault;

    private String city;

    private String code;

    private String country;

    private String id;

    private String name;

    private boolean shippingDefault;

    private String state;

    private String tel;

    public AddressVM() {
    }

    protected AddressVM(Parcel in) {
        id = in.readString();
        address = in.readString();
        addressSecond = in.readString();
        city = in.readString();
        code = in.readString();
        country = in.readString();
        shippingDefault = in.readByte() != 0;
        billingDefault = in.readByte() != 0;
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

    public String getAddressSecond() {
        return addressSecond;
    }

    public void setAddressSecond(String addressSecond) {
        this.addressSecond = addressSecond;
    }

    public boolean isBillingDefault() {
        return billingDefault;
    }

    public void setBillingDefault(boolean billingDefault) {
        this.billingDefault = billingDefault;
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

    public boolean isShippingDefault() {
        return shippingDefault;
    }

    public void setShippingDefault(boolean shippingDefault) {
        this.shippingDefault = shippingDefault;
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
        dest.writeString(id);
        dest.writeString(address);
        dest.writeString(addressSecond);
        dest.writeString(city);
        dest.writeString(code);
        dest.writeString(country);
        dest.writeByte((byte) (shippingDefault ? 1 : 0));
        dest.writeByte((byte) (billingDefault ? 1 : 0));
        dest.writeString(name);
        dest.writeString(state);
        dest.writeString(tel);
    }
}

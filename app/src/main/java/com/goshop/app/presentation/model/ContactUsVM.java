package com.goshop.app.presentation.model;

/**
 * Created by helen on 2018/1/30.
 */

public class ContactUsVM {

    private String email;

    private String phone;

    public ContactUsVM( String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

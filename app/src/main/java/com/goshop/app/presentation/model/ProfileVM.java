package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.SingleChooseVM;

import java.util.List;

public class ProfileVM {

    private String birth;

    private String email;

    private String firstName;

    private String gender;

    private List<SingleChooseVM> language;

    private String lastName;

    private String mobile;

    private List<SingleChooseVM> race;

    private List<SingleChooseVM> title;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public List<SingleChooseVM> getTitle() {
        return title;
    }

    public void setTitle(List<SingleChooseVM> title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<SingleChooseVM> getLanguage() {
        return language;
    }

    public void setLanguage(List<SingleChooseVM> language) {
        this.language = language;
    }

    public List<SingleChooseVM> getRace() {
        return race;
    }

    public void setRace(List<SingleChooseVM> race) {
        this.race = race;
    }
}

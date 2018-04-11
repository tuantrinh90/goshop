package com.goshop.app.presentation.model;

import java.util.List;

public class ProfileVM {

    private String birth;

    private String email;

    private String firstName;

    private String gender;

    private List<ProfileMetaVM> language;

    private String lastName;

    private String mobile;

    private List<ProfileMetaVM> race;

    private List<ProfileMetaVM> title;

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

    public List<ProfileMetaVM> getTitle() {
        return title;
    }

    public void setTitle(List<ProfileMetaVM> title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<ProfileMetaVM> getLanguage() {
        return language;
    }

    public void setLanguage(List<ProfileMetaVM> language) {
        this.language = language;
    }

    public List<ProfileMetaVM> getRace() {
        return race;
    }

    public void setRace(List<ProfileMetaVM> race) {
        this.race = race;
    }
}

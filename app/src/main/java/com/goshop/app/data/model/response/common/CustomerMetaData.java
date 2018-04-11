package com.goshop.app.data.model.response.common;

import java.util.HashMap;

public class CustomerMetaData {

    private HashMap<String, String> gender;

    private HashMap<String, String> language;

    private HashMap<String, String> race;

    public HashMap<String, String> getGender() {
        return gender;
    }

    public void setGender(HashMap<String, String> gender) {
        this.gender = gender;
    }

    public HashMap<String, String> getLanguage() {
        return language;
    }

    public void setLanguage(HashMap<String, String> language) {
        this.language = language;
    }

    public HashMap<String, String> getRace() {
        return race;
    }

    public void setRace(HashMap<String, String> race) {
        this.race = race;
    }
}

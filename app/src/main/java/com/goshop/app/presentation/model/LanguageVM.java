package com.goshop.app.presentation.model;

public class LanguageVM {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LanguageVM{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}

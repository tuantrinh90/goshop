package com.goshop.app.presentation.model;

public class TokenVM {

    private String expiration;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "TokenVM{" +
            "expiration='" + expiration + '\'' +
            ", token='" + token + '\'' +
            '}';
    }
}

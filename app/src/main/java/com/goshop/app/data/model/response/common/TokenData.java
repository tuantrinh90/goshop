package com.goshop.app.data.model.response.common;

public class TokenData {

    /**
     * token : 8s4ht6x8rlmq9k3cjigpqgvf3cfn1nd5
     * expiration : 3600
     */

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
}

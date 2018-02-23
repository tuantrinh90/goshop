package com.goshop.app.data.model;

import com.goshop.app.data.model.response.GetUserResponse;

public class UserInfo extends GetUserResponse {

    private boolean isSuccuss;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSuccuss() {
        return isSuccuss;
    }

    public void setSuccuss(boolean succuss) {
        isSuccuss = succuss;
    }
}

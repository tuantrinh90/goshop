package com.goshop.app.data.model.request;

/**
 * Created by Ray on 2018/1/5.
 */

public class GetUserRequest {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

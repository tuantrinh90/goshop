package com.goshop.app.data.model;

/**
 * Created by Ray on 2018/1/5.
 */

public class Reponse {

    private int state;

    private String errorMessage;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

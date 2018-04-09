package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

public class Message {

    /**
     * display_message :
     * status : success
     */
    @SerializedName("display_message")
    private String displayMessage;

    private String status;

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

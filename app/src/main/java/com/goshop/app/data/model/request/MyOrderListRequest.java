package com.goshop.app.data.model.request;

/**
 * Created by img on 2018/1/29.
 */

public class MyOrderListRequest {
    private String session_key;
    private String offset;
    private String max;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}

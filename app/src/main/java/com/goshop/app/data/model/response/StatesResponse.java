package com.goshop.app.data.model.response;

import com.goshop.app.data.model.response.common.StatesData;

import java.util.List;

public class StatesResponse {

    private List<StatesData> states;

    public List<StatesData> getStates() {
        return states;
    }

    public void setStates(List<StatesData> states) {
        this.states = states;
    }
}

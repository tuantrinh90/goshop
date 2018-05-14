package com.goshop.app.data.model.response.common;

import java.util.List;

public class ReturnData {

    private List<ResolutionData> resolution;

    private List<ConditionData> condition;

    private List<ReasonData> reason;

    public List<ResolutionData> getResolution() {
        return resolution;
    }

    public void setResolution(List<ResolutionData> resolution) {
        this.resolution = resolution;
    }

    public List<ConditionData> getCondition() {
        return condition;
    }

    public void setCondition(List<ConditionData> condition) {
        this.condition = condition;
    }

    public List<ReasonData> getReason() {
        return reason;
    }

    public void setReason(List<ReasonData> reason) {
        this.reason = reason;
    }
}

package com.goshop.app.data.model.response;

import com.google.gson.annotations.SerializedName;

public class DealLocationResponse {

    /**
     * location_id : 1
     * location_name : Kuala Lumpur
     */
    @SerializedName("location_id")
    private String locationId;

    @SerializedName("location_name")
    private String locationName;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}

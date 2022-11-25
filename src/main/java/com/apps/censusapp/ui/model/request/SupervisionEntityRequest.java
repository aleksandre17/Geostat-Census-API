package com.apps.censusapp.ui.model.request;

public class SupervisionEntityRequest {

    private Double latitude;

    private Double longitude;

    private String startTime;

    private String endTime;

    private String addressing_uuid;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddressing_uuid() {
        return addressing_uuid;
    }

    public void setAddressing_uuid(String addressing_uuid) {
        this.addressing_uuid = addressing_uuid;
    }
}

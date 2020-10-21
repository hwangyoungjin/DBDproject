package com.bus.VO;

public class ViaInfo {
    private String transitCode; // A,B,C,D....
    private String station;
    private float departureTime;
    private float arrivelTime;

    public String getTransitCode() {
        return transitCode;
    }

    public void setTransitCode(String transitCode) {
        this.transitCode = transitCode;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public float getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(float departureTime) {
        this.departureTime = departureTime;
    }

    public float getArrivelTime() {
        return arrivelTime;
    }

    public void setArrivelTime(float arrivelTime) {
        this.arrivelTime = arrivelTime;
    }
}

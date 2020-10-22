package com.bus.VO;

public class ScheduleInfo {
    private String routeName;
    private String day;
    private float departureTime;
    private float arrivelTime;
    private String transitCode; // A,B,C,D....

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public String getTransitCode() {
        return transitCode;
    }

    public void setTransitCode(String transitCode) {
        this.transitCode = transitCode;
    }

    @Override
    public String toString() {

        return "" + "<노선명 : " + routeName
                + ",  요일 : " + day
                + ", 출발시간 : " + departureTime
                +", 도착시간: " + arrivelTime +">";
    }
}

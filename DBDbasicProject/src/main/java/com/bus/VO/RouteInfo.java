package com.bus.VO;

public class RouteInfo { //노선
    private String routeName;
    private String departureStation;
    private String arrivelStation;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivelStation() {
        return arrivelStation;
    }

    public void setArrivelStation(String arrivelStation) {
        this.arrivelStation = arrivelStation;
    }
}

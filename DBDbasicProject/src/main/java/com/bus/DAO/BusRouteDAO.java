package com.bus.DAO;

import com.bus.VO.RouteInfo;

public interface BusRouteDAO {
    //노선 등록
    public void createRoute(RouteInfo routeInfo);
}

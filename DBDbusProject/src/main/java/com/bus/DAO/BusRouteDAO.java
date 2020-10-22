package com.bus.DAO;

import com.bus.VO.RouteInfo;

public interface BusRouteDAO {

    //노선 테이블 생성
    public void createTable();
    
    //노선 등록
    public void createRoute(RouteInfo routeInfo);
}

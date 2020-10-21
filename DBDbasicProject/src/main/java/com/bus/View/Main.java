package com.bus.View;

import com.bus.DAO.BusRouteDAO;
import com.bus.DAO.BusScheduleDAO;
import com.bus.DAO.Impl.BusRouteDAOImpl;
import com.bus.DAO.Impl.BusScheduleDAOImpl;
import com.bus.DAO.Impl.ViaBusDAOImpl;
import com.bus.DAO.ViaBusDAO;
import com.bus.VO.RouteInfo;
import com.bus.VO.ScheduleInfo;
import com.bus.VO.ViaInfo;

public class Main {
    public static void main(String[] args) {
        ruouteRecodeInsert(); // 노선 레코드10개 insert
        scheduleRecodeInsert(); // 운행스케줄 레코드 10개 insert
        viaRecodeInsert(); // 경유 레코드 10개 insert
    }

    public static void ruouteRecodeInsert(){
        /**노선 레코드 10개*/
        RouteInfo routeInfo = new RouteInfo();

        //1
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");

        BusRouteDAO busRouteDAO = new BusRouteDAOImpl();
        busRouteDAO.createRoute(routeInfo);

        //2
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //3
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //4
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //5
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //6
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //7
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //8
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //9
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);

        //10
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");
        busRouteDAO.createRoute(routeInfo);
    }

    public static void scheduleRecodeInsert(){
        /**운행스케줄 레코드 10개*/
        ScheduleInfo scheduleInfo = new ScheduleInfo();

        //1
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");

        BusScheduleDAO busScheduleDAO = new BusScheduleDAOImpl();
        busScheduleDAO.createSchecdule(scheduleInfo);

        //2
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //3
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //4
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //5
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //6
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //7
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //8
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //9
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //10
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 14.20); //14시 20분
        scheduleInfo.setTransitCode("A");
        busScheduleDAO.createSchecdule(scheduleInfo);
    }

    public static void viaRecodeInsert(){
        /**경유 레코드 10개*/
        ViaInfo viaInfo = new ViaInfo();

        //1
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        ViaBusDAO viaBusDAO = new ViaBusDAOImpl();
        viaBusDAO.createVia(viaInfo);


        //2
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //3
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //4
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //5
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //6
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //7
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //8
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //9
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);

        //10
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)12.15); //12시 15분
        viaInfo.setDepartureTime((float)12.25);//12시 25분

        viaBusDAO.createVia(viaInfo);
    }
}

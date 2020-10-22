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

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        ruouteRecodeInsert(); // 테이블 생성 후 노선 레코드10개 insert
        scheduleRecodeInsert(); // 테이블 생성 후 운행스케줄 레코드 10개 insert
        viaRecodeInsert(); // 테이블 생성 후 경유 레코드 10개 insert

        BusScheduleDAO busScheduleDAO = new BusScheduleDAOImpl();
        List<ScheduleInfo> scheduleInfoList = new ArrayList<>();

        //Test1
        scheduleInfoList = busScheduleDAO.searchSchedule("서울","대전",(float)9.10);
        System.out.println("list 출력"+scheduleInfoList);

        //Test2
        scheduleInfoList = busScheduleDAO.searchSchedule("용인","대전",(float)10.30);
        System.out.println("list 출력"+scheduleInfoList);

        //Test3
        scheduleInfoList = busScheduleDAO.searchSchedule("서울","부산",(float)12.10);
        System.out.println("list 출력"+scheduleInfoList);

        //Test4
        scheduleInfoList = busScheduleDAO.searchSchedule("천안","부산",(float)9.10);
        System.out.println("list 출력"+scheduleInfoList);

        //Test5
        scheduleInfoList = busScheduleDAO.searchSchedule("동대구","창원",(float)9.10);
        System.out.println("list 출력"+scheduleInfoList);


    }

    public static void ruouteRecodeInsert(){
        RouteInfo routeInfo = new RouteInfo();
        BusRouteDAO busRouteDAO = new BusRouteDAOImpl();

        /**노선 테이블 생성 */
        busRouteDAO.createTable();

        /**노선 레코드 10개*/

        //1
        routeInfo.setRouteName("경부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("부산");

        busRouteDAO.createRoute(routeInfo);

        //2
        routeInfo.setRouteName("경부선상행");
        routeInfo.setDepartureStation("부산");
        routeInfo.setArrivelStation("서울");
        busRouteDAO.createRoute(routeInfo);

        //3
        routeInfo.setRouteName("호남선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("목포");
        busRouteDAO.createRoute(routeInfo);

        //4
        routeInfo.setRouteName("호남선상행");
        routeInfo.setDepartureStation("목포");
        routeInfo.setArrivelStation("서울");
        busRouteDAO.createRoute(routeInfo);

        //5
        routeInfo.setRouteName("진해선");
        routeInfo.setDepartureStation("창원");
        routeInfo.setArrivelStation("통해");
        busRouteDAO.createRoute(routeInfo);

        //6
        routeInfo.setRouteName("광양제철선");
        routeInfo.setDepartureStation("광양");
        routeInfo.setArrivelStation("태금");
        busRouteDAO.createRoute(routeInfo);

        //7
        routeInfo.setRouteName("남부선하행");
        routeInfo.setDepartureStation("서울");
        routeInfo.setArrivelStation("포항");
        busRouteDAO.createRoute(routeInfo);

        //8
        routeInfo.setRouteName("남부선상행");
        routeInfo.setDepartureStation("포항");
        routeInfo.setArrivelStation("서울");
        busRouteDAO.createRoute(routeInfo);

        //9
        routeInfo.setRouteName("부산신항선");
        routeInfo.setDepartureStation("진례");
        routeInfo.setArrivelStation("부산신항");
        busRouteDAO.createRoute(routeInfo);

        //10
        routeInfo.setRouteName("덕산선");
        routeInfo.setDepartureStation("창원");
        routeInfo.setArrivelStation("덕산");
        busRouteDAO.createRoute(routeInfo);
    }

    public static void scheduleRecodeInsert(){

        ScheduleInfo scheduleInfo = new ScheduleInfo();
        BusScheduleDAO busScheduleDAO = new BusScheduleDAOImpl();

        /**운행스케줄 테이블 생성 */
        busScheduleDAO.createTable();

        /**운행스케줄 레코드 10개*/
        //1
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.10); //10시 10분
        scheduleInfo.setArrivelTime((float) 16.10);
        scheduleInfo.setTransitCode("A"); //용인 -> 대전
        busScheduleDAO.createSchecdule(scheduleInfo);

        //2
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("화");
        scheduleInfo.setDepartureTime((float) 11.10); //11시 10분
        scheduleInfo.setArrivelTime((float) 16.20);
        scheduleInfo.setTransitCode("B"); //천안 -> 대전
        busScheduleDAO.createSchecdule(scheduleInfo);

        //3
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("수");
        scheduleInfo.setDepartureTime((float) 12.10); //12시 10분
        scheduleInfo.setArrivelTime((float) 17.10);
        scheduleInfo.setTransitCode("C"); //대전
        busScheduleDAO.createSchecdule(scheduleInfo);

        //4
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("목");
        scheduleInfo.setDepartureTime((float) 13.10); //13시 10분
        scheduleInfo.setArrivelTime((float) 17.20);
        scheduleInfo.setTransitCode("D"); // 동대구 -> 김해
        busScheduleDAO.createSchecdule(scheduleInfo);

        //5
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("금");
        scheduleInfo.setDepartureTime((float) 14.10); //14시 10분
        scheduleInfo.setArrivelTime((float) 17.00);
        scheduleInfo.setTransitCode("E"); // 울산
        busScheduleDAO.createSchecdule(scheduleInfo);

        //6
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("토");
        scheduleInfo.setDepartureTime((float) 15.10); //15시 10분
        scheduleInfo.setArrivelTime((float) 20.00);
        scheduleInfo.setTransitCode("F"); // 김해
        busScheduleDAO.createSchecdule(scheduleInfo);

        //7
        scheduleInfo.setRouteName("경부선하행");
        scheduleInfo.setDay("일");
        scheduleInfo.setDepartureTime((float) 16.10); //16시 10분
        scheduleInfo.setArrivelTime((float) 22.00);
        scheduleInfo.setTransitCode("G"); // 창원
        busScheduleDAO.createSchecdule(scheduleInfo);

        //8
        scheduleInfo.setRouteName("경부선상행");
        scheduleInfo.setDay("월");
        scheduleInfo.setDepartureTime((float) 10.20); //10시 20분
        scheduleInfo.setArrivelTime((float) 17.10);
        scheduleInfo.setTransitCode("H");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //9
        scheduleInfo.setRouteName("경부선상행");
        scheduleInfo.setDay("화");
        scheduleInfo.setDepartureTime((float) 11.00); //11시 10분
        scheduleInfo.setArrivelTime((float) 15.30);
        scheduleInfo.setTransitCode("I");
        busScheduleDAO.createSchecdule(scheduleInfo);

        //10
        scheduleInfo.setRouteName("경부선상행");
        scheduleInfo.setDay("수");
        scheduleInfo.setDepartureTime((float) 12.05); //12시 10분
        scheduleInfo.setArrivelTime((float) 17.35);
        scheduleInfo.setTransitCode("J");
        busScheduleDAO.createSchecdule(scheduleInfo);
    }

    public static void viaRecodeInsert(){
        ViaInfo viaInfo = new ViaInfo();
        ViaBusDAO viaBusDAO = new ViaBusDAOImpl();

        /**경유 테이블 생성*/
        viaBusDAO.createTable();

        /**경유 레코드 10개*/
        //1
        viaInfo.setTransitCode("A");
        viaInfo.setStation("용인");
        viaInfo.setArrivelTime((float)10.50); //10시 50분
        viaInfo.setDepartureTime((float)11.00);
        viaBusDAO.createVia(viaInfo);

        //1-1
        viaInfo.setTransitCode("A");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)13.00); //13시 00분
        viaInfo.setDepartureTime((float)13.10);
        viaBusDAO.createVia(viaInfo);


        //2
        viaInfo.setTransitCode("B");
        viaInfo.setStation("천안");
        viaInfo.setArrivelTime((float)12.10);
        viaInfo.setDepartureTime((float)12.20);

        viaBusDAO.createVia(viaInfo);

        //2-1
        viaInfo.setTransitCode("B");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)13.10);
        viaInfo.setDepartureTime((float)13.20);

        viaBusDAO.createVia(viaInfo);

        //3
        viaInfo.setTransitCode("C");
        viaInfo.setStation("대전");
        viaInfo.setArrivelTime((float)14.00);
        viaInfo.setDepartureTime((float)14.10);

        viaBusDAO.createVia(viaInfo);

        //4
        viaInfo.setTransitCode("D");
        viaInfo.setStation("동대구");
        viaInfo.setArrivelTime((float)15.00);
        viaInfo.setDepartureTime((float)15.10);

        viaBusDAO.createVia(viaInfo);

        //4-1
        viaInfo.setTransitCode("D");
        viaInfo.setStation("김해");
        viaInfo.setArrivelTime((float)16.30);
        viaInfo.setDepartureTime((float)16.40);

        viaBusDAO.createVia(viaInfo);

        //5
        viaInfo.setTransitCode("E");
        viaInfo.setStation("울산");
        viaInfo.setArrivelTime((float)16.00);
        viaInfo.setDepartureTime((float)16.10);

        viaBusDAO.createVia(viaInfo);

        //6
        viaInfo.setTransitCode("F");
        viaInfo.setStation("김해");
        viaInfo.setArrivelTime((float)19.10);
        viaInfo.setDepartureTime((float)19.20);

        viaBusDAO.createVia(viaInfo);

        //7
        viaInfo.setTransitCode("G");
        viaInfo.setStation("창원");
        viaInfo.setArrivelTime((float)20.05);
        viaInfo.setDepartureTime((float)20.15);

        viaBusDAO.createVia(viaInfo);

        //8
        viaInfo.setTransitCode("H");
        viaInfo.setStation("안동");
        viaInfo.setArrivelTime((float)13.00);
        viaInfo.setDepartureTime((float)13.10);

        viaBusDAO.createVia(viaInfo);

        //9
        viaInfo.setTransitCode("I");
        viaInfo.setStation("경주");
        viaInfo.setArrivelTime((float)11.50);
        viaInfo.setDepartureTime((float)12.00);

        viaBusDAO.createVia(viaInfo);

        //10
        viaInfo.setTransitCode("J");
        viaInfo.setStation("세종");
        viaInfo.setArrivelTime((float)15.45);
        viaInfo.setDepartureTime((float)15.55);

        viaBusDAO.createVia(viaInfo);
    }
}

package com.bus.DAO;

import com.bus.VO.ScheduleInfo;

import java.util.List;

public interface BusScheduleDAO {

    //운행스케줄 테이블 생성
    public void createTable();

    //운행스케줄 등록
    public void createSchecdule(ScheduleInfo scheduleInfo);

    //운행스케줄 검색
    public List<ScheduleInfo> searchSchedule(String onStation, String offStation, float time);

}

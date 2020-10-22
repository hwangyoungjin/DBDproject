package com.bus.DAO;

import com.bus.VO.ViaInfo;

public interface ViaBusDAO {

    //경유 테이블 생성
    public void createTable();

    //경유지 등록
    public void createVia(ViaInfo viaInfo);

}

package com.bus.DAO.Impl;

import com.bus.DAO.BusScheduleDAO;
import com.bus.VO.ScheduleInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusScheduleDAOImpl implements BusScheduleDAO {

    /**
     * CREATE TABLE
     *
     * CREATE TABLE `busdb`.`busschedule` (
     *   `routeName` VARCHAR(45) NOT NULL,
     *   `day` VARCHAR(45) NOT NULL,
     *   `departureTime` FLOAT NULL,
     *   `arrivelTime` FLOAT NULL,
     *   `transitCode` VARCHAR(45) NULL,
     *   PRIMARY KEY (`routeName`, `day`));
     */

    @Override
    public void createSchecdule(ScheduleInfo scheduleInfo) {
        /* Retrieve DB authentication information*/
        DBD_env_unification.DatabaseAuthInformation dbInfo = new DBD_env_unification.DatabaseAuthInformation();
        dbInfo.parse_auth_info("auth/mysql.auth");
        //dbInfo.debug_print();

        /* Preparation for db process*/
        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;

        try{
            /*Driver load*/
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*Prepare the URL for DB connection*/
            String dbConnectionUrl = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    dbInfo.getHost(),dbInfo.getPort(), dbInfo.getDatabase_name());

            /*Prepare the query statement*/
            String queryString = "insert into busschedule (routeName,day,departureTime,arrivelTime,transitCode) values(?,?,?,?,?)";

            /*DB insertion process*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());
            dbPreparedStatement = dbConnection.prepareStatement(queryString);

            /*Set the query statement*/
            dbPreparedStatement.setString(1,scheduleInfo.getRouteName());
            dbPreparedStatement.setString(2,scheduleInfo.getDay());
            dbPreparedStatement.setFloat(3,scheduleInfo.getDepartureTime());
            dbPreparedStatement.setFloat(4,scheduleInfo.getArrivelTime());
            dbPreparedStatement.setString(5,scheduleInfo.getTransitCode());

            System.out.println(dbPreparedStatement);

            /*send query and get the result*/
            int result = dbPreparedStatement.executeUpdate();
            System.out.println("Updated query : "+ result);

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            try{
                //Clean-UP
                if(dbPreparedStatement != null){
                    dbPreparedStatement.close();
                }
                if(dbConnection != null){
                    dbConnection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ScheduleInfo> searchSchedule(String onStation, String offStation, float time) {
        List<ScheduleInfo> scheduleInfoList = new ArrayList<>();

        /* Retrieve DB authentication information*/
        DBD_env_unification.DatabaseAuthInformation dbInfo = new DBD_env_unification.DatabaseAuthInformation();
        dbInfo.parse_auth_info("auth/mysql.auth");
        //dbInfo.debug_print();

        /* Preparation for db process*/
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet queryResultset = null;

        try{
            /*Driver load*/
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*Prepare the URL for DB connection*/
            String dbConnectionUrl = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    dbInfo.getHost(),dbInfo.getPort(), dbInfo.getDatabase_name());

            /*Set the db connection*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());

            /*Set the query statement*/
            StringBuffer queryString = new StringBuffer();
            queryString.append("Select 노선명, 요일, 출발시간, 도착시간 from busschedule as D, busroute as R, viabus as V");
            queryString.append(" Where D.routeName = R.routeName AND R.transitCode = V.transitCode AND D.출발시간 > 시간(t0)");
            queryString.append(" AND (R.departureStation = "+onStation+"OR V.station = "+onStation);
            queryString.append(" AND (R.arrivelStation = "+offStation+"OR V.station = "+offStation+")");
            statement = dbConnection.createStatement();
            System.out.println("select sql ->"+queryString);

            /*send query and get the result*/
            queryResultset = statement.executeQuery(queryString.toString());

            /*Retrieve the information from the query response*/
            while (queryResultset.next()){
                ScheduleInfo scheduleInfo = new ScheduleInfo();
                scheduleInfo.setRouteName(queryResultset.getNString("routeName"));
                scheduleInfo.setDay(queryResultset.getString("day"));
                scheduleInfo.setDepartureTime(queryResultset.getFloat("departureTime"));
                scheduleInfo.setArrivelTime(queryResultset.getFloat("arrivelTime"));
                scheduleInfo.setTransitCode(queryResultset.getString("transitCode"));
                scheduleInfoList.add(scheduleInfo);
                System.out.println(scheduleInfo.toString());
            }
            System.out.println("select finished!");

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            try{
                //Clean-UP
                if(queryResultset != null){
                    queryResultset.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(dbConnection != null){
                    dbConnection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return scheduleInfoList;
    }
}

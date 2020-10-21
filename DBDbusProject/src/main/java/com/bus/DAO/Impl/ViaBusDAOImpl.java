package com.bus.DAO.Impl;

import com.bus.DAO.ViaBusDAO;
import com.bus.VO.ViaInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ViaBusDAOImpl implements ViaBusDAO {


    /**
     * CREATE TABLE
     *
     * CREATE TABLE `busdb`.`viabus` (
     *   `transitCode` VARCHAR(45) NOT NULL,
     *   `station` VARCHAR(45) NOT NULL,
     *   `arrivelTime` FLOAT NOT NULL,
     *   `departureTime` FLOAT NULL,
     *   PRIMARY KEY (`transitCode`, `station`, `arrivelTime`));
     */


    @Override
    public void createVia(ViaInfo viaInfo) {
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
            String queryString = "insert into viabus (transitCode,station,departureTime,arrivelTime) values(?,?,?,?)";

            /*DB insertion process*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());
            dbPreparedStatement = dbConnection.prepareStatement(queryString);

            /*Set the query statement*/
            dbPreparedStatement.setString(1,viaInfo.getTransitCode());
            dbPreparedStatement.setString(2,viaInfo.getStation());
            dbPreparedStatement.setFloat(3,viaInfo.getDepartureTime());
            dbPreparedStatement.setFloat(4,viaInfo.getArrivelTime());

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
}

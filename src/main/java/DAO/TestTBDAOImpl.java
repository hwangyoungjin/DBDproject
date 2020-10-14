package DAO;

import DBD_env_unification.DatabaseAuthInformation;
import VO.TestTBVO;

import java.sql.*;

public class TestTBDAOImpl implements TestTBDAO {
    @Override
    public void getTestTB() {


        /* Retrieve DB authentication information*/
        DatabaseAuthInformation dbInfo = new DatabaseAuthInformation();
        dbInfo.parse_auth_info("auth/mysql.auth");
        //dbInfo.debug_print();

        /* Preparation for db process*/
        Connection dbConnection = null;
        PreparedStatement dbPreparedStatement = null;
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
            String queryString = "select value from test_tb where id > 50";
            dbPreparedStatement = dbConnection.prepareStatement(queryString);
            System.out.println("select sql ->"+queryString);

            /*send query and get the result*/
            queryResultset = dbPreparedStatement.executeQuery();

            /*Retrieve the information from the query response*/
            while (queryResultset.next()){
                System.out.println("[item]" + queryResultset.getFloat("value"));
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
    public void createTestTB(TestTBVO testTBVO) {
        /* Retrieve DB authentication information*/
        DatabaseAuthInformation dbInfo = new DatabaseAuthInformation();
        dbInfo.parse_auth_info("auth/mysql.auth");
        //dbInfo.debug_print();

        /* Preparation for db process*/
        Connection dbConnection = null;
        Statement dbStatement = null;

        try{
            /*Driver load*/
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*Prepare the URL for DB connection*/
            String dbConnectionUrl = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    dbInfo.getHost(),dbInfo.getPort(), dbInfo.getDatabase_name());

            /*Set the db connection*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());

            /*Set the query statement*/
            dbStatement = dbConnection.createStatement();
            String queryString = "insert into test_tb (id,value) values ("+testTBVO.getId()+","+testTBVO.getValue()+")";
            System.out.println("insert sql ->"+queryString);

            /*send query and get the result*/
            dbStatement.executeUpdate(queryString);
            System.out.println("insert finished!");


        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            try{
                //Clean-UP
                if(dbStatement != null){
                    dbStatement.close();
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

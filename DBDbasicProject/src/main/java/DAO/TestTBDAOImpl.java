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
            String queryString = "select id,value from test_tb where id > 50";
            statement = dbConnection.createStatement();
            System.out.println("select sql ->"+queryString);

            /*send query and get the result*/
            queryResultset = statement.executeQuery(queryString);

            /*Retrieve the information from the query response*/
            while (queryResultset.next()){
                System.out.println("#" +queryResultset.getInt("id")+" : "+ queryResultset.getFloat("value"));
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
    }

    @Override
    public void createTestTB(TestTBVO testTBVO) {
        /* Retrieve DB authentication information*/
        DatabaseAuthInformation dbInfo = new DatabaseAuthInformation();
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
            String queryString = "insert into test_tb (id,value) values(?,?)";

            /*DB insertion process*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());
            dbPreparedStatement = dbConnection.prepareStatement(queryString);

            /*Set the query statement*/
            dbPreparedStatement.setInt(1,testTBVO.getId());
            dbPreparedStatement.setFloat(2,testTBVO.getValue());

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

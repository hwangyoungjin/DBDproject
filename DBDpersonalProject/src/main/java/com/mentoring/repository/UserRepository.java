package com.mentoring.repository;

import com.mentoring.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void createTable() {
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
            String queryString = "CREATE TABLE codingmentoring.user"
                    +" (id VARCHAR(45) NOT NULL,"
                    +" pw VARCHAR(45) NOT NULL,"
                    +" name VARCHAR(45) NULL,"
                    +" gender VARCHAR(45) NULL,"
                    +" job VARCHAR(45) NULL, "
                    +" PRIMARY KEY (id))";

            /*DB insertion process*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());
            dbPreparedStatement = dbConnection.prepareStatement(queryString);

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

    public void creteUserTable(){
        /*

         */
    }

    public void createUser(User user){
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
            String queryString = "insert into user (id,pw,name,gender,job) values(?,?,?,?,?)";

            /*DB insertion process*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());
            dbPreparedStatement = dbConnection.prepareStatement(queryString);

            /*Set the query statement*/
            dbPreparedStatement.setString(1,user.getId());
            dbPreparedStatement.setString(2,user.getPw());
            dbPreparedStatement.setString(3,user.getName());
            dbPreparedStatement.setString(4,user.getGender());
            dbPreparedStatement.setString(5,user.getJob());

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


    public User getUser(String userName){
        User user = new User();

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
            String queryString = "select * from user where name = ?";

            /*DB insertion process*/
            dbConnection = DriverManager.getConnection(dbConnectionUrl,dbInfo.getUsername(),dbInfo.getPassword());
            dbPreparedStatement = dbConnection.prepareStatement(queryString);

            /*Set the query statement*/
            dbPreparedStatement.setString(1,userName);
            System.out.println(dbPreparedStatement);

            /*send query and get the result*/
            ResultSet queryResult = dbPreparedStatement.executeQuery();
            while(queryResult.next()){
                user.setId(queryResult.getString("id"));
                user.setPw(queryResult.getString("pw"));
                user.setName(queryResult.getString("name"));
                user.setGender(queryResult.getString("gender"));
                user.setJob(queryResult.getString("job"));
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            try {
                //Clean-UP
                if (dbPreparedStatement != null) {
                    dbPreparedStatement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return user;
    }
}

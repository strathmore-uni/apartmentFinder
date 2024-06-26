package com.apartmentFinder.components.utils;

import java.sql.*;

public class DBConnector {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/db_braine_lomoni_168864";
    static final String USER = "root";
    static final String PASSWORD = "";
    static final String DB_NAME = "";
    private String usersTable = "tbl_users";
    private Connection conn;
    private Statement statement;
    private ResultSet result;

    public DBConnector() {
        try {
            //Load the driver class
            Class.forName(DRIVER);

            //Establish connection
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            //Create statement for querying database
            statement = conn.createStatement();
        } catch (ClassNotFoundException exception) {
            // -> Superior for production purposes : Log("FATAL", "Exception on class not found : " + exception.getMessage(), exception, DBConnector.class.getName());
            System.out.println("FATAL. Class Not Found Exception : "+exception.getMessage());
        } catch (SQLException exception) {
            // Log("FATAL", "SQL Exception : " + exception.getMessage(), exception, DBConnector.class.getName());
            System.out.println("FATAL. SQL Exception : "+exception.getMessage());
        }
    }
}

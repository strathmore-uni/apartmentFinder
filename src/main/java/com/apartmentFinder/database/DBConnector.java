package com.apartmentFinder.database;

import java.sql.*;

import static com.apartmentFinder.ApartmentFinder.Log;

public class DBConnector {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/test_database";
    static final String USER = "root";
    static final String PASSWORD = "";
    static final String DB_NAME = "";
    // e.g private String usersTable = "tbl_users"; - Then use it in your CRUD method below
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
            Log("FATAL", "Exception on class not found : " + exception.getMessage(), exception, DBConnector.class.getName());
        } catch (SQLException exception) {
            Log("FATAL", "SQL Exception : " + exception.getMessage(), exception, DBConnector.class.getName());
        }
    }

    // SQL - CRUD Methods here.
}
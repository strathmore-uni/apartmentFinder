package com.apartmentFinder.components.utils;

import java.sql.*;
import java.util.LinkedList;

public class DBConnector {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/apartmentFinder";
    static final String USER = "root";
    static final String PASSWORD = "";
    private String apartmentsTable = "apartments";
    private String landlordsTable = "landlords";
    private String locationsTable = "locations";
    private String unitsTable = "units";
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

    // Methods for CRUD go here
    // 1. Fetch apartments with filters in the apartmentListPage
    public LinkedList<Unit> fetchFilteredApartments(String location, String min_price, String max_price) {
        LinkedList<Unit> apartmentsList = new LinkedList<>();
        try {
            String query = "SELECT l.description AS location_description, u.bedrooms AS bedrooms, u.bathrooms AS bathrooms, u.sqft AS sqft, u.id AS unit_id, a.id AS apartment_id, \n" +
                    "  u.price\n" +
                    "FROM locations AS l\n" +
                    "INNER JOIN apartments AS a ON l.id = a.location_id\n" +
                    "INNER JOIN units AS u ON a.id = u.apartment_id\n" +
                    "WHERE l.description LIKE ? AND u.price >= ? AND u.price <= ?\n" +
                    "GROUP BY l.description, a.id, u.price;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,"%"+location+"%");
            preparedStatement.setString(2,min_price);
            preparedStatement.setString(3, max_price);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                String locationDescription = result.getString("location_description");
                String bedrooms = result.getString("bedrooms");
                String bathrooms = result.getString("bathrooms");
                String sqft = result.getString("sqft");
                String unitId = result.getString("unit_id");
                String apartmentId = result.getString("apartment_id");
                String price = result.getString("price");

                // Create a Unit object to store the data
                Unit unit = new Unit(locationDescription, bedrooms, bathrooms, sqft, unitId, apartmentId, price);

                // Add the Unit object to the LinkedList
                apartmentsList.add(unit);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching filtered apartments: " + e.getMessage());
        }

        return apartmentsList;
    }
    public String userName;
    public boolean checkUserForLogin(String number){
        boolean exists = false;
        try {
            String query="SELECT COUNT(*) FROM landlords WHERE phone = ? ";
            PreparedStatement preparedStatement=conn.prepareStatement(query);
            preparedStatement.setString(1, number);
            try(ResultSet resultSet =preparedStatement.executeQuery()){
                if (resultSet.next() && resultSet.getInt(1)>0){
                    exists=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}

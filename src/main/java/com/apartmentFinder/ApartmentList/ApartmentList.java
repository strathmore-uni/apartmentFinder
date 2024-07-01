package com.apartmentFinder.ApartmentList;

import com.apartmentFinder.ApartmentList.components.ApartmentCard;
import com.apartmentFinder.components.utils.DBConnector;
import com.apartmentFinder.components.utils.SearchData;
import com.apartmentFinder.components.utils.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ApartmentList {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JTextField location_input;
    private JComboBox min_price_combo_box;
    private JButton button1;
    private JComboBox max_price_combo_box;
    private JPanel apartmentListContainer;
    private String location_value;
    private String min_price;
    private String max_price;

    public ApartmentList(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    //When search data is involved
    public ApartmentList(){
    }

    public void fetchSearchData(SearchData searchData){
        location_value = searchData.getLocation();
        min_price = searchData.getMinPrice();
        max_price = searchData.getMaxPrice();

        // Update the input fields
        location_input.setText(location_value);
        min_price_combo_box.setSelectedItem(min_price);
        max_price_combo_box.setSelectedItem(max_price);

        // Fetch data with filters from the database
        DBConnector dbConnector = new DBConnector();
        LinkedList<Unit> apartmentList = dbConnector.fetchFilteredApartments(location_value,min_price, max_price);

        // Display apartmentListContainer cards
        ApartmentCard[] cards = new ApartmentCard[apartmentList.size()];
        int counter = 0;
        for (Unit unit : apartmentList) {
            // Apartment ID
            int apartmentID = Integer.parseInt(unit.getApartmentId());
            int unitID = Integer.parseInt(unit.getUnitId());
            cards[counter] = new ApartmentCard(apartmentID,unitID);
            // Location Description
            cards[counter].setLocation_label(unit.getLocationDescription());
            // Price
            cards[counter].setPrice_number(unit.getPrice());
            // Bathrooms
            cards[counter].setBathroom_number(unit.getBathrooms());
            // Bedrooms
            cards[counter].setBedroom_number(unit.getBedrooms());
        }
        for(ApartmentCard card : cards){
//            System.out.println(apartmentListContainer.getComponents());

        }
        cardLayout.show(container,"apartmentListPage");
    }

    private void fetchAndFilterFromTheDB(String location, String min_price, String max_price){}
    public JPanel createMainPanel(){
        return mainPanel;
    }
}

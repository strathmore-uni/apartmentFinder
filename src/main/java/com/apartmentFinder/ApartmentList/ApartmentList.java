package com.apartmentFinder.ApartmentList;

import com.apartmentFinder.ApartmentList.components.ApartmentCardJava;
import com.apartmentFinder.components.utils.DBConnector;
import com.apartmentFinder.components.utils.SearchData;
import com.apartmentFinder.components.utils.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ApartmentList {
//    NOTE - I'm still experimenting, so most of this code will look messy and unreadable and stupid
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JPanel apartmentListContainer;
    private JPanel apartmentCards;
    private JButton filterButton;
    private String location_value;
    private String min_price;
    private String max_price;

    // Store data fetched from the database
    private LinkedList<Unit> apartmentList;

    public ApartmentList(Container container, CardLayout cardLayout, SearchData searchData) {
        this.container = container;
        this.cardLayout = cardLayout;

        fetchSearchData(searchData);


        // Set action listeners
        setActionListeners();
    }

    public void setActionListeners() {
        filterButton.addActionListener(e -> {
            // Fetch data from the database with filters
            // Pop apartmentListPage from the stack
            cardLayout.show(container, "choicePage");
        });
    }

    // Fetch data from the database with filters
    public void fetchSearchData(SearchData searchData) {
        location_value = searchData.getLocation();
        min_price = searchData.getMinPrice();
        max_price = searchData.getMaxPrice();

        // Fetch data with filters from the database
        DBConnector dbConnector = new DBConnector();
        this.apartmentList = dbConnector.fetchFilteredApartments(location_value, min_price, max_price);

        refreshApartmentCards();

        System.out.println(apartmentList);

        // Show the updated apartment list page
        cardLayout.show(container, "apartmentListPage");
    }

    public JPanel createMainPanel() {
        return mainPanel;
    }

    private void refreshApartmentCards() {
        // Clear existing cards
        apartmentCards.removeAll();

        if (apartmentList != null) {
            for (Unit unit : apartmentList) {
                ApartmentCardJava card = new ApartmentCardJava(container, cardLayout, unit.getApartmentId(), unit.getUnitId());

                card.setLocation_label(unit.getLocationDescription());
                card.setPrice_number(unit.getPrice());
                card.setBathroom_number(unit.getBathrooms());
                card.setBedroom_number(unit.getBedrooms());
                card.getMainPanel().setVisible(true);

                apartmentCards.add(card.getMainPanel());
            }
        }

        // Revalidate and repaint the panel to reflect the changes
        apartmentCards.revalidate();
        apartmentCards.repaint();
    }

    public void createUIComponents() {
        // Place custom component creation code here
        apartmentListContainer = new JPanel();
        apartmentListContainer.setLayout(new BorderLayout());
        apartmentCards = new JPanel();
        apartmentCards.setLayout(new GridLayout(0, 4, 10, 10));
        apartmentListContainer.add(apartmentCards, BorderLayout.CENTER);
    }
}

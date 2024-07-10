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
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JTextField location_input;
    private JComboBox<String> min_price_combo_box;
    private JButton button1;
    private JComboBox<String> max_price_combo_box;
    private JPanel apartmentListContainer;
    private JPanel apartmentCards;
    private String location_value;
    private String min_price;
    private String max_price;

    // Store data fetched from the database
    private LinkedList<Unit> apartmentList;

    public ApartmentList(Container container, CardLayout cardLayout) {
        this.container = container;
        this.cardLayout = cardLayout;

        fetchSearchData(new SearchData("", "0", "100000"));
    }

    // When search data is involved
    public ApartmentList() {
    }

    // Fetch data from the database with filters
    public void fetchSearchData(SearchData searchData) {
        location_value = searchData.getLocation();
        min_price = searchData.getMinPrice();
        max_price = searchData.getMaxPrice();

        // Update the input fields
        location_input.setText(location_value);
        min_price_combo_box.setSelectedItem(min_price);
        max_price_combo_box.setSelectedItem(max_price);

        // Fetch data with filters from the database
        DBConnector dbConnector = new DBConnector();
        this.apartmentList = dbConnector.fetchFilteredApartments(location_value, min_price, max_price);

        refreshApartmentCards();

        System.out.println(apartmentList);

        // Show the updated apartment list page
        cardLayout.show(container, "apartmentListPage");
    }

    // Filter existing data
    public void fetchSearchData(String location, String min_price, String max_price) {
        location_value = location;
        this.min_price = min_price;
        this.max_price = max_price;

        // Update the input fields
        location_input.setText(location_value);
        min_price_combo_box.setSelectedItem(min_price);
        max_price_combo_box.setSelectedItem(max_price);

        // Filter the existing apartment list
        LinkedList<Unit> filteredList = apartmentList.stream()
                .filter(unit -> unit.getLocationDescription().contains(location_value))
                .filter(unit -> Integer.parseInt(unit.getPrice()) >= Integer.parseInt(min_price))
                .filter(unit -> Integer.parseInt(unit.getPrice()) <= Integer.parseInt(max_price))
                .collect(Collectors.toCollection(LinkedList::new));

        this.apartmentList = filteredList;

        refreshApartmentCards();

        System.out.println(apartmentList);

        // Show the updated apartment list page
        cardLayout.show(container, "apartmentListPage");
    }

    private void fetchAndFilterFromTheDB(String location, String min_price, String max_price) {
        // Implement this method if needed
    }

    public JPanel createMainPanel() {
        return mainPanel;
    }

    private void refreshApartmentCards() {
        // Clear existing cards
        apartmentCards.removeAll();

        if (apartmentList != null) {
            for (Unit unit : apartmentList) {
                ApartmentCardJava card = new ApartmentCardJava();
                // Set data to card
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

    private void createUIComponents() {
        // Place custom component creation code here
        apartmentListContainer = new JPanel();
        apartmentListContainer.setLayout(new BorderLayout());
        apartmentCards = new JPanel();
        apartmentCards.setLayout(new GridLayout(0, 4, 10, 10));
        apartmentListContainer.add(apartmentCards, BorderLayout.CENTER);
    }
}

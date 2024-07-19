package com.apartmentFinder.ApartmentList;

import com.apartmentFinder.ApartmentList.components.ApartmentCardJava;
import com.apartmentFinder.components.utils.DBConnector;
import com.apartmentFinder.components.utils.SearchData;
import com.apartmentFinder.components.utils.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import static com.apartmentFinder.components.utils.apartmentFinderDialog.showMessage;

public class ApartmentList {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JPanel apartmentListContainer;
    private JPanel apartmentCards;
    private JButton filterButton;
    private JLabel subtitle;
    private JButton addApartmentButton;
    private String location_value;
    private String min_price;
    private String max_price;

    // Store data fetched from the database
    private LinkedList<Unit> apartmentList;

    public ApartmentList(Container container, CardLayout cardLayout, SearchData searchData) {
        this.container = container;
        this.cardLayout = cardLayout;

        fetchSearchData(searchData);

        // Set the number of apartments found on Title
        if(apartmentList.size() > 0) {
            subtitle.setText(apartmentList.size() + " apartment(s) found.");
        }
        // Set action listeners
        setActionListeners();
    }

    public void setActionListeners() {
        filterButton.addActionListener(e -> {
            // Fetch data from the database with filters
            // Pop apartmentListPage from the stack
            cardLayout.show(container, "choicePage");
        });

        addApartmentButton.addActionListener(e -> {
            // Pop apartmentListPage from the stack
            cardLayout.show(container, "addApartmentPage");
        });
    }

    // Fetch data from the database with filters
    public void fetchSearchData(SearchData searchData) {
        location_value = searchData.getLocation();
        min_price = searchData.getMinPrice();
        max_price = searchData.getMaxPrice();

        // Fetch data with filters from the database
        DBConnector dbConnector = new DBConnector();
        try {
            this.apartmentList = dbConnector.fetchFilteredApartments(location_value, min_price, max_price);
        } catch (Exception e) {
            showMessage(container,"Make sure the database is set up correctly then try again", "Error", JOptionPane.ERROR_MESSAGE);
            //Devmode
            //e.printStackTrace();
        }
        refreshApartmentCards();

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

        // apartmentList is empty
        if(apartmentList == null || apartmentList.isEmpty()) {
            JLabel noApartmentsLabel = new JLabel("No apartments found. Adjust your filters and try again.");
            // Center the text
            noApartmentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            // Make the text bold and white
            noApartmentsLabel.setForeground(Color.WHITE);
            apartmentCards.add(noApartmentsLabel);
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

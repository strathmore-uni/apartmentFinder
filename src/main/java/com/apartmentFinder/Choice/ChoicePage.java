package com.apartmentFinder.Choice;

import com.apartmentFinder.ApartmentList.ApartmentList;
import com.apartmentFinder.components.utils.InputFieldFocusListener;
import com.apartmentFinder.components.utils.SearchData;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import static com.apartmentFinder.components.utils.apartmentFinderDialog.showMessage;

public class ChoicePage{
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JLabel subtitle;
    private JButton addApartmentButton;
    private JButton searchForApartment;
    private JTextField location;
    private JComboBox max_price_combo_box;
    private JComboBox min_price_combo_box;
    private String location_value;

    public ChoicePage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;

        // Focus Listeners
        setFocusListeners();

        //Document Listener on location - To capture data from input on change
        location.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                location_value = location.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                location_value = location.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                location_value = location.getText();
            }
        });

        // Action Listeners
        searchForApartment.addActionListener(e->{
            handleSearchForApartment();
        });

        addApartmentButton.addActionListener(e->{
            handleAddApartmentAction();
        });
    }

    //Focus Listeners on Input
    private void setFocusListeners() {
        try {
            final InputFieldFocusListener locationFieldListener = new InputFieldFocusListener(location, "Search for a location");
            location.addFocusListener(locationFieldListener);
        } catch (Exception e) {
            System.out.println("Error setting a focus listener on location input field : "+e.getMessage());
        }
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }

    public void handleSearchForApartment() {
        //Check if location is empty
        if(location_value == null || location_value.isEmpty()){
            showMessage(container,"Please enter a location to search for an apartment","Error",0);
            return;
        }

        // Check if min price is greater than max price

        if(min_price_combo_box.getSelectedIndex() > max_price_combo_box.getSelectedIndex()){
            showMessage(container,"Minimum price cannot be greater than maximum price","Error",0);
            return;
        }

        if(min_price_combo_box.getSelectedIndex() == 0){
            showMessage(container,"Please select a minimum price","Error",0);
            return;
        }

        if(max_price_combo_box.getSelectedIndex() == 0){
            showMessage(container,"Please select a maximum price","Error",0);
            return;
        }

        // Get input values from combo boxes
        String min_price = (String) min_price_combo_box.getSelectedItem();
        String max_price = (String) max_price_combo_box.getSelectedItem();

        // Fetch data from the database
        System.out.println("Location : "+location_value);
        System.out.println("Min Price : "+min_price);
        System.out.println("Max Price : "+max_price);

        // Create a SearchData object
        SearchData searchData = new SearchData(location_value, min_price, max_price);

        // Pass the data to the apartmentListPage
        // 2. Apartment List Page
        ApartmentList apartmentListPage = new ApartmentList(container,cardLayout,searchData);
        container.add("apartmentListPage",apartmentListPage.createMainPanel());

        cardLayout.show(container,"apartmentListPage");
    }

    public void handleAddApartmentAction(){
        showMessage(container,"You need to log in to add an apartment listing","Add Apartment",1);
        cardLayout.show(container,"loginPage");
    }


}

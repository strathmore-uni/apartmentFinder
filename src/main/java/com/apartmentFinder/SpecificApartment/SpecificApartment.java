package com.apartmentFinder.SpecificApartment;

import com.apartmentFinder.components.utils.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SpecificApartment {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel apartmentID;
    private int apartmentId;
    private int unitID;
    private JLabel unitID_label;
    private LinkedList<Unit> unit;

    public SpecificApartment(Container container, CardLayout cardLayout,int apartmentId, int unitID){
        this.container = container;
        this.cardLayout = cardLayout;
        this.apartmentId = apartmentId;
        this.unitID = unitID;

        //Set text - This was meant to show you that the apartment ID and unit ID are being passed to this class when you click the 'View' button, you can remove it.
        apartmentID.setText("Apartment ID: "+apartmentId);
        unitID_label.setText("Unit ID: "+unitID);
    }

    // Fetch the unit details from the database
    public LinkedList<Unit> fetchUnitDetails(int apartmentId, int unitID){
        // Fetch the unit details from the database
        // E.g Fetch Unit where apartment ID is apartmentID and Unit ID is unitID then assign it to the `unit` variable
        // This is just a suggestion though
        return unit;
    }
    public JPanel createMainPanel(){
        return mainPanel;
    }
}

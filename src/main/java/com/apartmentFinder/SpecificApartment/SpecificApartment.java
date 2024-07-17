package com.apartmentFinder.SpecificApartment;

import javax.swing.*;
import java.awt.*;

public class SpecificApartment {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel apartmentID;
    private int apartmentId;
    private int unitID;
    private JLabel unitID_label;

    public SpecificApartment(Container container, CardLayout cardLayout,int apartmentId, int unitID){
        this.container = container;
        this.cardLayout = cardLayout;
        this.apartmentId = apartmentId;
        this.unitID = unitID;

        //Set text
        apartmentID.setText("Apartment ID: "+apartmentId);
        unitID_label.setText("Unit ID: "+unitID);
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

package com.apartmentFinder.SpecificApartment;

import com.apartmentFinder.components.utils.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SpecificApartment {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel AppNamePanel;
    private JPanel PageNamePanel;
    private JPanel SpecificApartmentPanel;
    private JPanel ImagesPanel;
    private JLabel img1;
    private JLabel img2;
    private JPanel ApartmentDetailsPanel;
    private JPanel ContactInfoPanel;
    private JPanel ReviewsPanel;
    private JLabel DescriptionTitle;
    private JLabel AmenitiesTitle;
    private JLabel ReviewTitle;
    private JPanel ReviewTitlePanel;
    private JPanel Review1;
    private JPanel ProfilePicPanel;
    private JLabel ProfilePic;
    private JPanel ReviewDesc;
    private JPanel Reviewer;
    private JLabel Name;
    private JLabel Rating;
    private JLabel ReviewDescription;
    private JLabel Amenitiy1Icon;
    private JLabel Amenity1Text;
    private JPanel DescriptionPanel;
    private JButton Whatsapp;
    private JLabel MoreDetails;
    private JTextArea ReviewText;
    private JTextArea DescriptionText;
    private JLabel label1;
    private JLabel poolLabel;
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

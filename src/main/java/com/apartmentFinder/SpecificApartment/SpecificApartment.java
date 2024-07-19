package com.apartmentFinder.SpecificApartment;

import com.apartmentFinder.components.utils.DBConnector;
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
    private JLabel pageTitle;
    private JButton backToApartmentList;
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

        // Fetch the unit details from the database
        fetchUnitDetails(apartmentId, unitID);

        // Action Listeners
        backToApartmentList.addActionListener(e->{
            cardLayout.show(container, "apartmentListPage");
        });
    }

    // Fetch the unit details from the database
    public LinkedList<Unit> fetchUnitDetails(int apartmentId, int unitID){
        DBConnector dbConnector = new DBConnector();
        unit = dbConnector.fetchSpecificApartment(apartmentId, unitID);

        //Set the fetched data to the UI components
        if(unit.size() > 0){
            Unit unitData = unit.get(0);
            pageTitle.setText(unitData.getLocationDescription());
            DescriptionText.setText("This is a "+unitData.getBedrooms()+"-bedroomed apartment with "+unitData.getBathrooms()+" bathroom(s).");
        }
        return unit;
    }
    public JPanel createMainPanel(){
        return mainPanel;
    }
}

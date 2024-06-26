package com.apartmentFinder.addApartmentPage;

import javax.swing.*;
import java.awt.*;

public class AddApartmentPage {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AddApartmentPage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

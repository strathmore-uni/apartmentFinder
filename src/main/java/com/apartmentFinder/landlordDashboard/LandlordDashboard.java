package com.apartmentFinder.landlordDashboard;

import javax.swing.*;
import java.awt.*;

public class LandlordDashboard {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public LandlordDashboard(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

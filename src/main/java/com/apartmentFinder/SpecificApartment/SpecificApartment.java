package com.apartmentFinder.SpecificApartment;

import javax.swing.*;
import java.awt.*;

public class SpecificApartment {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SpecificApartment(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

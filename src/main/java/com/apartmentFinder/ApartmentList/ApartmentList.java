package com.apartmentFinder.ApartmentList;

import javax.swing.*;
import java.awt.*;

public class ApartmentList {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JTextField searchALocation;
    private JComboBox comboBox1;
    private JButton button1;

    public ApartmentList(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

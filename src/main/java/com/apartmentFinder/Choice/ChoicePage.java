package com.apartmentFinder.Choice;

import javax.swing.*;
import java.awt.*;

public class ChoicePage {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JLabel subtitle;
    private JButton addApartmentButton;
    private JButton button1;
    private JTextField searchALocation;
    private JComboBox comboBox1;

    public ChoicePage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

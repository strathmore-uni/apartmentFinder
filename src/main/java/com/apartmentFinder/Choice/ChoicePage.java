package com.apartmentFinder.Choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoicePage implements ActionListener {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel title;
    private JLabel subtitle;
    private JButton addApartmentButton;
    private JButton searchForApartment;
    private JTextField searchALocation;
    private JComboBox comboBox1;

    public ChoicePage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // search an apartment button
//        if(e.getSource() == searchForApartment){
//            System.out.println("Searc");
//            cardLayout.show(container,"apartmentListPage");
//        }

    }


}

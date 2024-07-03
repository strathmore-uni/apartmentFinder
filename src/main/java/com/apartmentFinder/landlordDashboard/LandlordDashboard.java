package com.apartmentFinder.landlordDashboard;

import javax.swing.*;
import java.awt.*;


public class LandlordDashboard{
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton addApartmentButton;
    private JComboBox Units;
    private JButton button2;
    private JButton button1;

    public LandlordDashboard(Container container, CardLayout cardLayout){

        this.container = container;
        this.cardLayout = cardLayout;
        comboBoxDisplay();
    }

    private void comboBoxDisplay(){
        Units.setSelectedIndex(-1);
        Units.setRenderer(new DefaultListCellRenderer() {
            @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
                if (value == null && index == -1){
                    setText("          Units");
                } else {
                    setText(value.toString());
                }
                return this;
            }
        });
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }

}

package com.apartmentFinder.landlordDashboard;

import com.apartmentFinder.components.utils.DBConnector;
import com.apartmentFinder.components.utils.LandlordDashboardData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LandlordDashboard extends JFrame{
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton addApartmentButton;
    private JComboBox Units;
    private JButton deleteButton;
    private JButton button1;
    private JLabel welcomeText;
    private JLabel propertyName;
    private JLabel contact;
    private String userNumber;
    private DBConnector dbConnector;

//    public LandlordDashboard(Container container, CardLayout cardLayout){
//
//        this.container = container;
//        this.cardLayout = cardLayout;
//    }
    public LandlordDashboard(String userNumber){
        super("Landlord Dashboard");
        setExtendedState(LandlordDashboard.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        LandlordDashboardData landlordDashboardData=dbConnector.fetchLandlordDashboardData(userNumber);

        this.userNumber=userNumber;
        this.dbConnector=new DBConnector();
        fetchData(userNumber);
        comboBoxDisplay();
        deleteData(landlordDashboardData.getApartmentid());
    }

    private void fetchData(String number){
        System.out.println("we have "+number);
        LandlordDashboardData landlordDashboardData=dbConnector.fetchLandlordDashboardData(number);
        System.out.println("Success");
        welcomeText.setText("Welcome "+landlordDashboardData.getUserName());
        propertyName.setText(landlordDashboardData.getApartmentname());
        Units.addItem("KES. "+landlordDashboardData.getUserPrice()+"/month");
        Units.addItem(landlordDashboardData.getUserBedroom()+" bedroom(s)");
        Units.addItem(landlordDashboardData.getUserBathroom()+" bathroom(s)");
        Units.addItem(landlordDashboardData.getUserSqft()+" Square foot");
        contact.setText(landlordDashboardData.getUserNumber());
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

    private void deleteData(String apartmentID){
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog(null,"Are you sure all data will be lost","Confirm Deletion",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    dbConnector.DeleteDashboardData(apartmentID);
                    System.out.println("Removed Data");
                }
            }
        });
    }
    public JPanel createMainPanel(){
        return mainPanel;
    }

}

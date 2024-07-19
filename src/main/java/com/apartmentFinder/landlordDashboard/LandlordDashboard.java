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
    private JButton updateButton;
    private JLabel welcomeText;
    private JLabel propertyName;
    private JLabel contact;
    private JPanel dataDisplay;
    private JPanel buttons;
    private String userNumber;
    private DBConnector dbConnector;

//    public LandlordDashboard(Container container, CardLayout cardLayout){
//
//
//    }
    public LandlordDashboard(Container container, CardLayout cardLayout,String userNumber){
        this.container = container;
        this.cardLayout = cardLayout;
//        super("Landlord Dashboard");
//        setExtendedState(LandlordDashboard.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setContentPane(mainPanel);



        this.userNumber=userNumber;
        this.dbConnector=new DBConnector();

        fetchData(userNumber);
        comboBoxDisplay();
        navigateToAddApartment();
    }

    private void fetchData(String number){
        try {
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
            deleteData(landlordDashboardData.getApartmentid());
            updateData(landlordDashboardData.getApartmentname(),landlordDashboardData.getUserPrice(),landlordDashboardData.getUserBedroom(),landlordDashboardData.getUserBathroom(),landlordDashboardData.getUserSqft(),landlordDashboardData.getApartmentid(),landlordDashboardData.getUserNumber());
        }catch (NullPointerException e){
            dataDisplay.removeAll();
            dataDisplay.revalidate();
            dataDisplay.repaint();
        }
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
                    dataDisplay.removeAll();
                    dataDisplay.revalidate();
                    dataDisplay.repaint();
                }
            }
        });
    }
    private void updateData(String apartmentname, String price, String bedroom, String bathroom,String sqft,String  aptid,String number){
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog editData=new JDialog();
                editData.setTitle("Edit information");

                JPanel editInformation =new JPanel();
                editInformation.setLayout(new GridLayout(8,2));

                JTextField APTNAME=new JTextField(apartmentname,20);
                JTextField PRICE=new JTextField(price,20);
                JTextField BEDROOM=new JTextField(bedroom,20);
                JTextField BATHROOM=new JTextField(bathroom,20);
                JTextField SQFT=new JTextField(sqft,20);
                JButton saveButton=new JButton("Save changes");
                JButton cancelButton=new JButton("Cancel");

                editInformation.add(new JLabel("Apartment name"));
                editInformation.add(APTNAME);
                editInformation.add(new JLabel("Price"));
                editInformation.add(PRICE);
                editInformation.add(new JLabel("Bedroom"));
                editInformation.add(BEDROOM);
                editInformation.add(new JLabel("Bathroom"));
                editInformation.add(BATHROOM);
                editInformation.add(new JLabel("Square foot"));
                editInformation.add(SQFT);
                editInformation.add(saveButton);
                editInformation.add(cancelButton);

                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window window=SwingUtilities.getWindowAncestor(editInformation);
                        if(window!=null){
                            window.dispose();
                        }
                    }
                });
                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String updtAPTNAME=APTNAME.getText();
                            double updtPRICE=Double.parseDouble(PRICE.getText());
                            int updtBEDROOM=Integer.parseInt(BEDROOM.getText());
                            int updtBATHROOM=Integer.parseInt(BATHROOM.getText());
                            int updtSQRT=Integer.parseInt(SQFT.getText());
                            int updtaptid=Integer.parseInt(aptid);
                            dbConnector.UpdateDashboardData(updtAPTNAME,updtPRICE,updtBEDROOM,updtBATHROOM,updtSQRT,updtaptid);
                            fetchData(number);
                            Window window=SwingUtilities.getWindowAncestor(editInformation);
                            if(window!=null){
                                window.dispose();
                            }
                        }catch (Exception A){
                            A.printStackTrace();
                        }
                    }
                });
                editData.add(editInformation);
                editData.pack();
                editData.setLocationRelativeTo(null);
                editData.setVisible(true);
            }
        });
    }
    private void navigateToAddApartment(){
        addApartmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container,"addApartmentPage");
            }
        });
    }
    public JPanel createMainPanel(){
        return mainPanel;
    }

}

package com.apartmentFinder.LoginPage;

import com.apartmentFinder.components.utils.DBConnector;
import com.apartmentFinder.landlordDashboard.LandlordDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Vector;

public class LoginPage extends JFrame{
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton loginButton;
    private JTextField EnterPhoneNumber;

    public LoginPage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;

        placeholderText();
        login();

    }
    private void placeholderText(){
        EnterPhoneNumber.addFocusListener(new FocusAdapter() {

        @Override
        public void focusGained(FocusEvent e) {
            if (EnterPhoneNumber.getText().equals("e.g 0712345678")) {
                EnterPhoneNumber.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (EnterPhoneNumber.getText().isEmpty()) {
                EnterPhoneNumber.setText("e.g 0712345678");
            }
        }
    });
    }
    private void login(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBConnector dbConnector =new DBConnector();
                String verifyNumber=EnterPhoneNumber.getText();
                if(dbConnector.checkUserForLogin(verifyNumber)){
                    JOptionPane.showMessageDialog(null, "Welcome "+dbConnector.getUserName(verifyNumber));
                    LandlordDashboard landlordDashboard=new LandlordDashboard(container,cardLayout,verifyNumber);
                    container.add("landlordDashboard",landlordDashboard.createMainPanel());
                    cardLayout.show(container,"landlordDashboard");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Number not found!");
                }
            }
        });
    }



    public JPanel createMainPanel(){
        return mainPanel;
    }
}

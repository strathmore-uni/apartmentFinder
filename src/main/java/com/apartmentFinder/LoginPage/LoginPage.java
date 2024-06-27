package com.apartmentFinder.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPage {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton button1;
    private JTextField EnterPhoneNumber;

    public LoginPage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
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

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

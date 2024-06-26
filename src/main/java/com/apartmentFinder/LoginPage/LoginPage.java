package com.apartmentFinder.LoginPage;

import javax.swing.*;
import java.awt.*;

public class LoginPage {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public LoginPage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

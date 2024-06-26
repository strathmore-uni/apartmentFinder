package com.apartmentFinder.Choice;

import javax.swing.*;
import java.awt.*;

public class ChoicePage {
    private Container container;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ChoicePage(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel createMainPanel(){
        return mainPanel;
    }
}

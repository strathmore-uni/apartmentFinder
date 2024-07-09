package com.apartmentFinder.ApartmentList.components;

import javax.swing.*;
import java.awt.*;

public class ApartmentCardJava {
    private JPanel mainPanel;
    private JPanel card;
    private JLabel card_image;
    private JPanel card_content;
    private JButton view_button;
    private JPanel card_bedrooms;
    private JLabel bedroom_number;
    private JLabel bedroom_label;
    private JLabel bedroom_icon;
    private JPanel card_bathrooms;
    private JLabel bathroom_number;
    private JLabel bathroom_label;
    private JLabel bathroom_icon;
    private JPanel card_price;
    private JLabel price_currency;
    private JLabel price_number;
    private JLabel price_duration;
    private JLabel location_label;

    public ApartmentCardJava() {
        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(-13158601));

        // Card Panel
        card = new JPanel();
        card.setLayout(new GridBagLayout());
        card.setBackground(new Color(-13158601));
        mainPanel.add(card, BorderLayout.CENTER);

        // Card Image
        card_image = new JLabel();
        card_image.setIcon(new ImageIcon(getClass().getResource("/icons/bg.png")));
        GridBagConstraints gbc_card_image = new GridBagConstraints();
        gbc_card_image.gridx = 0;
        gbc_card_image.gridy = 0;
        gbc_card_image.fill = GridBagConstraints.BOTH;
        card.add(card_image, gbc_card_image);

        // Card Content
        card_content = new JPanel();
        card_content.setLayout(new GridBagLayout());
        card_content.setBackground(new Color(-8224126));
        GridBagConstraints gbc_card_content = new GridBagConstraints();
        gbc_card_content.gridx = 0;
        gbc_card_content.gridy = 1;
        gbc_card_content.fill = GridBagConstraints.BOTH;
        card.add(card_content, gbc_card_content);

        // View Button
        view_button = new JButton("View");
        view_button.setBackground(new Color(-8224126));
        view_button.setFont(new Font("Default", Font.PLAIN, 20));
        view_button.setForeground(new Color(-855310));
        view_button.setIcon(new ImageIcon(getClass().getResource("/icons/view.png")));
        GridBagConstraints gbc_view_button = new GridBagConstraints();
        gbc_view_button.gridx = 1;
        gbc_view_button.gridy = 3;
        gbc_view_button.gridwidth = 6;
        gbc_view_button.fill = GridBagConstraints.HORIZONTAL;
        card_content.add(view_button, gbc_view_button);

        // Card Bedrooms
        card_bedrooms = new JPanel();
        card_bedrooms.setLayout(new GridBagLayout());
        card_bedrooms.setBackground(new Color(-8224126));
        GridBagConstraints gbc_card_bedrooms = new GridBagConstraints();
        gbc_card_bedrooms.gridx = 0;
        gbc_card_bedrooms.gridy = 1;
        gbc_card_bedrooms.gridwidth = 2;
        gbc_card_bedrooms.fill = GridBagConstraints.HORIZONTAL;
        card_content.add(card_bedrooms, gbc_card_bedrooms);

        bedroom_icon = new JLabel();
        bedroom_icon.setIcon(new ImageIcon(getClass().getResource("/icons/bed.png")));
        GridBagConstraints gbc_bedroom_icon = new GridBagConstraints();
        gbc_bedroom_icon.gridx = 0;
        gbc_bedroom_icon.gridy = 0;
        card_bedrooms.add(bedroom_icon, gbc_bedroom_icon);

        bedroom_number = new JLabel("2");
        bedroom_number.setFont(new Font("Default", Font.PLAIN, 22));
        bedroom_number.setForeground(new Color(-855310));
        GridBagConstraints gbc_bedroom_number = new GridBagConstraints();
        gbc_bedroom_number.gridx = 1;
        gbc_bedroom_number.gridy = 0;
        card_bedrooms.add(bedroom_number, gbc_bedroom_number);

        bedroom_label = new JLabel("bedroom(s)");
        bedroom_label.setFont(new Font("Default", Font.PLAIN, 22));
        bedroom_label.setForeground(new Color(-855310));
        GridBagConstraints gbc_bedroom_label = new GridBagConstraints();
        gbc_bedroom_label.gridx = 2;
        gbc_bedroom_label.gridy = 0;
        card_bedrooms.add(bedroom_label, gbc_bedroom_label);

        // Card Bathrooms
        card_bathrooms = new JPanel();
        card_bathrooms.setLayout(new GridBagLayout());
        card_bathrooms.setBackground(new Color(-8224126));
        GridBagConstraints gbc_card_bathrooms = new GridBagConstraints();
        gbc_card_bathrooms.gridx = 0;
        gbc_card_bathrooms.gridy = 2;
        gbc_card_bathrooms.gridwidth = 3;
        gbc_card_bathrooms.fill = GridBagConstraints.HORIZONTAL;
        card_content.add(card_bathrooms, gbc_card_bathrooms);

        bathroom_icon = new JLabel();
        bathroom_icon.setIcon(new ImageIcon(getClass().getResource("/icons/shower.png")));
        GridBagConstraints gbc_bathroom_icon = new GridBagConstraints();
        gbc_bathroom_icon.gridx = 0;
        gbc_bathroom_icon.gridy = 0;
        card_bathrooms.add(bathroom_icon, gbc_bathroom_icon);

        bathroom_number = new JLabel("2");
        bathroom_number.setFont(new Font("Default", Font.PLAIN, 22));
        bathroom_number.setForeground(new Color(-855310));
        GridBagConstraints gbc_bathroom_number = new GridBagConstraints();
        gbc_bathroom_number.gridx = 1;
        gbc_bathroom_number.gridy = 0;
        card_bathrooms.add(bathroom_number, gbc_bathroom_number);

        bathroom_label = new JLabel("bathroom(s)");
        bathroom_label.setFont(new Font("Default", Font.PLAIN, 22));
        bathroom_label.setForeground(new Color(-855310));
        GridBagConstraints gbc_bathroom_label = new GridBagConstraints();
        gbc_bathroom_label.gridx = 2;
        gbc_bathroom_label.gridy = 0;
        card_bathrooms.add(bathroom_label, gbc_bathroom_label);

        // Card Price
        card_price = new JPanel();
        card_price.setLayout(new GridBagLayout());
        card_price.setBackground(new Color(-8224126));
        card_price.setForeground(new Color(-855310));
        GridBagConstraints gbc_card_price = new GridBagConstraints();
        gbc_card_price.gridx = 0;
        gbc_card_price.gridy = 0;
        gbc_card_price.gridwidth = 4;
        card_content.add(card_price, gbc_card_price);

        price_currency = new JLabel("KES.");
        price_currency.setFont(new Font("Default", Font.PLAIN, 20));
        price_currency.setForeground(new Color(-855310));
        GridBagConstraints gbc_price_currency = new GridBagConstraints();
        gbc_price_currency.gridx = 1;
        gbc_price_currency.gridy = 0;
        card_price.add(price_currency, gbc_price_currency);

        price_number = new JLabel("18,000");
        price_number.setFont(new Font("Default", Font.PLAIN, 48));
        price_number.setForeground(new Color(-855310));
        GridBagConstraints gbc_price_number = new GridBagConstraints();
        gbc_price_number.gridx = 2;
        gbc_price_number.gridy = 0;
        card_price.add(price_number, gbc_price_number);

        price_duration = new JLabel("/month");
        price_duration.setFont(new Font("Default", Font.PLAIN, 20));
        price_duration.setForeground(new Color(-855310));
        GridBagConstraints gbc_price_duration = new GridBagConstraints();
        gbc_price_duration.gridx = 3;
        gbc_price_duration.gridy = 0;
        card_price.add(price_duration, gbc_price_duration);

        // Location Label
        location_label = new JLabel("Nairobi, West");
        location_label.setFont(new Font("Default", Font.PLAIN, 22));
        location_label.setForeground(new Color(-855310));
        GridBagConstraints gbc_location_label = new GridBagConstraints();
        gbc_location_label.gridx = 1;
        gbc_location_label.gridy = 4;
        card_content.add(location_label, gbc_location_label);
    }

    public ApartmentCardJava(int apartmentID, int unitID) {
    }

//    Main function
public static void main(String[] args) {
    JFrame frame = new JFrame("ApartmentCardJava");
    // Create 5 cards - Gap between the cards, 4 cards each row. Create a list of data to populate the cards
    ApartmentCardJava[] cards = new ApartmentCardJava[10];
    for (int i = 0; i < 10; i++) {
        cards[i] = new ApartmentCardJava();
    }
    // Create a panel to hold the cards
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(0, 4, 10, 10));
    panel.setBackground(new Color(-13158601));
    for (int i = 0; i < 10; i++) {
        panel.add(cards[i].getMainPanel());
    }
    // Create a scroll pane to hold the panel
    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    frame.setContentPane(scrollPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

}
    public void setLocation_label(String locationDescription) {
        location_label.setText(locationDescription);
    }
    public void setBedroom_number(String bedrooms) {
        bedroom_number.setText(bedrooms);
    }
    public void setBathroom_number(String bathrooms) {
        bathroom_number.setText(bathrooms);
    }
    public void setPrice_number(String price) {
        price_number.setText(price);
}
    public JPanel getMainPanel() {
        return mainPanel;
    }
}


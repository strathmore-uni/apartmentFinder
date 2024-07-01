package com.apartmentFinder.ApartmentList.components;

import javax.swing.*;
import java.awt.*;

public class ApartmentCard{
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
    private JPanel mainPanel;
    private JLabel location_label;
    private int unit_id;
    private int apartment_id;

    public ApartmentCard(int apartment_id, int unit_id){
        this.unit_id = unit_id;
        this.apartment_id = apartment_id;
    }


    public JPanel getCard() {
        return card;
    }

    public void setCard(JPanel card) {
        this.card = card;
    }

    public JLabel getCard_image() {
        return card_image;
    }

    public void setCard_image(JLabel card_image) {
        this.card_image = card_image;
    }

    public JPanel getCard_content() {
        return card_content;
    }

    public void setCard_content(JPanel card_content) {
        this.card_content = card_content;
    }

    public JButton getView_button() {
        return view_button;
    }

    public void setView_button(JButton view_button) {
        this.view_button = view_button;
    }

    public JPanel getCard_bedrooms() {
        return card_bedrooms;
    }

    public void setCard_bedrooms(JPanel card_bedrooms) {
        this.card_bedrooms = card_bedrooms;
    }

    public JLabel getBedroom_number() {
        return bedroom_number;
    }

    public void setBedroom_number(String bedroom_number) {
        this.bedroom_number.setText(bedroom_number);
    }

    public JLabel getBedroom_label() {
        return bedroom_label;
    }

    public void setBedroom_label(JLabel bedroom_label) {
        this.bedroom_label = bedroom_label;
    }

    public JLabel getBedroom_icon() {
        return bedroom_icon;
    }

    public void setBedroom_icon(JLabel bedroom_icon) {
        this.bedroom_icon = bedroom_icon;
    }

    public JPanel getCard_bathrooms() {
        return card_bathrooms;
    }

    public void setCard_bathrooms(JPanel card_bathrooms) {
        this.card_bathrooms = card_bathrooms;
    }

    public JLabel getBathroom_number() {
        return bathroom_number;
    }

    public void setBathroom_number(String bathroom_number) {
        this.bathroom_number.setText(bathroom_number);
    }

    public JLabel getBathroom_label() {
        return bathroom_label;
    }

    public void setBathroom_label(JLabel bathroom_label) {
        this.bathroom_label = bathroom_label;
    }

    public JLabel getBathroom_icon() {
        return bathroom_icon;
    }

    public void setBathroom_icon(JLabel bathroom_icon) {
        this.bathroom_icon = bathroom_icon;
    }

    public JPanel getCard_price() {
        return card_price;
    }

    public void setCard_price(JPanel card_price) {
        this.card_price = card_price;
    }

    public JLabel getPrice_curreny() {
        return price_currency;
    }

    public void setPrice_curreny(JLabel price_curreny) {
        this.price_currency = price_curreny;
    }

    public JLabel getPrice_number() {
        return price_number;
    }

    public void setPrice_number(String price_number) {
        this.price_number.setText(price_number);
    }

    public JLabel getPrice_duration() {
        return price_duration;
    }

    public void setPrice_duration(JLabel price_duration) {
        this.price_duration = price_duration;
    }

    public JLabel getPrice_currency() {
        return price_currency;
    }

    public void setPrice_currency(JLabel price_currency) {
        this.price_currency = price_currency;
    }

    public JLabel getLocation_label() {
        return location_label;
    }

    public void setLocation_label(String location_label) {
        this.location_label.setText(location_label);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }


}

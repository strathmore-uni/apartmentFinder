package com.apartmentFinder.components.utils;


import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/*
 * Author : Braine Lomoni 168864 14/10/2023
 * Functionality :
 * - Clearing the placeholder text when the text field gains focus
 * - Setting the placeholder text when the text field loses focus and is empty
 */
public class InputFieldFocusListener extends FocusAdapter {
    private final JTextField textField;
    private final String PLACEHOLDER;
    private final String trimmedText;
    //Constructor
    public InputFieldFocusListener(JTextField textField, String PLACEHOLDER){
        this.textField = textField;
        this.PLACEHOLDER = PLACEHOLDER;
        //Store trimmed text in a variable
        trimmedText = textField.getText().trim();
    }
    @Override
    public void focusGained(FocusEvent e) {
        // If placeholder is Username...
        if(PLACEHOLDER.equals(trimmedText)){
            //Clear placeholder
            textField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        //If empty when unfocused
        if(textField.getText().trim().isEmpty()){
            //Set placeholder
            textField.setText(PLACEHOLDER);
        }
    }
}
package com.apartmentFinder.components.utils;


import javax.swing.*;
import java.awt.*;

/*
 * Author : Braine Lomoni 168864 22/10/2023
 * Functionality :
 * - Display a message dialog with a specified container and message
 */
public class apartmentFinderDialog{
    public static void showMessage(Container container,String message, String title, int messageType){
        try{
            /*
             * MESSAGE TYPE
             * 0 ERROR_MESSAGE
             * -1 PLAIN_MESSAGE
             * 1 INFORMATION_MESSAGE
             * 2 WARNING_MESSAGE
             */
            JOptionPane.showMessageDialog(container,message,title,messageType);
        }catch(Exception e){
            System.out.println("WARNING : Show message dialog init error"+e.getMessage());
        }
    }
}

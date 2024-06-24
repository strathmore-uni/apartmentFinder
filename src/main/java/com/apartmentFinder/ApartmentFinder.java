package com.apartmentFinder;

import javax.swing.*;
import java.awt.*;

import com.formdev.flatlaf.FlatIntelliJLaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;
public class ApartmentFinder {
    private static Logger logger;
    public static void main(String[] args) {

    }

    // Theme and Font
    public static void setThemeAndFont(){
        try{
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            UIManager.put("defaultFont", new Font("Inter", Font.PLAIN, 16));
        } catch(Exception exception){
            Log("FATAL","Failed to apply theme : "+ exception.getMessage(), exception,ApartmentFinder.class.getName());
        }
    }

    // Logger util - keep track of messages
    public static void Log(String level, String info, Exception exception, String className){
            try {
                if (!className.isEmpty()) {
                    logger = LogManager.getLogger(className);
                } else {
                    Objects.requireNonNull(className, "className must not be null");
                }
            } catch(Exception e){
                Log("FATAL","className must not be null", e,ApartmentFinder.class.getName());
            }
            switch(level){
                case "DEBUG":
                    logger.debug(info, exception);
                    break;
                case "INFO":
                    logger.info(info, exception);
                    break;
                case "WARN":
                    logger.warn(info, exception);
                    break;
                case "ERROR":
                    logger.error(info, exception);
                    break;
                case "FATAL":
                    logger.fatal(info, exception);
                    break;
                case "TRACE":
                    logger.trace(info, exception);
                    break;
                default:
                    logger.warn("Unrecognized severity level "+level);
                    break;
            }
        }

    // Dialog box
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
            Log("WARN","Show message dialog init error"+e.getMessage(),e,ApartmentFinder.class.getName());
        }
    }
}

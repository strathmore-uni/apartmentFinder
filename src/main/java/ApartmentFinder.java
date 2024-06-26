import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class ApartmentFinder extends JFrame  {
    ApartmentFinder(){
        super("Apartment Finder");
        setThemeAndFont();
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(null);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize(); this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        Template template = new Template();
        setContentPane(template.getMainPanel());
    }

    public static void main(String[] args) {
        ApartmentFinder main = new ApartmentFinder();
        main.setVisible(true);
    }


    // Theme
    public static void setThemeAndFont(){
        try{
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            // Customizing based on Figma design
            UIManager.put("defaultFont", new Font("Inter", Font.PLAIN, 16));
            UIManager.put("Button.background",new Color(130, 130, 130));
            UIManager.put("Button.foreground", Color.WHITE);
        } catch(Exception exception){
            // Basic logging in stead of Logging
            System.out.println("Error setting up theme :"+exception);
        }
    }
}

import com.apartmentFinder.ApartmentList.ApartmentList;
import com.apartmentFinder.Choice.ChoicePage;
import com.apartmentFinder.LoginPage.LoginPage;
import com.apartmentFinder.SpecificApartment.SpecificApartment;
import com.apartmentFinder.addApartmentPage.AddApartmentPage;
import com.apartmentFinder.landlordDashboard.LandlordDashboard;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class ApartmentFinder extends JFrame  {
    ApartmentFinder(){
        super("Apartment Finder | Find your next apartment");
        setThemeAndFont();
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //Create CardLayout object to switch between different panels on the same frame
        CardLayout cardLayout = new CardLayout();
        Container container = getContentPane();
        container.setLayout(cardLayout);

        //Pages
        // 1. Add Apartment Page
        AddApartmentPage addApartmentPage = new AddApartmentPage(container,cardLayout);
        // 2. Apartment List Page
        ApartmentList apartmentListPage = new ApartmentList(container,cardLayout);
        // 3. ChoicePage Page
        ChoicePage choicePage = new ChoicePage(container, cardLayout);
        // 4. LandLord Dashboard Page
        LandlordDashboard landlordDashboard = new LandlordDashboard(container,cardLayout);
        // 5. Login Page
        LoginPage loginPage = new LoginPage(container, cardLayout);
        // 6. Specific Apartment Page
        SpecificApartment specificApartmentPage = new SpecificApartment(container, cardLayout);
        // Dev Page
        Template template = new Template(container, cardLayout);

        container.add("addApartmentPage",addApartmentPage.createMainPanel());
        container.add("apartmentListPage",apartmentListPage.createMainPanel());
        container.add("choicePage",choicePage.createMainPanel());
        container.add("landlordDashboardPage",landlordDashboard.createMainPanel());
        container.add("loginPage",loginPage.createMainPanel());
        container.add("specificApartmentPage",specificApartmentPage.createMainPanel());
        // Template Page For Dev Purposes
        container.add("templatePage",template.getMainPanel());

        // Set the first page to display - choicePage
        cardLayout.show(container,"choicePage");
        // cardLayout.show(container,"apartmentListPage");
        // Template Page
        //        cardLayout.show(container,"templatePage");
        setContentPane(container);

        setSize(1400,600);
        // Set the image in the middle of the screen
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize(); this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
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

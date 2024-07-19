package HouseHunting;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI updates are done on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and display the ApartmentFinder JFrame
                new ApartmentFinder().setVisible(true);
            }
        });
    }
}
